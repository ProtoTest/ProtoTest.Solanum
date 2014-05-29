package com.prototest.solanum;

import junit.framework.AssertionFailedError;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class VerificationTests extends EggplantTestBase {


    @Override
    @BeforeTest
    @Parameters({"hostName", "hostPort"})
    public void fixtureSetUp(@Optional String hostName, @Optional Integer hostPort) {
        EggplantTestBase.driver = new MockDriver(null);

        startEggplant();
        setEggplantDefaultSettings();
        //driver.connect();
    }

    @AfterTest
    @Override
    @Parameters({"hostName", "hostPort"})
    public void fixtureTearDown(@Optional() String hostName, @Optional() Integer hostPort) {
        stopEggplant();
    }

    @Test
    public void VerifyErrorsAreZero() {
        Assert.assertEquals(0, Verifications.getNumFailures());
    }

    @Test
    public void AddPassedVerification() {
        Verifications.addVerification("This is the success message", true);
        Verifications.assertVerifications();
    }

    @Test(expectedExceptions = AssertionFailedError.class)
    public void AddFailedVerification() {
        Verifications.addVerification("This is the failure message", false);
        Verifications.assertVerifications();
    }

    @Test
    public void CheckMultipleVerification() {
        Verifications.addVerification("This is the failure message", false);
        Verifications.addVerification("This is the success message", true);
        Verifications.addVerification("This is the failure message", false);
        Verifications.addVerification("This is the success message", true);
        List<Verifications.Verification> verifications;
        verifications = Verifications.getVerifications();
        Assert.assertEquals(4, verifications.size());
    }

    @Test
    public void CheckNumberOfFailures() {
        Verifications.addVerification("This is the failure message", false);
        Verifications.addVerification("This is the success message", true);
        Verifications.addVerification("This is the failure message", false);
        Verifications.addVerification("This is the success message", true);
        List<Verifications.Verification> verifications;
        verifications = Verifications.getVerifications();
        Assert.assertEquals(2, Verifications.getNumFailures());
    }
}
