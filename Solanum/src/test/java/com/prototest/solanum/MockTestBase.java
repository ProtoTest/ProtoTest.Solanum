package com.prototest.solanum;

import org.apache.commons.io.IOUtils;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.*;
import java.lang.reflect.Method;

/**
 */


public class MockTestBase extends EggplantTestBase {
    private static String testImagePath;

    static {
        InputStream
                streamin = MockTestBase.class.getClassLoader().getResourceAsStream("05292014104132.tiff");
        try {
            String imagePath = "testimage.tiff";
            File file = new File(imagePath);
            FileOutputStream os = new FileOutputStream(file);
            IOUtils.copy(streamin, os);
            testImagePath = file.getAbsolutePath();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    @BeforeTest
    @Parameters({"hostName", "hostPort"})
    public void fixtureSetUp(@Optional String hostName, @Optional Integer hostPort) {
        EggplantTestBase.driver = new MockDriver(null);

        startEggplant();
        setEggplantDefaultSettings();
        //driver.connect();
    }

    @AfterTest
    @Override
    @Parameters({"hostName", "hostPort"})
    public void fixtureTearDown(@Optional() String hostName, @Optional() Integer hostPort) {
        stopEggplant();
    }

    @BeforeMethod
    @Override
    public void testSetup(Method method) {
        super.testSetup(method);


        driver = new MockDriver(testImagePath);
        EggplantTestBase.driver = new MockDriver(testImagePath);
    }

    @AfterMethod
    @Override
    public void testTeardown(ITestResult result) {
        super.testTeardown(result);
        new File(testImagePath).delete();
    }
}
