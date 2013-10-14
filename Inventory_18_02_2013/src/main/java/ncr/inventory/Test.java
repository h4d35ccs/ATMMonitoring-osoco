package ncr.inventory;

import java.io.FileInputStream;
import java.util.Properties;

import ncr.inventory.data.ATM;

import org.apache.log4j.PropertyConfigurator;

public class Test extends Inventory {

    public Test(String propertiesFile) {
	super(propertiesFile);
    }

    public static void main(String args[]) {
		try {
		    try {
				// PropertyConfigurator.configure(args[0]);
				// Podría ir por argumento, pero de momento se lo ponemos a
				// capón
				PropertyConfigurator.configureAndWatch("X:\\Java Projects\\Inventory_23_01_2013\\Inventory.properties");
				// cada 60seg por defecto
				Properties p = new Properties();
				p.load(new FileInputStream("X:\\Java Projects\\Inventory_18_02_2013\\Inventory.properties"));
				logger.debug("Reading inventory properties file...");
				
				//Inventory inventario = new Inventory("X:\\Java Projects\\Inventory_18_02_2013\\InventoryTrap.properties");
				//Thread.currentThread().getContextClassLoader().getResource("InventoryTrap.properties").getPath();
				//String path = Thread.currentThread().getContextClassLoader().getResource("InventoryTrap.properties").getPath() + "InventoryTrap.properties";
				Inventory inventario = new Inventory("inventory.properties");
				inventario.init();
				inventario.setSchedulerUpdate("135.130.15.128"/*172.16.122.128*/);
				
				inventario.destroy();
				logger.debug("Finished...");
		
			} catch (Throwable th) {
			logger.error(th);
		    }
		} catch (Throwable th) {
		    logger.error(th);
		}
    }

    protected void processReceivedATM(ATM atm) {
	System.out.println("Processing ATM " + atm.getIp() + " !!!");
    }
}