package ncr.inventory.data;

public class OperatingSystem {
    private String name = null;
    private String ostype = null;
    private String manufacturer = null;
    private String serialnumber = null;
    private String version = null;
    private String oslanguage = null;
    private String spversion = null;
    private String organization = null;

    public void setName(String name) {
	this.name = name;
    }

    public void setOSType(String ostype) {
	this.ostype = ostype;
    }

    public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
    }

    public void setSerialNumber(String serialnumber) {
	this.serialnumber = serialnumber;
    }

    public void setVersion(String version) {
	this.version = version;
    }

    public void setOSLanguage(String oslanguage) {
	this.oslanguage = oslanguage;
    }

    public void setSPVersion(String spversion) {
	this.spversion = spversion;
    }

    public void setOrganization(String organization) {
	this.organization = organization;
    }

    public String getName() {
	return name;
    }

    public String getOstype() {
	return ostype;
    }

    public String getManufacturer() {
	return manufacturer;
    }

    public String getSerialnumber() {
	return serialnumber;
    }

    public String getVersion() {
	return version;
    }

    public String getOslanguage() {
	return oslanguage;
    }

    public String getSpversion() {
	return spversion;
    }

    public String getOrganization() {
	return organization;
    }
}