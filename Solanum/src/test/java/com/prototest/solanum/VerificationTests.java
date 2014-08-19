package com.prototest.solanum;

import junit.framework.AssertionFailedError;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.List;

public class VerificationTests extends EggplantTestBase {


    @Override
    @BeforeTest
    @Parameters({"hostName", "hostPort"})
    public void fixtureSetUp(@Optional String hostName, @Optional Integer hostPort,
                             ITestContext testContext) {
        EggplantTestBase.setDriver(new MockDriver(null));
        createReportDirectory();
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
        Assert.assertEquals(0, Verifications.getFailures());
    }

    @Test
    public void AddPassedVerification() {
        Verifications.addVerification("This is the success message", true);
    }

    @Test(expectedExceptions = AssertionFailedError.class)
    public void AddFailedVerification() {
        Verifications.addVerification("This is the failure message", false);
        Verifications.assertVerifications();
        Verifications.clearVerifications();
    }

    @Test
    public void CheckNumberOfFailures() {
        Verifications.addVerification("This is the failure message", false);
        Verifications.addVerification("This is the success message", true);
        Verifications.addVerification("This is the failure message", false);
        Verifications.addVerification("This is the success message", true);
        List<Verifications.Verification> verifications;
        verifications = Verifications.getVerifications();
        Assert.assertEquals(2, Verifications.getFailures());
        Assert.assertEquals(4, verifications.size());
        Verifications.clearVerifications();
    }
}
