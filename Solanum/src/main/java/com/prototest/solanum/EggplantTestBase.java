package com.prototest.solanum;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
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
        initializeApp();

    }

    @AfterMethod
    public void testTeardown(ITestResult result) {
        Verifications.assertVerifications();
        result = Reporter.getCurrentTestResult();
        uninitializeApp();
        if (!result.isSuccess()) {
            Logger.info("TEST INCOMPLETE (FAILED).");
            Logger.screenshot();


        } else if (result.isSuccess()) {
            Logger.info("TEST COMPLETE (PASSED).");
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
        createReportDirectory();
        startEggplant();
        setEggplantDefaultSettings();
        driver.connect(hostName, hostPort);
    }

    void createReportDirectory() {
        File report = new File("test-output");
        deleteDir(report);
        report.mkdir();
    }

    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
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
            Logger.info("Drive is already running.");
            eggplantProcess = new EggplantProcess();
            return;
        } else {
            if (Config.manageEggdriveProcess) {
                Logger.info("Launching Eggplant Drive");
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
        double secs = millis / 1000.0;
        Logger.info("Waiting for (" + secs + ") seconds.");
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void initializeApp() {}

    public void uninitializeApp() {}
}
