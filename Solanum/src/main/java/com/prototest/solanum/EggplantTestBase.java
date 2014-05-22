package com.prototest.solanum;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * Created by Brian on 5/12/2014.
 */
@Listeners({org.uncommons.reportng.HTMLReporter.class, org.uncommons.reportng.JUnitXMLReporter.class})
public class EggplantTestBase {
    public static EggplantDriver driver = new EggplantDriver();
    private static EggplantProcess eggplantProcess = new EggplantProcess();

    @BeforeMethod
    public void testSetup(Method method) {
        Config.currentTestName = method.getName();
        Logger.message("Starting test " + Config.currentTestName);
        Verifications.clearVerifications();
    }

    @AfterMethod
    public void testTeardown(ITestResult result) {

        if (!result.isSuccess())
            Logger.screenshot();
    }

    @AfterTest(alwaysRun = true)
    public void fixtureTearDown() {
        driver.disconnect();
        driver.endSuite();
        stopEggplant();
    }

    @BeforeTest
    public void fixtureSetUp() {

        startEggplant();
        setEggplantDefaultSettings();
        driver.connect();
    }

    public void setEggplantDefaultSettings() {

        driver.setOption("ImageSearchCount", String.valueOf(Config.imageSearchCount));
        driver.setOption("ImageSearchTime", String.valueOf(Config.imageSearchTime));
    }

    protected void startEggplant() {

        if (driver.isDriveRunning()) {
            return;
        } else {
            if (Config.manageEggdriveProcess) {
                eggplantProcess.kill();
                eggplantProcess.start();
            }
            driver.startSuite(Config.suitePath);
            Logger.message("Eggplant drive started with options : " + driver.getOptions());
        }


    }

    protected void stopEggplant() {
        if (Config.manageEggdriveProcess) {
            eggplantProcess.stop();
            eggplantProcess.kill();
        }
    }
}
