package com.prototest.solanum;

import org.testng.ITestResult;
import org.testng.annotations.*;

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
        Logger.debug("Starting test " + Config.currentTestName);
        Verifications.clearVerifications();
    }

    @AfterMethod
    public void testTeardown(ITestResult result) {
        if (result.isSuccess()) {
            Logger.info("TEST COMPLETE (PASSED).");
        }
        if (!result.isSuccess()) {
            Logger.info("TEST INCOMPLETE (FAILED).");
            Logger.screenshot();
        }
    }

    @BeforeTest
    @Parameters({"hostName", "hostPort"})
    public void fixtureSetUp(@Optional String hostName,
                             @Optional Integer hostPort) {
        if (hostName == null || hostPort == null) {
            Logger.info("Host name not configured by testng.xml; falling back to Solanum config.");
            hostName = Config.hostName;
            hostPort = Config.hostPort;
        }
        startEggplant();
        setEggplantDefaultSettings();
        driver.connect(hostName, hostPort);
    }

    @AfterTest(alwaysRun = true)
    @Parameters({"hostName", "hostPort"})
    public void fixtureTearDown(@Optional() String hostName,
                                @Optional() Integer hostPort) {
        if (hostName == null || hostPort == null) {
            Logger.info("Host name not configured in testng.xml; falling back to Solanum config.");
            hostName = Config.hostName;
            hostPort = Config.hostPort;
        }
        driver.disconnect(hostName, hostPort);
        driver.endSuite();
        stopEggplant();
    }

    public void setEggplantDefaultSettings() {

        driver.setOption("ImageSearchDelay", String.valueOf(Config.imageSearchDelay));
        driver.setOption("ImageSearchCount", String.valueOf(Config.imageSearchCount));
        driver.setOption("MouseClickDelay", String.valueOf(Config.mouseClickDelay));
        Logger.debug("Eggplant drive set with options : " + driver.getOptions());
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
            Logger.info("Eggplant Drive started.");
        }
    }

    protected void stopEggplant() {
        if (Config.manageEggdriveProcess) {
            eggplantProcess.stop();
            eggplantProcess.kill();
        }
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
