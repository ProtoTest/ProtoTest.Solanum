package com.prototest.solanum;

import junit.framework.AssertionFailedError;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.Console;
import java.util.List;

public class Testc  {

    @AfterMethod
    void after()
    {
        Verifications.assertVerifications();
    }

    @Test
    public void TestOne() {
        Verifications.addVerification("This is the failure message", false);
    }

    @Test
    public void TestTwo() {
        Verifications.addVerification("This is the success message", true);
    }


    @Test
    public void TestThree() {
        Verifications.addVerification("This is the failure message", false);
    }

}
