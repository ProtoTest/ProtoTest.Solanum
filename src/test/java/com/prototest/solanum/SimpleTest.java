package com.prototest.solanum;
import org.testng.annotations.*;

public class SimpleTest extends EggplantTestBase {

    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }

    EggplantElement emailButton = new EggplantElement("emailButton",By.Text("Email",new SearchOptions(SearchRectangle.bottomQuarter())));
    @Test(groups = { "DeviceNeeded" })
    public void aFastTest() {
            driver.connect(Config.hostName, Config.hostPort);
            emailButton.click();
    }


}
