package factory;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import frameconstans.ConfigFileKeys;
import frameconstans.FrameConstants;
import utlis.PropUtils;
import utlis.FrameUtils;

public final class ExtentReportFactory {

	private ExtentReportFactory() {
	}

	private static ExtentReports extentReport;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	static void setExtentTest(ExtentTest extentTestRef) {
		extentTest.set(extentTestRef);
	}

	static void removeExtentTest() {
		extentTest.remove();
	}

	public static void initReport() {
		if (Objects.isNull(extentReport)) {
			extentReport = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(new File(FrameConstants.EXTENTREPORTPATH.getStringValue()));
			extentReport.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle(FrameConstants.EXTENTDOCUMENTTITLE.getStringValue());
			spark.config().setReportName(FrameConstants.EXTENTREPORTNAME.getStringValue());
		}
	}

	public static void tearDownReport() throws IOException {
		if (Objects.nonNull(extentReport)) {
			extentReport.flush();
			removeExtentTest();
			Desktop.getDesktop().browse(new File(FrameConstants.EXTENTREPORTPATH.getStringValue()).toURI());
		}
	}

	public static void fail(String message) {
		getExtentTest().fail(message,
				MediaEntityBuilder.createScreenCaptureFromBase64String(FrameUtils.getBase64Image()).build());

	}

	public static void pass(String message) {
		
		getExtentTest().pass(message,
				MediaEntityBuilder.createScreenCaptureFromBase64String(FrameUtils.getBase64Image()).build());
	}

	public static void skip(String message) {
		getExtentTest().skip(message);
	}

	public static void createTest(String testcaseName) {
		setExtentTest(extentReport.createTest(testcaseName));
	}

}
