package ncr.inventory.data;

public class SerialPort
{
	private String name				= null;
	private String caption			= null;
	private String deviceID		= null;
	private String maxBaudRate		= null;
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
	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	public String getMaxBaudRate() {
		return maxBaudRate;
	}
	public void setMaxBaudRate(String maxBaudRate) {
		this.maxBaudRate = maxBaudRate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}