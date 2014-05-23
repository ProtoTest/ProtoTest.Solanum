package com.prototest.solanum;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by Brian on 5/20/2014.
 */
public class DriverTests {

    @Test
    public void ClickFormat() {
        MockDriver driver = new MockDriver();
        driver.click("(text: \"Email\", Contrast: \"On\", ContrastColor: \"AutoDetect\", SearchRectangle: (0,0,100,200))");
        Assert.assertEquals("Click (text: \"Email\", Contrast: \"On\", ContrastColor: \"AutoDetect\", SearchRectangle: (0,0,100,200))", driver.getLastResponse().Output);
    }

    @Test
    public void SetOptionFormat() {
        MockDriver driver = new MockDriver();
        driver.setOption("TestOption", "TestValue");
        Assert.assertEquals("set the TestOption to TestValue", driver.getLastResponse().Output);
    }

    @Test
    public void SwipeDownFormat() {
        MockDriver driver = new MockDriver();
        driver.swipeDown(new Point(20, 30));
        Assert.assertEquals("SwipeDown (20,30)", driver.getLastResponse().Output);
    }
}
