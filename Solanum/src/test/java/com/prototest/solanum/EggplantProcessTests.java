package com.prototest.solanum;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Brian on 5/20/2014.
 */
public class EggplantProcessTests {


    @Test
    public void TestDriveStarts(){
        EggplantProcess process = new EggplantProcess();

        if (Config.manageEggdriveProcess) {
            process.kill();
            process.start();
        }
        EggplantDriver driver = new EggplantDriver();
        driver.startSuite(Config.suitePath);
        Assert.assertEquals(driver.isDriveRunning(), true, "Drive is not running");
    }


    @Test
    public void TestDriveKills(){
        EggplantProcess process = new EggplantProcess();
        if (Config.manageEggdriveProcess) {
            process.start();
        }
        EggplantDriver driver = new EggplantDriver();
        driver.startSuite(Config.suitePath);
        if (Config.manageEggdriveProcess) {
            process.kill();
            Assert.assertEquals(driver.isDriveRunning(), false, "Drive was not killed");
        }

    }

      ///this test is failing as process.destroy() doesn't seem to work.
    @Test
    public void TestDriveStops(){
        EggplantProcess process = new EggplantProcess();
        process.kill();
        process.start();
        EggplantDriver driver = new EggplantDriver();
        driver.startSuite(Config.suitePath);
        process.stop();
        Assert.assertEquals(driver.isDriveRunning(), false, "Drive was not stopped");

    }
}
