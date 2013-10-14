package ncr.inventory.snmp;

import org.apache.log4j.Logger;

import uk.co.westhawk.snmp.pdu.GetNextPdu_vec;
import uk.co.westhawk.snmp.pdu.GetPdu_vec;
import uk.co.westhawk.snmp.stack.AsnObject;
import uk.co.westhawk.snmp.stack.AsnOctets;
import uk.co.westhawk.snmp.stack.Pdu;
import uk.co.westhawk.snmp.stack.SetPdu;
import uk.co.westhawk.snmp.stack.SnmpContext;
import uk.co.westhawk.snmp.stack.varbind;

public class SNMPUtils extends Object implements java.util.Observer {

    private SnmpContext context = null;
    private String ultimoError = null;
    private static final int TIEMPO_MAXIMO_ESPERA = 60 * 200;
    // 5 milésimas de segundo
    varbind results[] = null;

    static Logger logger = Logger.getLogger(SNMPData.class.getName());

    public SNMPUtils(String agent, String community, int port) {
	try {
	    context = new SnmpContext(agent, port);
	    context.setCommunity(community);
	} catch (Exception e) {
	    ultimoError = "La dirección " + agent + " no es conocida";
	    logger.error(ultimoError);
	}
    }

    public String getUltimoError() {
	return ultimoError;
    }

    public varbind getNext(String oid) {
	String[] oids = { oid };
	varbind[] result = getNext(oids);
	if (result != null)
	    return result[0];
	else
	    return null;
    }

    public varbind[] getNext(String[] oids) {
	GetNextPdu_vec pdu = new GetNextPdu_vec(context, oids.length);
	return ejecutaComando(pdu, oids);
    }

    public varbind get(String oid) {
	String[] oids = { oid };
	varbind[] result = get(oids);
	if (result != null)
	    return result[0];
	else
	    return null;
    }

    public varbind[] get(String[] oids) {
	GetPdu_vec pdu = new GetPdu_vec(context, oids.length);
	return ejecutaComando(pdu, oids);
    }

    public void set(String action, AsnObject varSet) {
		ultimoError = null;
		SetPdu setPdu = new SetPdu(context);
		AsnObject obj = new AsnOctets(action);
		setPdu.addOid("1.3.6.1.4.1.191.117.27.100.0", obj);
		if (context != null) {
		    setPdu.addObserver(this);
		    try {
		    	setPdu.send();
				try {
				    Thread.sleep(100);
				} catch (Exception e) {
				    ultimoError = "Error en la espera";
				    logger.error(ultimoError);
				}
		    } catch (java.io.IOException e) {
				ultimoError = "No es posible enviar la peticion al servidor";
				logger.error(ultimoError);
		    } catch (uk.co.westhawk.snmp.stack.PduException e) {
				ultimoError = "Error interno: " + e.toString();
				logger.error(ultimoError);
		    } catch (Exception ex) {
				ultimoError = "Excepcion: " + ex.toString();
				logger.error(ultimoError);
		    }
		}
    }

    private varbind[] ejecutaComando(Pdu pdu, String[] oids) {
	results = null;
	ultimoError = null;
	if (context != null) {

	    pdu.addObserver(this);
	    for (int i = 0; i < oids.length; i++)
		pdu.addOid(oids[i]);
	    try {
		pdu.send();

		int t = 0;
		while ((results == null) && (ultimoError == null)
			&& (t < TIEMPO_MAXIMO_ESPERA)) {
		    try {
			Thread.sleep(5);
			t++;
		    } catch (Exception e) {
			ultimoError = "Error en la espera";
			logger.error(ultimoError);
		    }
		}
	    } catch (java.io.IOException e) {
		ultimoError = "No es posible enviar la petici�n al servidor";
		logger.error(ultimoError);
	    } catch (uk.co.westhawk.snmp.stack.PduException e) {
		ultimoError = "Error interno: " + e.toString();
		logger.error(ultimoError);
	    } catch (Exception ex) {
		ultimoError = "Excepcion: " + ex.toString();
		logger.error(ultimoError);
	    }

	}
	return results;
    }

    public void update(java.util.Observable p1, java.lang.Object p2) {
	try {
	    results = (varbind[]) p2;
	} catch (ClassCastException e) {
	    ultimoError = "Error durante la recepci�n de la respuesta: "
		    + p2.toString();
	    if (p2.toString().indexOf("No such name error") >= 0) {
		logger.warn(ultimoError);
	    } else
		logger.error(ultimoError);
	}
	return;
    }

    public void liberaRecursos() {
	if (context != null)
	    context.destroy();
    }

}
