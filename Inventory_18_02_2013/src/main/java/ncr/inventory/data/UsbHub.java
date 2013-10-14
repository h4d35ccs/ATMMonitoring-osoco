package ncr.inventory.data;

public class UsbHub
{
	private String numberOfPorts				= null;
	private String name			= null;
	private String protocolCode		= null;
	private String description		= null;
	private String usbVersion			= null;
	private String status		= null;
	
	
	public String getNumberOfPorts() {
		return numberOfPorts;
	}
	public void setNumberOfPorts(String numberOfPorts) {
		this.numberOfPorts = numberOfPorts;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProtocolCode() {
		return protocolCode;
	}
	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUsbVersion() {
		return usbVersion;
	}
	public void setUsbVersion(String usbVersion) {
		this.usbVersion = usbVersion;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}