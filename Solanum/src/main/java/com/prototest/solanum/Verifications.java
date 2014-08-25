package com.prototest.solanum;

import junit.framework.Assert;

import java.util.LinkedList;
import java.util.List;

/**
 * Verifications are like non-terminating assertsions.  This allows us to validate part of the test without stopping the test if the validations fail.
 * A list of all validations is kept, and at the end of the test the VerificationsListener will inject it into the test and validate all validations passed.
 */
public class Verifications {
    private static boolean failedBecauseOfValidations = false;

    static class Verification {


        /**
         * Create a verification with a specific message, a specific image, and whether or not the verification passed.
         */
        Verification(String errorMesage, String imagePath, boolean passed, boolean shouldRetry) {
            this.errorMessage = errorMesage;
            this.imagePath = imagePath;
            this.passed = passed;
            this.shouldRetry = shouldRetry;
        }

        /**
         * Create a verification with a specific message, and whether or not the verification passed.
         */
        Verification(String errorMesage, boolean passed, boolean shouldRetry) {
            this.errorMessage = errorMesage;
            this.imagePath = "";
            this.passed = passed;
            this.shouldRetry = shouldRetry;
        }

        public final String errorMessage;
        public final String imagePath;
        public final boolean passed;
        public final boolean shouldRetry;

    }

    /**
     * The list of verifications kept during the test.  After the test is finished this list will be checked to validate all verifications passed.
     */
    private static List<Verification> verifications = new LinkedList<Verification>();


    public static List<Verification> getVerifications() {
        return verifications;
    }

    public static void clearVerifications() {
        failedBecauseOfValidations = false;
        verifications = new LinkedList<Verification>();
    }

    static boolean failedOnValidations() {
        return failedBecauseOfValidations;
    }

    /**
     * Checks the list of verifications and fails the test if any of them did not pass.  Use this to fail a test for failed verificaitons.
     */
    public static boolean assertVerifications() {
        String failed = getFailures();
        if (failed.length() > 0) {
            //Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            //Reporter.getCurrentTestResult().setThrowable(new AssertionFailedError(String.format("The test failed due to %s verification errors",numFailed)));
            failedBecauseOfValidations = true;
            Assert.fail(String.format("The test failed due to verification errors:\n%s", failed));
            return false;
        }
        return true;
    }


    /**
     * Add a verification to the list, using a specified message, and whether or not it passed.
     */
    public static void addVerification(String message, boolean passed, boolean shouldRetry) {
        if (passed) {
            Logger.debug(String.format("Verification Passed : %s", message));
            verifications.add(new Verification(message, true, shouldRetry));
        } else {
            //String filePath = EggplantTestBase.driver.getScreenshot();
            Logger.error(String.format("Verification Failed : %S", message));
            verifications.add(new Verification(message, "", false, shouldRetry));
            Logger.screenshot();
        }
    }

    /**
     * Add a verification to the list, using a specified message, a path to a screenshot, and whether or not it passed.
     */
    public static void addVerification(String message, String filePath, boolean passed, boolean shouldRetry) {
        if (passed) {
            Logger.debug(String.format("Verification Passed : %S", message));
        } else {
            Logger.error(String.format("Verification Failed : %S", message));
            Logger.screenshot();

        }
        verifications.add(new Verification(message, filePath, false, shouldRetry));

    }

    public static void addVerification(String message, boolean passed) {
        addVerification(message, passed, true);
    }

    public static void addVerification(String message, String filePath, boolean passed) {
        addVerification(message, filePath, passed, true);
    }

    /**
     * Get the list of failed verifications in a string.
     */
    public static String getFailures() {
        StringBuilder errors = new StringBuilder();
        for (Verification verification : verifications) {
            if (!verification.passed) {
                errors.append("\t" + verification.errorMessage);
            }

        }
        return errors.toString();
    }
}

