package com.prototest.solanum;

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
    public void testTeardown(){

    }
    @AfterClass
    public void fixtureTearDown(){
        driver.endSuite();
        eggplantProcess.stop();

    }

    @BeforeClass
    public void fixtureSetUp(){
        eggplantProcess.start();
        driver.startSuite(Config.suitePath);
    }




}
