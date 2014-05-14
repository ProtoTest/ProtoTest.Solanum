package com.prototest.solanum;

import org.testng.annotations.*;

/**
 * Created by Brian on 5/12/2014.
 */
@Listeners({ org.uncommons.reportng.HTMLReporter.class, org.uncommons.reportng.JUnitXMLReporter.class })
public class EggplantTestBase {
    public static EggplantDriver driver;

    @BeforeTest
    public void setUp(){


    }

    @AfterClass
    public void fixtureTearDown(){

        EggplantProcess.stop();
    }

    @BeforeClass
    public void fixtureSetUp(){
        EggplantProcess.start();
        driver = new EggplantDriver();
        driver.endSuite();
        driver.startSuite(Config.suitePath);

    }




}
