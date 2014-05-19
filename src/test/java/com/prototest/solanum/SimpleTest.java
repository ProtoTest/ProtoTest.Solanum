package com.prototest.solanum;
import org.testng.annotations.*;

public class SimpleTest extends EggplantTestBase {

    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }

    @Test(groups = { "fast" })
    public void aFastTest() {
        EggplantDriver driver = new EggplantDriver();
        driver.connect("10.10.1.13");
    }

    @Test(groups = { "slow" })
    public void aSlowTest() { Logger.message("Suite is : " + Config.suitePath);
    }

}
