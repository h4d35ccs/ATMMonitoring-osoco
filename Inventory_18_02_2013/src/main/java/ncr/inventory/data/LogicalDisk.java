package ncr.inventory.data;

public class LogicalDisk
{
	private String name				= null;
	private String description			= null;
	private String caption		= null;
	private String deviceID		= null;
	private String size			= null;
	private String freeSpace		= null;
	private String fileSystem		= null;
	private String volumeName		= null;
	private String volumeSerialNumber		= null;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getFreeSpace() {
		return freeSpace;
	}
	public void setFreeSpace(String freeSpace) {
		this.freeSpace = freeSpace;
	}
	public String getFileSystem() {
		return fileSystem;
	}
	public void setFileSystem(String fileSystem) {
		this.fileSystem = fileSystem;
	}
	public String getVolumeName() {
		return volumeName;
	}
	public void setVolumeName(String volumeName) {
		this.volumeName = volumeName;
	}
	public String getVolumeSerialNumber() {
		return volumeSerialNumber;
	}
	public void setVolumeSerialNumber(String volumeSerialNumber) {
		this.volumeSerialNumber = volumeSerialNumber;
	}
	
}