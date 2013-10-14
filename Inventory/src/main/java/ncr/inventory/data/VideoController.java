package ncr.inventory.data;

public class VideoController
{
	private String name				= null;
	private String description			= null;
	private String videoProcessor		= null;
	private String adapterRAM		= null;
	private String currentBitsPerPixel			= null;
	private String currentNumberOfColors		= null;
	private String currentHorizontalResolution		= null;
	private String currentVerticalResolution		= null;
	private String currentRefreshRate		= null;
	
	
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
	public String getVideoProcessor() {
		return videoProcessor;
	}
	public void setVideoProcessor(String videoProcessor) {
		this.videoProcessor = videoProcessor;
	}
	public String getAdapterRAM() {
		return adapterRAM;
	}
	public void setAdapterRAM(String adapterRAM) {
		this.adapterRAM = adapterRAM;
	}
	public String getCurrentBitsPerPixel() {
		return currentBitsPerPixel;
	}
	public void setCurrentBitsPerPixel(String currentBitsPerPixel) {
		this.currentBitsPerPixel = currentBitsPerPixel;
	}
	public String getCurrentNumberOfColors() {
		return currentNumberOfColors;
	}
	public void setCurrentNumberOfColors(String currentNumberOfColors) {
		this.currentNumberOfColors = currentNumberOfColors;
	}
	public String getCurrentHorizontalResolution() {
		return currentHorizontalResolution;
	}
	public void setCurrentHorizontalResolution(
			String currentHorizontalResolution) {
		this.currentHorizontalResolution = currentHorizontalResolution;
	}
	public String getCurrentVerticalResolution() {
		return currentVerticalResolution;
	}
	public void setCurrentVerticalResolution(String currentVerticalResolution) {
		this.currentVerticalResolution = currentVerticalResolution;
	}
	public String getCurrentRefreshRate() {
		return currentRefreshRate;
	}
	public void setCurrentRefreshRate(String currentRefreshRate) {
		this.currentRefreshRate = currentRefreshRate;
	}
	
}