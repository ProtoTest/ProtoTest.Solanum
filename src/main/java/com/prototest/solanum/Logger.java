package com.prototest.solanum;

import org.testng.Reporter;

/**
 * Actual documentation, seriously.
 */
public class Logger {


    public static void message(String text){
        System.out.println(text);
        Reporter.log(text);

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
