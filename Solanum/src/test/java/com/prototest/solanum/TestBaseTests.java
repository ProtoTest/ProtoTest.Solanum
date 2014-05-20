package com.prototest.solanum;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Brian on 5/20/2014.
 */
public class TestBaseTests extends EggplantTestBase{
    @Override
    @BeforeTest
    public void fixtureSetUp(){
        startEggplant();
        setEggplantDefaultSettings();
        //driver.connect();
    }
    @Test
    public void TestDriveLaunches(){
        Assert.assertEquals(driver.isDriveRunning(),true);
     }

    @Test
    public void TestDefaultSearchTime(){

        Assert.assertEquals(driver.getOption("ImageSearchTime").trim(), Config.imageSearchTime);
    }
    @Test
    public void TestDefaultSearchCount(){
        Assert.assertEquals(driver.getOption("ImageSearchTime").trim(),Config.imageSearchTime);
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
