package com.prototest.solanum;
import org.testng.annotations.*;

import java.awt.*;

public class SimpleTest extends EggplantTestBase {

    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }

    @Test(groups = { "DeviceNeeded" })
    public void aFastTest() {
        EggplantElement element = new EggplantElement("EmailIcon",By.Text("Email",TextOption.contrast(true),TextOption.contrastColor("AutoDetect"),TextOption.searchRectangle(SearchRectangle.bottomQuarter())));
        element.click();

    }


}
