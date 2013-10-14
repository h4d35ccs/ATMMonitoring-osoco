package ncr.inventory.data;

public class Terminal
{
	private String terminalType				= null;
	private String terminalVendor			= null;
	private String frontReplenish		= null;
	private String geographicAddress		= null;
	private String manufacturingSite			= null;
	private String model		= null;
	private String productClass		= null;
	private String productClassDescription		= null;
	private String serialNumber		= null;
	private String tracerNumber		= null;
	
	public void setTerminalType (String terminalType){
		this.terminalType = terminalType;
	}
	
	public void setTerminalVendor (String terminalVendor){
		this.terminalVendor = terminalVendor;
	}
	
	public void setFrontReplenish (String frontReplenish){
		this.frontReplenish = frontReplenish;
	}
	
	public void setGeographicAddress (String geographicAddress){
		this.geographicAddress = geographicAddress;
	}
	
	public void setManufacturingSite (String manufacturingSite){
		this.manufacturingSite = manufacturingSite;
	}
	
	public void setModel (String model){
		this.model = model;
	}
	
	public void setProductClass (String productClass){
		this.productClass = productClass;
	}
	
	public void setProductClassDescription (String productClassDescription){
		this.productClassDescription = productClassDescription;
	}
	
	public void setSerialNumber (String serialNumber){
		this.serialNumber = serialNumber;
	}
	
	public void setTracerNumber (String tracerNumber){
		this.tracerNumber = tracerNumber;
	}

	public String getTerminalType() {
	    return terminalType;
	}

	public String getTerminalVendor() {
	    return terminalVendor;
	}

	public String getFrontReplenish() {
	    return frontReplenish;
	}

	public String getGeographicAddress() {
	    return geographicAddress;
	}

	public String getManufacturingSite() {
	    return manufacturingSite;
	}

	public String getModel() {
	    return model;
	}

	public String getProductClass() {
	    return productClass;
	}

	public String getProductClassDescription() {
	    return productClassDescription;
	}

	public String getSerialNumber() {
	    return serialNumber;
	}

	public String getTracerNumber() {
	    return tracerNumber;
	}
}