package com.prototest.solanum;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

/**
 */
public class VerificationsListener implements IHookable {
    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
//        for (int i = 0; i < 4 && !testResult.isSuccess(); i++) {
//            Verifications.clearVerifications();
//            Logger.warning("Test failed, attempting repeat " + (i+2) + " of " + 5);
//            callBack.runTestMethod(testResult);
//        }
        Verifications.assertVerifications();

    }
}
