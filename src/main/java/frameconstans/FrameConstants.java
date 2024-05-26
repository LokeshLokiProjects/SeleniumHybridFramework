package frameconstans;

public final class FrameConstants {

	private FrameConstants() {

	}

//	
	private static final long IMPLICTWAIT = 30;
	private static final long PAGELOADTIME = 10;
	private static final String EXTENTREPORTPATH = System.getProperty("user.dir")
			+ "/src/test/resources/report/index.html";
//	private static final int WEBDRIVERWAIT = 10;
	private static final String CONFIGFILEPATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\config.properties";
	private static final String EXTENTDOCUMENTTITLE = "Practice Automation Report";
	private static final String EXTENTREPORTNAME = "Selenium Automation Report";
	private static final String JSONFILEPATH = System.getProperty("user.dir") + "/src/test/resources/data.json";

	public static String getExtentdocumenttitle() {
		return EXTENTDOCUMENTTITLE;
	}

	public static String getExtentreportname() {
		return EXTENTREPORTNAME;
	}

	public static String getJsonFilePath() {
		return JSONFILEPATH;
	}

	// public static int getWebdriverwait() {
//		return WEBDRIVERWAIT;
//	}
	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

	public static long getImplictwait() {
		return IMPLICTWAIT;
	}

	public static long getPageloadtime() {
		return PAGELOADTIME;
	}

	public static String getExtentreportpath() {
		return EXTENTREPORTPATH;
	}

}
