package com.prototest.solanum;

import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.annotations.*;

/**
 * Created by Brian on 5/12/2014.
 */
@Listeners({ org.uncommons.reportng.HTMLReporter.class, org.uncommons.reportng.JUnitXMLReporter.class })
public class EggplantTestBase {

    @AfterClass
    public void TearDown(){
       EggplantProcess.Stop();
    }

    @BeforeClass
    public void FixtureSetUp(){
        EggplantProcess.Start();

    }




}
