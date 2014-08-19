package com.prototest.solanum;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Brian on 5/20/2014.
 */
public class TestBaseTests extends EggplantTestBase {
    @BeforeTest
    @Parameters({"hostName", "hostPort"})
    public void fixtureSetUp(@Optional String hostName,
                             @Optional Integer hostPort,
                             ITestContext testContext) {
        if (hostName == null || hostPort == null) {
            Logger.info("Host name not configured by testng.xml; falling back to Solanum config.");
            hostName = Config.hostName;
            hostPort = Config.hostPort;
        }
        createReportDirectory();
        startEggplant();
        setEggplantDefaultSettings();
       // driver.connect(hostName, hostPort);
    }

    @Test(threadPoolSize = 3, invocationCount = 10,  timeOut = 10000)
    public void TestDriveLaunches() {
        Assert.assertEquals(getDriver().isDriveRunning(), true);
    }

    @Test
    public void TestDefaultSearchDelay() {

        Assert.assertEquals(getDriver().getOption("ImageSearchDelay").trim(), Config.imageSearchDelay);
    }

    @Test
    public void TestDefaultSearchCount() {
        Assert.assertEquals(getDriver().getOption("ImageSearchCount").trim(), Config.imageSearchCount);
    }

    @Test
    public void TestSetOption() {
        getDriver().setOption("ImageSearchCount", "23");
        Assert.assertEquals(getDriver().getOption("ImageSearchCount").trim(), "23");
        getDriver().setOption("ImageSearchTime", "17");
        Assert.assertEquals(getDriver().getOption("ImageSearchTime").trim(), "17");
        getDriver().setOption("ImageSearchCount", "23");
        Assert.assertEquals(getDriver().getOption("ImageSearchCount").trim(), "23");
    }
}
