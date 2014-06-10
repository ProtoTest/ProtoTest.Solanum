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
                             @Optional Integer hostPort) {
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

    @Test
    public void TestDriveLaunches() {
        Assert.assertEquals(driver.isDriveRunning(), true);
    }

    @Test
    public void TestDefaultSearchDelay() {

        Assert.assertEquals(driver.getOption("ImageSearchDelay").trim(), Config.imageSearchDelay);
    }

    @Test
    public void TestDefaultSearchCount() {
        Assert.assertEquals(driver.getOption("ImageSearchCount").trim(), Config.imageSearchCount);
    }

    @Test
    public void TestSetOption() {
        driver.setOption("ImageSearchCount", "23");
        Assert.assertEquals(driver.getOption("ImageSearchCount").trim(), "23");
        driver.setOption("ImageSearchTime", "17");
        Assert.assertEquals(driver.getOption("ImageSearchTime").trim(), "17");
        driver.setOption("ImageSearchCount", "23");
        Assert.assertEquals(driver.getOption("ImageSearchCount").trim(), "23");
    }
}
