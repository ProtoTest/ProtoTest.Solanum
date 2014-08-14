package com.prototest.solanum;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.lang.reflect.Method;

/**
 * Hook up the ReportNG listeners, so that the HTML and XML reports will always be generated, even without a pom.
 */
@Listeners({TimestampedHTMLReporter.class,
        TimestamppedXMLReporter.class,
        org.uncommons.reportng.JUnitXMLReporter.class,
        VerificationsListener.class})

/** EggplantTestBase is extended by all tests, and contains hooks to automatically start/stop/configure framework features */
public class EggplantTestBase {
    public static EggplantDriver driver = new EggplantDriver();
    static EggplantProcess eggplantProcess = new EggplantProcess();

    @BeforeMethod
    public void testSetup(Method method) {
        Config.currentTestName = method.getName();
        Logger.info("Starting test " + Config.currentTestName);
        Verifications.clearVerifications();
    }

    /**
     * This method is run automatically by TestNG after each test method.  It should log a screenshot if the test
     * fails,
     * and log the status.
     */
    @AfterMethod
    public void testTeardown(ITestResult result) {
        //Verifications.assertVerifications();
        //result = Reporter.getCurrentTestResult();
        if (!result.isSuccess()) {
            Logger.info("TEST INCOMPLETE (FAILED).");
            Logger.screenshot();
        } else if (result.isSuccess()) {
            Logger.info("TEST COMPLETE (PASSED).");
        }
        uninitializeApp();

    }

    /**
     * This method will run once before the entire suite of tests.  It should configure everything needed by eggplant
     * Drive, launch eggplant drive, and connect to the default host
     */
    @BeforeTest
    @Parameters({"hostName", "hostPort"})
    public void fixtureSetUp(@Optional String hostName,
                             @Optional Integer hostPort,
                             ITestContext testContext) {
        for (ITestNGMethod method : testContext.getAllTestMethods()) {
            method.setInvocationCount(Config.retryCount);
        }
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

    /**
     * Creates the directory used by ReportNG to store the report.  This is needed to fix a bug when running under
     * windows from intelliJ.
     */
    void createReportDirectory() {
        //java.util.Date date = new java.util.Date();
        //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh.mm");
        //String timestamp = sdf.format(date);
        String testDir = "test-output"; //Results " + timestamp;
        File report = new File(testDir);
        //deleteDir(report);
        report.mkdir();
    }

    /**
     * Recursively delete a directory and all subdirecotries and files.
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    /**
     * AFter all tests are run, should clean up all test data and stop eggplant drive
     */
    @AfterTest(alwaysRun = true)
    @Parameters({"hostName", "hostPort"})
    public void fixtureTearDown(@Optional() String hostName,
                                @Optional() Integer hostPort) {
        if (hostName == null || hostPort == null) {
            Logger.info("Host name not configured in testng.xml; falling back to Solanum config.");
            hostName = Config.hostName;
            hostPort = Config.hostPort;
        }
        try{
            driver.disconnect(hostName);
        }
        catch(Exception e){
           Logger.warning("Could not disconnect correctly.  This is a known bug with eggplant : " + e.getMessage());
        }
        driver.endSuite();
        stopEggplant();
    }

    /**
     * Default eggplant drive settings.  Configurable by the config file.
     */
    public void setEggplantDefaultSettings() {
        //Logger.debug("Eggplant drive started with options : " + driver.getOptions());
        //driver.setOption("ImageSearchDelay", String.valueOf(Config.imageSearchDelay));
       // driver.setOption("ImageSearchCount", String.valueOf(Config.imageSearchCount));
       // driver.setOption("PreciseImageTolerance", String.valueOf(Config.preciseImageTolerance));
       // driver.setOption("StandardImageTolerance", String.valueOf(Config.standardImageTolerance));
       // driver.setOption("MouseClickDelay", String.valueOf(Config.mouseClickDelay));
       // driver.setOption("RemoteWorkInterval",String.valueOf(Config.remoteWorkInterval));
       // Logger.debug("Eggplant drive set with options : " + driver.getOptions());
    }

    /**
     * Start the eggplant drive process
     */
    protected void startEggplant() {
        if (Config.manageEggdriveProcess) {
            Logger.info("Launching Eggplant Drive");
            eggplantProcess.kill();
            eggplantProcess.start();
        }
        driver.startSuite(Config.suitePath);
        Logger.info("Eggplant Drive started.");
        }

    /**
     * Stop eggplant drive process.
     */
    protected void stopEggplant() {
        if (Config.manageEggdriveProcess) {
            eggplantProcess.stop();
            eggplantProcess.kill();
        }
    }

    /**
     * Stop execution for the given milliseconds
     */
    public static void sleep(int millis) {
        double secs = millis / 1000.0;
        Logger.info("Waiting for (" + secs + ") seconds.");
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void initializeApp() {
    }

    public void uninitializeApp() {
    }
}
