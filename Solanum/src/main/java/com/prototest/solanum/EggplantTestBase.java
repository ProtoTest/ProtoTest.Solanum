package com.prototest.solanum;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

/**
 * Created by Brian on 5/12/2014.
 */
@Listeners({ org.uncommons.reportng.HTMLReporter.class, org.uncommons.reportng.JUnitXMLReporter.class })
public class EggplantTestBase {
    public static EggplantDriver driver = new EggplantDriver();
    private static EggplantProcess eggplantProcess = new EggplantProcess();

    @BeforeMethod
    public void testSetup(){
        Verifications.clearVerifications();
    }
    @AfterMethod
    public void testTeardown(ITestResult result){

        if(!result.isSuccess())
            Logger.screenshot();
    }

    @AfterTest
    public void fixtureTearDown(){
        driver.endSuite();
    }

    @BeforeTest
    public void fixtureSetUp(ITestContext ctx){
          String outputDir = ctx.getOutputDirectory();
        Logger.message("Current path : "+ outputDir);
        startEggplant();
        setEggplantDefaultSettings();
        driver.connect();
    }

    public void setEggplantDefaultSettings()
    {

        driver.setOption("ImageSearchCount", String.valueOf(Config.imageSearchCount));
        driver.setOption("ImageSearchTime", String.valueOf(Config.imageSearchTime));
    }

    protected void startEggplant(){
       if(driver.isDriveRunning()){
            return;
       }   else {
           eggplantProcess.start();
           driver.startSuite(Config.suitePath);
           Logger.message("Eggplant drive started with options : " + driver.getOptions());
       }


    }

    protected void stopEggplant(){
            eggplantProcess.stop();
            eggplantProcess.kill();
    }
}
