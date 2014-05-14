package com.prototest.solanum;
import org.testng.annotations.*;

public class SimpleTest extends EggplantTestBase {

    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }

    @Test(groups = { "fast" })
    public void aFastTest() {
        EggplantDriveClient client = new EggplantDriveClient();
        client.endSuite();
        client.startSuite();
       // client.execute("Connect (ServerID:\"10.10.1.15\")");
    }

    @Test(groups = { "slow" })
    public void aSlowTest() { Logger.message("Suite is : " + Config.suitePath);
    }

}
