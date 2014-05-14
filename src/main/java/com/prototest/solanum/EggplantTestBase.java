package com.prototest.solanum;

import org.testng.annotations.*;

/**
 * Created by Brian on 5/12/2014.
 */
@Listeners({ org.uncommons.reportng.HTMLReporter.class, org.uncommons.reportng.JUnitXMLReporter.class })
public class EggplantTestBase {

    @AfterClass
    public void TearDown(){
       EggplantProcess.stop();
    }

    @BeforeClass
    public void FixtureSetUp(){
        EggplantProcess.start();

    }




}
