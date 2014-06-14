package com.prototest.solanum;

import org.testng.annotations.Test;

import java.awt.*;

/**
 */
public class ScreenshotTest extends MockTestBase {

    @Test
    public void testScreenshotAndLog() {
        Logger.screenshot("Original");
        Logger.screenshot(new Rectangle(100, 100, 300, 300));

        Logger.info("Info statement");
        Logger.debug("Debug statement");
        Logger.warning("Warning statement");
        Logger.error("Error statement");
    }

}
