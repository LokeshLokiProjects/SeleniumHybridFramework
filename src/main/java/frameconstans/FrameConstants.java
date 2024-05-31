package frameconstans;

public enum FrameConstants {
	
	IMPLICTWAIT("30"),
	PAGELOADTIME("10"),
	EXTENTREPORTPATH(System.getProperty("user.dir")+"/src/test/resources/report/index.html"),
	WEBDRIVERWAIT("10"),
	CONFIGFILEPATH(System.getProperty("user.dir")+ "/src/test/resources/config.properties"),
	EXTENTDOCUMENTTITLE("Practice Automation Report"),
	EXTENTREPORTNAME("Selenium Automation Report"),
	JSONFILEPATH(System.getProperty("user.dir") + "/src/test/resources/data.json"),
	LOGINTESTDATAEXCELPATH(System.getProperty("user.dir")+"/src/test/resources/logintestdata.xlsx"),
	REGISTERDATAEXCELPATH(System.getProperty("user.dir")+"/src/test/resources/registertestdata.xlsx");
	
	private String value;

	private FrameConstants(String value) {
		this.value = value;
	}
	
	public int getIntValue() {
		
		return Integer.parseInt(value);
	}
	
	public String getStringValue() {
		
		return value;
	}
}
