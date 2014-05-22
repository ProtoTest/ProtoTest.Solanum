package com.prototest.solanum;

import java.io.*;
import java.util.Properties;

/**
 * Created by Brian on 5/12/2014.
 */
public class Config {
    private static Properties properties;
    private static OutputStream output = null;
    public static boolean captureScreenshots = getPropertyValue("captureScreenshotsOnError", true);
    public static boolean startDrive = getPropertyValue("startDrive", true);
    public static String eggplantPath = getPropertyValue("eggplantPath", "");
    public static String windowsScriptPath = getPropertyValue("windowsScriptPath", "C:\\Program Files (x86)\\eggPlant\\runscript.bat");
    public static String macScriptPath = getPropertyValue("macScriptPath", "/Applications/Eggplant.app/runscript");
    public static String currentPath = System.getProperty("user.dir");
    public static String suitePath = getPropertyValue("suitePath", "");
    public static String drivePort = getPropertyValue("drivePort", "5400");
    public static String driveLoggingLevel = getPropertyValue("driveLoggingLevel", "0");
    public static boolean logDriveCommands = getPropertyValue("logDriveCommands", false);
    public static int commandDelayMs = getPropertyValue("commandDelayMs", 1000);
    public static int elementWaitTimeSec = getPropertyValue("elementWaitTimeSec", 5);
    public static String hostName = getPropertyValue("hostName", "localhost");
    public static int hostPort = getPropertyValue("hostPort", 5900);
    public static String imageSearchTime = getPropertyValue("imageSearchTime","1");
    public static String imageSearchCount = getPropertyValue("imageSearchCount","1");
    public static String driveUrl = getPropertyValue("driveUrl","http://127.0.0.1:5400");
    public static String currentTestName = "Test";
    public static boolean manageEggdriveProcess = getPropertyValue("manageEggdriveProcess", true);

    private static int getPropertyValue(String key, int defaultValue) {
        String result = getPropertyValue(key, null);
        if (result == null) return defaultValue;
        return Integer.parseInt(result);
    }

    private static void init() {
        properties = new Properties(System.getProperties());

        String configLocation = System.getProperty("configFile");
        InputStream input = null;
        if (configLocation != null) {
            try {
                input = new FileInputStream(configLocation);
            } catch (FileNotFoundException e) {
                Logger.warning("Config file " + configLocation + " not found. Using defaults.");
            }
        } else {
            input = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties");
        }
        if (input == null) {
            Logger.message("Config file not found, using defaults.");
        } else {
            try {
                properties.load(input);
            } catch (IOException e) {
                Logger.error("Could not load config file. " + e.getMessage());
            }
        }
    }

    public static String getPropertyValue(String key, String defaultValue) {
        if (properties == null) init();

        return properties.getProperty(key, defaultValue);
    }

    public static boolean getPropertyValue(String key, boolean defaultValue) {
        if (properties == null) init();

        String result = getPropertyValue(key, null);
        if (result == null) return defaultValue;
        return isTruthy(result);
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

    private static boolean isTruthy(String value) {
        return value.equals("True") || value.equals("true");
    }
}
