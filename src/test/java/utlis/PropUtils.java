package utlis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import frameconstans.FrameConstants;

public final class PropUtils {

	private PropUtils() {

	}

	private static final Properties configProp = new Properties();
	private static final HashMap<String, String> CONFIGMAP = new HashMap<String, String>();

	static {
		try {
			FileInputStream fis = new FileInputStream(FrameConstants.getConfigfilepath());
			configProp.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Map.Entry<Object, Object> entry : configProp.entrySet()) {
			CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
		}
	}

// Using ResourceBundle Class
//	public static String getKey(String value) {
//		return ResourceBundle.getBundle("config").getString(value).toLowerCase().trim();
//	}

	public static String getKey(String key) {

		return CONFIGMAP.get(key);
	}

}
