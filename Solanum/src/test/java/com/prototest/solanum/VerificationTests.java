package com.prototest.solanum;

import junit.framework.AssertionFailedError;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class VerificationTests extends EggplantTestBase{
    @BeforeTest
    public void setupClass(){
        this.driver = new MockDriver();
    }
    @Override
    @BeforeTest
    public void fixtureSetUp(){

        startEggplant();
        setEggplantDefaultSettings();
        //driver.connect();
    }
    @Test
    public void VerifyErrorsAreZero(){
        Assert.assertEquals(0, Verifications.getNumFailures());
    }

    @Test
         public void AddPassedVerification() {
        Verifications.addVerification("This is the success message",true);
        Verifications.assertVerifications();
    }
    @Test(expectedExceptions = AssertionFailedError.class)
    public void AddFailedVerification() {
        Verifications.addVerification("This is the failure message",false);
        Verifications.assertVerifications();
    }

    @Test
    public void CheckMultipleVerification() {
        Verifications.addVerification("This is the failure message",false);
        Verifications.addVerification("This is the success message",true);
        Verifications.addVerification("This is the failure message",false);
        Verifications.addVerification("This is the success message",true);
        List<Verifications.Verification> verifications;
        verifications = Verifications.getVerifications();
        Assert.assertEquals(4,verifications.size());
    }

    @Test
    public void CheckNumberOfFailures() {
        Verifications.addVerification("This is the failure message",false);
        Verifications.addVerification("This is the success message",true);
        Verifications.addVerification("This is the failure message",false);
        Verifications.addVerification("This is the success message",true);
        List<Verifications.Verification> verifications;
        verifications = Verifications.getVerifications();
        Assert.assertEquals(2,Verifications.getNumFailures());
    }
}
