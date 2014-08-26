package com.prototest.solanum;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.util.RetryAnalyzerCount;

import java.io.File;
import java.lang.reflect.Constructor;
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
    public static EggplantDriver driver;
    static EggplantProcess eggplantProcess = new EggplantProcess();

    @BeforeMethod
    public void testSetup(Method method) {
        Config.currentTestName = method.getName();
        Logger.info("Starting test " + Config.currentTestName);
        Verifications.clearVerifications();
        for (int attempt = 0; attempt < Config.retryCount; attempt++) {
            try {
                Logger.info(String.format("BEGINNING APP SETUP ATTEMPT %d OF %d.", attempt+1, 5));
                initializeApp();
            } catch (Exception e) {
                e.printStackTrace();
                Logger.error(String.format("APP SETUP ATTEMPT %d OF %d FAILED.", attempt+1, 5));
                continue;
            }
            break;
        }
    }

    /**
     * Invoked by the test base up to {@link Config#retryCount} times.
     */
    protected void initializeApp() {
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
            Logger.warning("TEST INCOMPLETE (FAILED).");
            Logger.screenshot();
        } else if (result.isSuccess()) {
            Logger.info("TEST COMPLETE (PASSED).");
        }
    }

    /**
     * This method will run once before the entire suite of tests.  It should configure everything needed by eggplant
     * Drive, launch eggplant drive, and connect to the default host
     */
    @BeforeSuite
    @Parameters({"hostName", "hostPort", "driveUrl", "drivePort"})
    public void fixtureSetUp(@Optional String hostName,
                             @Optional Integer hostPort,
                             @Optional String driveUrl,
                             @Optional String drivePort,
                             ITestContext testContext) {

        if (hostName == null || hostPort == null) {
            Logger.info("Host name not configured by testng.xml; falling back to Solanum config.");
            hostName = Config.hostName;
            hostPort = Config.hostPort;
        }
        if (driveUrl != null) {
            Logger.info("Using driveUrl from TestNG params: " + driveUrl);
            Config.driveUrl = driveUrl;
        }
        if (drivePort != null) {
            Logger.info("Using drivePort from TestNG params: " + drivePort);
            Config.drivePort = drivePort;
        }

        driver = new EggplantDriver();
        Logger.info("Creating report directory.");
        createReportDirectory();
        startEggplant();
        setEggplantDefaultSettings();
        Logger.info(String.format("Connecting to eggdrive: %s:%s", Config.driveUrl, Config.drivePort));
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

        File screenshotsDir = new File("Screenshots");
        if (screenshotsDir.exists()) {
            for (File subFile : screenshotsDir.listFiles()) {
                subFile.delete();
            }
        } else {
            screenshotsDir.mkdir();
        }
        String testDir = "test-output"; //Results " + timestamp;
        File report = new File(testDir);
        report.mkdir();
    }

    /**
     * AFter all tests are run, should clean up all test data and stop eggplant drive
     */
    @AfterSuite(alwaysRun = true)
    @Parameters({"hostName", "hostPort"})
    public void fixtureTearDown(@Optional() String hostName,
                                @Optional() Integer hostPort) {
        if (hostName == null || hostPort == null) {
            Logger.info("Host name not configured in testng.xml; falling back to Solanum config.");
            hostName = Config.hostName;
            hostPort = Config.hostPort;
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
            Logger.info("Launching Eggplant Drive.");
            eggplantProcess.kill();
            eggplantProcess.start();
        } else {
            Logger.info("Not managing Eggplant drive");

        }
        Logger.info("Starting squite " + Config.suitePath);
        driver.startSuite(Config.suitePath);
        Logger.info("Eggplant Drive started.");
        }

    /**
     * Stop eggplant drive process.
     */
    protected void stopEggplant() {
        Logger.info("Eggplant Drive stopped.");
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
        Logger.debug("Waiting for (" + secs + ") seconds.");
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

