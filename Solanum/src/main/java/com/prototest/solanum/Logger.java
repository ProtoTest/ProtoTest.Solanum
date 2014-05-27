package com.prototest.solanum;

import org.testng.Reporter;

import java.awt.*;
import java.text.SimpleDateFormat;

/**
 * Actual documentation, seriously.
 */
public class Logger {

    public static void info(String text){
        if (Config.logLevel > 1) return;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
        String timestamp = sdf.format(date);
        text = String.format("[%s] %s",timestamp,text);
        System.out.println(text);
        Reporter.log(String.format("<div style=\"color:DarkBlue\">%s</div>",text));
    }

    public static void debug(String text){
        if (Config.logLevel > 0) return;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
        String timestamp = sdf.format(date);
        text = String.format("[%s] %s",timestamp,text);
        System.out.println(text);
        Reporter.log(text);
    }

    public static void warning(String text){
        if (Config.logLevel > 2) return;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
        String timestamp = sdf.format(date);
        text = String.format("(%s) ----! WARNING: %s",timestamp,text);

        System.out.println(text);
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log(String.format("<div style=\"background-color:yellow\">%s</div>",text));
    }

    public static void error(String text){
        if (Config.logLevel > 3) return;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
        String timestamp = sdf.format(date);
        text = String.format("(%s) !---- ERROR: %s",timestamp,text);
        System.out.println(text);
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log(String.format("<div style=\"background-color:red; color:white\">%s</div>",text));
    }

    public static void screenshot(Rectangle drawRectangle){

        String newScreenshot = EggplantTestBase.driver.getScreenshot();
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log(String.format("<img src=\"%s\"/>",newScreenshot + ".tiff"));

    }


}
