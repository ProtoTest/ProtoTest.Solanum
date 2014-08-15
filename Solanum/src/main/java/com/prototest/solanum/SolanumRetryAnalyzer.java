package com.prototest.solanum;

import org.testng.ITestResult;
import org.testng.util.RetryAnalyzerCount;

public class SolanumRetryAnalyzer extends RetryAnalyzerCount {

    public SolanumRetryAnalyzer() {
        setCount(5);
    }
    @Override
    public boolean retryMethod(ITestResult result) {
        return result.isSuccess() ? false : retry(result);
    }
}
