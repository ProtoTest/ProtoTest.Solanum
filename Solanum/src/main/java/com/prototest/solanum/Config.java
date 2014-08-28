package com.prototest.solanum;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * The Config class contains variables for all global framework settings.
 * It also contains methods to get and set key value pairs from the config.properties file.
 * The following global settings are avaialable :
 * boolean screenshotOnError : automatically include a screenshot of the device under test when the test fails.
 * <ul>
 * <li><em>windowsScriptPath</em> : the default path to eggplant runscript on a windows machine</li>
 * <li>string unixScriptPath : the default path to eggplant runscript on a mac machine</li>
 * <li>string currentPath : the current default directory for the user.  Maps to the system property "user.dir"</li>
 * <li>string suitePath : the path to the default suite.  This suite will automatically be started</li>
 * <li>string drivePort : the port eggPlant drive's XMLRPC service will run on.</li>
 * <li>string driveLogginLevel : Eggplant drive's native logging level.  This logs to the console.  Values can be 0,1,2.</li>
 * <li>string logLevel : "The level of logging solanum should use.  Values can be "debug", "info", "warning", or "error"</li>
 * <li>boolean logDriveCommands : Whether to log the runScript commands passed into the eggPlant driver.<br>
 *  Use this to see what commands are actually being passed to eggplant drive.</li>
 * <li>int commandDelayMs : the amount of time to delay between each command.  Use this to slow down the test.</li>
 * <li>int elementWaitTimeSec : the number of seconds to automatically wait when looking for an element.</li>
 * <li>string hostName : the host name or IP address of the device under test.</li>
 * <li>int hostPort : The port that eggOn is running on the device.  Used in combination with hostName to connect to a host.</li>
 * <li>string imageSearchCount : The number of times eggPlant searches for an element before failing.</li>
 * <li>string imageSearchDelay : The number of milliseconds to wait between each eggplant Search.</li>
 * <li>string mouseClickDelay : The number of milliseconds a click should be held before releasing.</li>
 * <li>string driveUrl : The url which to use to connect to the drive XMLRPC service.</li>
 * <li>string currentTestName : The current test's name.</li>
 * <li>boolean manageEggdriveProcess : Automatically start and stop eggplant drive before/after each test suite.</li>
 * <li>boolean debugElementLocators : Take a screenshot before each step to aid in debugging.</li>
 * </ul>
 */

//  EGGPLANT REFERENCE AND DOCUMENTATION LINKS
//  http://docs.testplant.com/?q=content/eggplant-commands-and-functions
//  http://docs.testplant.com/?q=content/run-options-preferences
//  http://docs.testplant.com/?q=content/finding-text                     << Also includes "Search Rectangle" options
//  http://docs.testplant.com/?q=content/finding-images                   << Also includes "Search Rectangle" options
//  http://docs.testplant.com/?q=content/working-ocr


public class Config {

    //  FRAMEWORK PATHS

    public static String windowsScriptPath = getPropertyValue("windowsScriptPath", "C:\\Program Files (x86)\\eggPlant\\runscript.bat");
    public static String unixScriptPath = getPropertyValue("unixScriptPath", "/Applications/Eggplant.app/runscript");
    public static String currentPath = System.getProperty("user.dir");
    public static String suitePath = getPropertyValue("suitePath", "");
    public static String drivePort = getPropertyValue("drivePort", "5400");


    //  LOGGING

    // Logging Level - can be debug, info, warning, or error.
    public static int logLevel = getLogLevel(getPropertyValue("logLevel", "debug"));
    // Screenshot on error - captures device screenshot at moment of error
    public static boolean screenshotOnError = getPropertyValue("screenshotOnError", true);
    // Logs the actual Eggplant commands being sent to the org.apache.xmlrpc.client (which is then sent to the device)
    public static boolean logDriveCommands = getPropertyValue("logDriveCommands", false);
    // Internal EggplantDrive logs that are normally sent to the console
    public static String driveLoggingLevel = getPropertyValue("driveLoggingLevel", "0");
    // Turning off escape-output means that we can write HTML to the report.
    static {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
    }
    private static Properties properties;
    private static OutputStream output = null;
    // Timestamp the HTML log
    public static boolean timestampHtmlLog = getPropertyValue("timestampHtmlLog", true);


    //  TEST EXECUTION OPTIONS

    // Eggplant Drive URL and Test Name defaults
    public static String driveUrl = getPropertyValue("driveUrl","http://127.0.0.1");
    public static String currentTestName = "Test";
    // Manage Eggdrive Process - Determines if eggplant processes will be killed before tests
    public static boolean manageEggdriveProcess = getPropertyValue("manageEggdriveProcess", true);
    // Command Delay - Delay between commands being executed (milli-seconds)
    public static int commandDelayMs = getPropertyValue("commandDelayMs", 0);
    // Wait until the element is present for the given # of seconds
    public static int elementWaitTimeSec = getPropertyValue("elementWaitTimeSec", 60);
    public static String hostName = getPropertyValue("hostName", "localhost");
    public static int hostPort = getPropertyValue("hostPort", 5900);
    // Test Retry Count + Number of times to retry an action until action is true or has exhausted the given attempts
    public static int retryCount = getPropertyValue("retryCount", 5);
    public static int maxActionRetries = getPropertyValue("maxActionRetries", 10);


    //  DIAGNOSIS EXECUTION OPTIONS

    public static boolean debugElementLocators = getPropertyValue("debugElementLocators", false);
    public static boolean diagnoseFailedImages = getPropertyValue("diagnoseFailedImages",false);


    //  EGGPLANT GLOBAL OPTIONS
    //  http://docs.testplant.com/?q=content/run-options-preferences

    // Number of times that image-based elements are searched for + time delay between searches
    public static String imageSearchCount = getPropertyValue("imageSearchCount","7");
    public static String imageSearchDelay = getPropertyValue("imageSearchDelay","0.3");
    // Default tolerances for image-based elements (can also be found in image-viewer within Eggplant GUI)
    public static String preciseImageTolerance = getPropertyValue("preciseImageTolerance","1");
    public static String standardImageTolerance = getPropertyValue("standardImageTolerance","70");
    // Motion options
    public static String swipeSpeed = getPropertyValue("SwipeSpeed","40");
    // More options
    public static String mouseClickDelay = getPropertyValue("mouseClickDelay",".02");
    public static String remoteWorkInterval = getPropertyValue("remoteWorkInterval","0.1");


    //  TEST PROPERTIES

    private static Map<String, String> testProperties = getTestProperties(getPropertyValue("modulePrefix", ""));
    /** Get the test properties. */
    public static String getTestProp(String key) {
        return testProperties.get(key);
    }

    private static Map<String, String> getTestProperties(String modulePrefix) {
        if (properties == null) init();

        HashMap<String, String> props = new HashMap<String, String>();
        String[] prefixes = modulePrefix.split(",");
        for (String prefix : prefixes) {
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                if (((String) entry.getKey()).contains(prefix)) {
                    props.put((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        return props;
    }

    /** Reads the config.properties file and returns an integer for a specific value.  Default value used if key not found   */
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
            Logger.info("Config file not found, using defaults.");
        } else {
            try {
                properties.load(input);
            } catch (IOException e) {
                Logger.error("Could not load config file. " + e.getMessage());
            }
        }
    }

    /** Reads the config.properties file and returns an String for a specific value.  Default value used if key not found   */
     public static String getPropertyValue(String key, String defaultValue) {
        if (properties == null) init();

        return properties.getProperty(key, System.getProperty(key, defaultValue));
    }
    /** Reads the config.properties file and returns an boolean for a specific value.  Default value used if key not found   */
    public static boolean getPropertyValue(String key, boolean defaultValue) {
        if (properties == null) init();

        String result = getPropertyValue(key, System.getProperty(key, null));
        if (result == null) return defaultValue;
        return isTruthy(result);
    }
    /** Reads the config.properties file and sets a key to a specific value.  Use this to write to the config.properties file.   */
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

    /** Converts from a string true/false expression to a boolean.  */
    private static boolean isTruthy(String value) {
        return value.equals("True") || value.equals("true");
    }

    /** Gets the current log level. */
    private static int getLogLevel(String propertyValue) {
        if (propertyValue.toLowerCase().equals("debug")) {
            return 0;
        } else if (propertyValue.toLowerCase().equals("info")) {
            return 1;
        } else if (propertyValue.toLowerCase().equals("warning")) {
            return 2;
        } else if (propertyValue.toLowerCase().equals("error")) {
            return 3;
        } else {
            return Integer.parseInt(propertyValue);
        }
    }

}
