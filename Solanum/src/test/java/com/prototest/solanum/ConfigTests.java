package com.prototest.solanum;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Brian on 5/20/2014.
 */
public class ConfigTests {
    @Test
    public void TestConfigValue() {
        Assert.assertEquals(Config.suitePath, "EggplantSuites/DishAnywhere.suite");
    }

    @Test
    public void TestTestSpecificConfigValue() {
        Assert.assertEquals(Config.getTestProp("customVar1"), "val1");
    }
}
