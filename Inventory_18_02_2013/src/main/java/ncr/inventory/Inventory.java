package ncr.inventory;

import java.io.File;
import java.io.IOException;

import ncr.inventory.data.ATM;
import ncr.inventory.snmp.SNMPData;
import ncr.inventory.snmp.Util;

import org.apache.log4j.Logger;

import uk.co.westhawk.snmp.event.RawPduEvent;
import uk.co.westhawk.snmp.event.RawPduListener;
import uk.co.westhawk.snmp.stack.DecodingException;
import uk.co.westhawk.snmp.stack.ListeningContextPool;
import uk.co.westhawk.snmp.stack.Pdu;
import uk.co.westhawk.snmp.stack.PduException;
import uk.co.westhawk.snmp.stack.SnmpContext;
import uk.co.westhawk.snmp.stack.SnmpContextBasisFace;
import uk.co.westhawk.snmp.stack.TrapPduv1;
import uk.co.westhawk.snmp.stack.varbind;
import uk.co.westhawk.snmp.util.SnmpUtilities;

public class Inventory implements RawPduListener {
    protected static Logger logger = Logger
	    .getLogger(Inventory.class.getName());
    protected SnmpContext context;
    protected String community;
    protected Util util;
    protected ListeningContextPool defTrap = null;
    protected int port1;
    protected int port2;

    public Inventory(String propertiesFilename) {

    	//Eva - 14/03/2013 - The INVENTORY_HOME gives the path for the inventory.properties file
    	String path = System.getenv("INVENTORY_HOME") + File.separator + propertiesFilename;
    	util = new Util(path, this.getClass().getName());
    	community = util.getCommunity();
    	port1 = util.getPort1(SnmpContextBasisFace.DEFAULT_PORT);
    	port2 = util.getPort2(ListeningContextPool.DEFAULT_TRAP_PORT);

    	System.out.println("Datos Properties: " + path + "\nCommunity:" + community + "  Port1:" + port1 + "  Port2:" + port2 + "  Host:" + util.getHost()
    			+ "  Bind:" + util.getBindAddress() + "  SocketType:" + util.getSocketType());
    }


    public void init() {

    	//Eva - 15/03/2013 - Bind should be null to avoid host detection problems
		String host = util.getHost();
		String bindAddr = util.getBindAddress();
		if((bindAddr.isEmpty() || (bindAddr.equalsIgnoreCase("null"))))
			bindAddr = null;
		String socketType = util.getSocketType();

    	try {
		    context = new SnmpContext(host, port1, bindAddr, socketType);
		    context.setCommunity(community);

		    // listen on port2
		    defTrap = new ListeningContextPool(port2, bindAddr, socketType);
		    defTrap.addUnhandledRawPduListener(this);

		    System.out.println("ReceiveTrap.init(): " + context.toString());
		    System.out.println("ReceiveTrap.init(): " + defTrap.toString());
		}
    	catch (java.io.IOException exc) {
			    System.out.println("ReceiveTrap.init(): IOException " + exc.getMessage());
			    exc.printStackTrace();
			    System.exit(0);
		}
    }

    @Override
    public void rawPduReceived(RawPduEvent evt) {
		System.out.println();
		System.out.println(getClass().getName() + ".rawPduReceived():");

		int port = evt.getHostPort();
		int version = evt.getVersion();
		String host = evt.getHostAddress();

		byte[] message = evt.getMessage();

		String hex = SnmpUtilities.toHexString(message);
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < hex.length(); i += 2) {
		    String str = hex.substring(i, i + 2);
		    output.append((char) Integer.parseInt(str, 16));
		}
		System.out.println(output);

		System.out.println("\traw pdu v "
			+ SnmpUtilities.getSnmpVersionString(version) + " from host "
			+ host + ", sent from port " + port + ", with message "
			+ message + "\t " + SnmpUtilities.toHexString(message));

		try {
		    TrapPduv1 pduFull = new TrapPduv1(context);
		    pduFull = (TrapPduv1) context.processIncomingPdu(message);
		    String sEnterpriseOID = pduFull.getEnterprise();

		    //Only listening to the requests for NCRInventory Community
		    if (sEnterpriseOID.equals("1.3.6.1.4.1.191.117")) {
				Pdu pdu = context.processIncomingPdu(message);
				try {
				    varbind[] result = pdu.getResponseVarbinds();
				    String ipATM = result[0].getValue().toString();
				    String macATM = result[1].getValue().toString();
				    System.out.println("Datos: IP:" + ipATM + " MAC:" + macATM);
				    //Thread.sleep(15000);
				    Thread.sleep(2000);
				    requestATMCurrentData(ipATM, macATM);
				} catch (PduException e) {
				    e.printStackTrace();
				} catch (InterruptedException e) {
				    e.printStackTrace();
				}
		    }

		} catch (DecodingException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
    }

    public void requestATMCurrentData(String ip, String mac) {
		ATM unit = new ATM(ip, mac);
		SNMPData data = new SNMPData(ip, community, port1);
		data.getData(unit);
		data.liberarRecursos();
		processReceivedATM(unit);
    }

    protected void processReceivedATM(ATM atm) {
	// We should write here the operations we want
	// to do onto the ATM.
    }

    // Send a trap to set the reset scheduler on
    public void setSchedulerResetOn(String host) {
		SNMPData data = new SNMPData(host, community, port1);
		data.setData("ResetOn");
		data.liberarRecursos();
    }

    // Send a trap to set the reset scheduler on/off
    public void setSchedulerResetOff(String host) {
		SNMPData data = new SNMPData(host, community, port1);
		data.setData("ResetOff");
		data.liberarRecursos();
    }

    // Send a trap to set an order to Update the ATM information.
    public void setSchedulerUpdate(String host) {
		SNMPData data = new SNMPData(host, community, port1);
		data.setData("Update");
		data.liberarRecursos();
    }

    public void destroy() {
		if (defTrap != null) {
		    defTrap.destroy();
		}
		if (context != null) {
		    context.destroy();
		}
    }
}
