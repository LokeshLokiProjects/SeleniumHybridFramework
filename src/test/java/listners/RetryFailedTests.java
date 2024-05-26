package listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
	
		return false;
	}

}
