package com.prototest.solanum;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Brian on 5/20/2014.
 */
public class ConfigTests {
    @Test
    public void TestConfigValue()
    {
        Assert.assertEquals(Config.suitePath,"C:\\Users\\Brian\\Documents\\GitHub\\ProtoTest.Solanum\\EggplantSuites\\DishAnywhere.suite");
    }
}
