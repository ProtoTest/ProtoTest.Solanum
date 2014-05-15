package com.prototest.solanum;

import java.io.*;
import java.util.Properties;

/**
 * Created by Brian on 5/12/2014.
 */
public class Config {
    private static Properties properties = new Properties();
    private static InputStream input = null;
    private static OutputStream output = null;
    public static boolean captureScreenshots = getPropertyValue("captureScreenshotsOnError",true);
    public static boolean startDrive = getPropertyValue("startDrive",true);
    public static String eggplantPath = getPropertyValue("eggplantPath","");
    public static String runScriptPath = getPropertyValue("runScriptPath","C:\\Program Files (x86)\\eggPlant\\runscript.bat");
    public static String currentPath = System.getProperty("user.dir");
    public static String suitePath = getPropertyValue("suitePath","");
    public static int drivePort = getPropertyValue("drivePort",5400);
    public static int driveLoggingLevel = getPropertyValue("driveLoggingLevel",2);
    public static boolean logDriveCommands = getPropertyValue("logDriveCommands",true);
    public static int commandDelayMs = getPropertyValue("commandDelayMs",1000);
    public static int elementWaitTimeMs = getPropertyValue("elementWaitTimeMs",5000);
    // TODO does clickExecuteDelay duplicate the intention of any of these other settings?
    public static int clickExecuteDelay = getPropertyValue("clickExecuteDelay", 1000);

    private static int getPropertyValue(String key,int defaultValue){
        String result = (properties.getProperty(key));
        if(result==null) return defaultValue;
        return Integer.parseInt(result);
    }


    public static String getPropertyValue(String key, String defaultValue) {
        try {
            input = new FileInputStream("config.properties");
            properties.load(input);
            String result = properties.getProperty(key, defaultValue);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

    public static boolean getPropertyValue(String key, boolean defaultValue) {

        try {
            input = new FileInputStream("config.properties");
            properties.load(input);
            String result = (properties.getProperty(key));
            if(result==null) return defaultValue;
            return isTruthy(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
           return defaultValue;

    }

    public static void setPropertyValue(String key, String value) {

        try {
            output = new FileOutputStream("config.properties");
            properties.setProperty(key, value);
            properties.store(output, null);
            output.close();
        } catch (Exception e) {
            Logger.warning(String.format("warning, could not save property '%s=%s' to file", key, value));
        }
    }

    private static boolean isTruthy(String value){
        if(value.equals("True") || value.equals("true")){
            return true;
        }
        else{
             return false;
        }

    }
}
