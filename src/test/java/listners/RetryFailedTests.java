package listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import frameconstans.ConfigFileKeys;
import utlis.PropUtils;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count = 0;
	private int retry = 1;

	@Override
	public boolean retry(ITestResult result) {

		if (PropUtils.getKey(ConfigFileKeys.RETRYTESTS).equalsIgnoreCase("yes")) {

		  if(count < retry) {
				count++;
				return true;
			}

		}
		return false;
	}

}
