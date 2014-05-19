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
        SearchOptions options = new SearchOptions();
        //options.searchRectangle = SearchRectangle.bottomQuarter();
        options.contrast=true;
        EggplantElement element = new EggplantElement("EmailIcon",By.Text("Email",options));
        element.click();

    }


}
