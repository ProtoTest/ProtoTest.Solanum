package com.prototest.solanum;

import org.testng.annotations.Test;

import java.awt.*;

/**
 */
public class ScreenshotTest extends MockTestBase {

    @Test
    public void testScreenshot() {
        Logger.screenshot(new Rectangle(1,1, 20, 20));
    }

}
