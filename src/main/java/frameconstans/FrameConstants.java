package frameconstans;

public final class FrameConstants {

	private FrameConstants() {

	}

//	
	private static final long IMPLICTWAIT = 30;
	private static final long PAGELOADTIME = 10;
//	private static final int WEBDRIVERWAIT = 10;

	private static final String CONFIGFILEPATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\config.properties";

//	public static int getWebdriverwait() {
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

}
