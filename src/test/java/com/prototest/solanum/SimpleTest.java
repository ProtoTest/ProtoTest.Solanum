package com.prototest.solanum;
import org.testng.annotations.*;

public class SimpleTest extends EggplantTestBase {

    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }

    @Test(groups = { "DeviceNeeded" })
    public void aFastTest() {
            driver.connect(Config.hostName, Config.hostPort);
            driver.click(By.Text("Email").getLocator());
            driver.click(By.Text("Test").getLocator());
    }


}
