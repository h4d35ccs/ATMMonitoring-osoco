package ncr.inventory.data;

public class Hotfix
{
	private String description				= null;
	private String hotfixID			= null;
	private String installedOn		= null;
	private String fixComments		= null;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHotfixID() {
		return hotfixID;
	}
	public void setHotfixID(String hotfixID) {
		this.hotfixID = hotfixID;
	}
	public String getInstalledOn() {
		return installedOn;
	}
	public void setInstalledOn(String installedOn) {
		this.installedOn = installedOn;
	}
	public String getFixComments() {
		return fixComments;
	}
	public void setFixComments(String fixComments) {
		this.fixComments = fixComments;
	}
}