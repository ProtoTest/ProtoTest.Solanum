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
        System.out.println(String.format("(%s) %s",timestamp,text));
        Reporter.log(String.format("(%s) %s",timestamp,text));

    }

    public static void warning(String text){
        System.out.println(String.format("WARNING : %s",text));
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log(String.format("<div style=\"background-color:yellow\">%s</div>",text));
        //System.setProperty("org.uncommons.reportng.escape-output", "true");
    }

    public static void error(String text){
        System.out.println(String.format("ERROR : %s",text));
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log(String.format("<div style=\"background-color:red\">%s</div>",text));
        //System.setProperty("org.uncommons.reportng.escape-output", "true");
    }

    public static void screenshot(){
        String newScreenshot = EggplantTestBase.driver.getScreenshot();
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log(String.format("<img src=\"%s\"/>",newScreenshot));
    }


}
