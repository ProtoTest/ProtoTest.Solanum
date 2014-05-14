package com.prototest.solanum;

import org.testng.Reporter;

/**
 * Created by Brian on 5/12/2014.
 */
public class Logger {


    public static void message(String text){
        System.out.println(text);
        Reporter.log(text);

    }

    public static void Warning(String text){
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


}
