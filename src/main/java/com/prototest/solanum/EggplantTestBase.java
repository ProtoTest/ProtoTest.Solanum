package com.prototest.solanum;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

/**
 * Created by Brian on 5/12/2014.
 */
@Listeners({ org.uncommons.reportng.HTMLReporter.class, org.uncommons.reportng.JUnitXMLReporter.class })
public class EggplantTestBase {
    public final static EggplantDriver driver = new EggplantDriver();
    private EggplantProcess eggplantProcess = new EggplantProcess();

    @BeforeTest
    public void testSetup(){

    }
    @AfterTest
    public void testTeardown(ITestResult result){

        if(!result.isSuccess())
            Logger.screenshot();


    }
    @AfterClass
    public void fixtureTearDown(){
        driver.endSuite();
    }

    @BeforeClass
    public void fixtureSetUp(){

        startEggplant();
        setEggplantDefaultSettings();
        driver.connect();
    }

    public void setEggplantDefaultSettings()
    {
        driver.setOption("ImageSearchTime", String.valueOf(Config.imageSearchTime));
        driver.setOption("ImageSearchCount", String.valueOf(Config.imageSearchCount));
    }

    private void startEggplant(){
        try {
            driver.startSuite(Config.suitePath);
        } catch (Exception e) {
            Logger.message(e.getMessage());
            eggplantProcess.start();
            driver.startSuite(Config.suitePath);
            Logger.message("Eggplant drive started with options : " + driver.getOptions());
        }

    }
}
