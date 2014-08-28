package com.prototest.solanum;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.util.RetryAnalyzerCount;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Retries test methods up to {@link Config#retryCount} times if the test fails.
 */
public class SolanumRetryAnalyzer implements IRetryAnalyzer {

    AtomicInteger count = new AtomicInteger(Config.retryCount);

    /**
     * Retries the test if count is not 0.
     *
     * @param result The result of the test.
     */
    @Override
    public boolean retry(ITestResult result) {
        boolean retry = false;

        if (count.intValue() > 0) {
            retry = retryMethod(result);
            int tries = count.decrementAndGet();
            Logger.warning(String.format("Retrying test %s (attempt %d of %d)", result.getName(), Config.retryCount - tries, Config.retryCount));
        }
        return retry;
    }

    private boolean retryMethod(ITestResult result) {
        // Check verifications; if all validations are because of non-retryable reasons, don't retry
        if (Verifications.failedOnValidations()) {
            for (Verifications.Verification verification : Verifications.getVerifications()) {
                if (!verification.passed && verification.shouldRetry) {
                    return true;
                }
            }
            return false;
        } else {
            return !result.isSuccess();
        }
    }
}
