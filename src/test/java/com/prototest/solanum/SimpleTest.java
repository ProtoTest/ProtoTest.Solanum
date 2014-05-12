package com.prototest.solanum;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import org.testng.Reporter;
import org.testng.annotations.*;

public class SimpleTest extends EggplantTestBase {

    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }

    @Test(groups = { "fast" })
    public void aFastTest() {
        EggplantDriveClient client = new EggplantDriveClient();
        client.EndSuite();
        client.StartSuite();
       // client.Execute("Connect (ServerID:\"10.10.1.15\")");
    }

    @Test(groups = { "slow" })
    public void aSlowTest() { Logger.Message("Suite is : " + Config.suitePath);
    }

}
