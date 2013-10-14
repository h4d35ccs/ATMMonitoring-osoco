package ncr.inventory.data;

public class USBController
{
	private String name				= null;
	private String caption			= null;
	private String deviceID		= null;
	private String manufacturer		= null;
	private String protocolSupported			= null;
	private String status		= null;
	
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
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getProtocolSupported() {
		return protocolSupported;
	}
	public void setProtocolSupported(String protocolSupported) {
		this.protocolSupported = protocolSupported;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}