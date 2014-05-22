package com.prototest.solanum;

import org.testng.Reporter;

import java.text.SimpleDateFormat;

/**
 * Actual documentation, seriously.
 */
public class Logger {


    public static void message(String text){
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
        String timestamp = sdf.format(date);
        text = String.format("(%s) %s",timestamp,text);
        System.out.println(text);
        Reporter.log(text);

    }

    public static void warning(String text){
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
        String timestamp = sdf.format(date);
        text = String.format("(%s) ----! WARNING: %s",timestamp,text);

        System.out.println(text);
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log(String.format("<div style=\"background-color:yellow\">%s</div>",text));
    }

    public static void error(String text){
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
        String timestamp = sdf.format(date);
        text = String.format("(%s) !---- ERROR: %s",timestamp,text);
        System.out.println(text);
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log(String.format("<div style=\"background-color:red\">%s</div>",text));
    }

    public static void screenshot(){
        String newScreenshot = EggplantTestBase.driver.getScreenshot();
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log(String.format("<img src=\"%s\"/>",newScreenshot));
    }


}
