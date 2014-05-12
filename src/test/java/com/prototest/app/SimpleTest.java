package com.prototest.app;

import junit.framework.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class SimpleTest {

    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }

    @Test(groups = { "fast" })
    public void aFastTest() {
        Reporter.log("Fast test");
        System.out.println("Fast test");
        Assert.fail("FUCK");
    }

    @Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println("Slow test");
    }

}
