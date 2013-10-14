package ncr.inventory.data;

public class Processor
{
	private String name				= null;
	private String caption			= null;
	private String manufacturer		= null;
	private String architecture		= null;
	private String currentClockSpeed			= null;
	private String maxClockSpeed		= null;
	private String extClock		= null;
	private String numberOfCores		= null;
	private String addressWidth		= null;
	private String dataWidth		= null;
	private String status			= null;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getArchitecture() {
		return architecture;
	}
	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}
	public String getCurrentClockSpeed() {
		return currentClockSpeed;
	}
	public void setCurrentClockSpeed(String currentClockSpeed) {
		this.currentClockSpeed = currentClockSpeed;
	}
	public String getMaxClockSpeed() {
		return maxClockSpeed;
	}
	public void setMaxClockSpeed(String maxClockSpeed) {
		this.maxClockSpeed = maxClockSpeed;
	}
	public String getExtClock() {
		return extClock;
	}
	public void setExtClock(String extClock) {
		this.extClock = extClock;
	}
	public String getNumberOfCores() {
		return numberOfCores;
	}
	public void setNumberOfCores(String numberOfCores) {
		this.numberOfCores = numberOfCores;
	}
	public String getAddressWidth() {
		return addressWidth;
	}
	public void setAddressWidth(String addressWidth) {
		this.addressWidth = addressWidth;
	}
	public String getDataWidth() {
		return dataWidth;
	}
	public void setDataWidth(String dataWidth) {
		this.dataWidth = dataWidth;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}