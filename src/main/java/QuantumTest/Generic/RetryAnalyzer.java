package QuantumTest.Generic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	private int retryCnt = 0;
	Integer retryCounter = Integer.valueOf(GetPropertyValues.getPropertyValue("maxCountToRetryFailedTests"));
	public boolean retry(ITestResult result) 
	{
        if (retryCnt < retryCounter)
	        {
        		retryCnt++;
	            return true;
	        }
	        return false;
	  }
}
