package listners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import factory.ExtentReportFactory;

public class ListnerClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		ExtentReportFactory.initReport();
	}

	@Override
	public void onFinish(ISuite suite) {
		try {
			ExtentReportFactory.tearDownReport();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReportFactory.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReportFactory.pass(result.getMethod().getMethodName() + " is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
		ExtentReportFactory.fail(result.getMethod().getMethodName() + " is failed");
		ExtentReportFactory.fail(result.getThrowable().toString());
		ExtentReportFactory.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentReportFactory.skip(result.getMethod().getMethodName() + " is skipped");
	}

}
