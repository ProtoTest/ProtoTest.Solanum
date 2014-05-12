package com.prototest.solanum;

import org.testng.Assert;
import org.testng.Reporter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Created by Brian on 5/12/2014.
 */
public class Config {
    private static Properties properties = new Properties();
    public static boolean captureScreenshots = getPropertyValue("captureScreenshotsOnError",true);

    public static boolean startDrive = getPropertyValue("startDrive",true);
    public static String eggplantPath;
    public static String runScriptPath = getPropertyValue("runScriptPath","C:\\Program Files (x86)\\eggPlant\\runscript.bat");
    public static String currentPath = System.getProperty("user.dir");
    public static String suitePath = getPropertyValue("suitePath","");
    public static int drivePort = getPropertyValue("drivePort",5400);
    public static int driveLoggingLevel = getPropertyValue("driveLoggingLevel",2);

    private static int getPropertyValue(String key,int defaultValue){
        String result = (properties.getProperty(key));
        if(result==null) return defaultValue;
        return Integer.parseInt(result);
    }

    public Config() {
           eggplantPath  = getPropertyValue("eggplantPath","")   ;
    }

    public static String getPropertyValue(String key, String defaultValue) {
        String result = properties.getProperty(key, defaultValue);
        if(result=="NULL"){
            Assert.fail(String.format("No suite path found in config.properties.  Please add a value for key : %s", key));
        }
         return result;
    }

    public static boolean getPropertyValue(String key, boolean defaultValue) {
        String result = (properties.getProperty(key));
        if(result==null) return defaultValue;
        return isTruthy(result);
    }

    public static void setPropertyValue(String key, String value) {
        OutputStream output = null;
        try {
            output = new FileOutputStream("config.properties");
            properties.setProperty(key, value);
            properties.store(output, null);
        } catch (Exception e) {
            Reporter.log(String.format("Warning, could not save property '%s=%s' to file", key, value));
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean isTruthy(String value){
        if(value=="True"||value=="true"){
            return true;
        }
        else{
             return false;
        }

    }
}
