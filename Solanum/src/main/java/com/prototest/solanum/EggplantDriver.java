package com.prototest.solanum;

import com.google.common.base.Joiner;
import org.joda.time.LocalTime;

import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * EggplantDriver contains all device-level api calls.
 * It translates each function into the appropriate SenseTalk command, and passes it into the EggplantClient to be executed.
 * This class is similar in design and scope to the WebDriver class in selenium.
 *
 * <b>For internal Solanum use only. Use {@link EggplantElement} to interact with EggPlant.</b>
 */
public class EggplantDriver {

    private EggplantDriveClient client;
    //private Rectangle screenRectangle;
    //private Point screenSize;
    PrintWriter writer;


    public EggplantDriver() {
        this.client = new EggplantDriveClient();
        createLogFile();
    }

    private void createLogFile(){
        try {
            this.writer = new PrintWriter("output.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            File file = new File("output.txt");
            try {
                file.createNewFile();
                createLogFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Connect to the host specified by Config.hostName : Config.hostPort
     */
    public void connect() {
        connect(Config.hostName, Config.hostPort);
    }

    /**
     * Connect to a specific host if the port is not known.
     */
    public void connect(String host) {
        execute(String.format("Connect (ServerID:\"%s\")", host));
        Logger.debug("Connected to device : " + getConnectionInfo());
    }

    /**
     * Connect to a specific host, with eggOn running on the port specified.
     */
    public void connect(String host, int portNum) {
        execute(String.format("Connect (ServerID:\"%s\", portNum: \"%s\")", host, portNum));
        Logger.debug("Connected to device : " + getConnectionInfo());
    }

    public Rectangle getScreenRectangle() {
        //  if(this.screenRectangle == null){
        String screenRectString = execute("put RemoteScreenRectangle()").Output;
        String[] rect = parseCoordinates(screenRectString);
        Rectangle screenRectangle = new Rectangle(Integer.parseInt(rect[0]),
                Integer.parseInt(rect[1]),
                Integer.parseInt(rect[2]),
                Integer.parseInt(rect[3]));
        return screenRectangle;
    }

    /**
     * Disconnect from the current host (device under test).
     */
    public void disconnect() {
        disconnect(Config.hostName, Config.hostPort);

    }

    /**
     * Disconnect from a specific host
     */
    public void disconnect(String host) {
        execute(String.format("Disconnect (ServerID:\"%s\")", host));
    }

    /**
     * Disconnect from a specific host with eggplant running at a specific port.
     */
    public void disconnect(String host, int portNum) {
        execute(String.format("Disconnect (ServerID:\"%s\", portNum: \"%s\")", host, portNum));
    }

    /**
     * Executes a given RunScript command by passing it into the EggplantClient
     */
    public EggplantResponse execute(String command) {
        delay(Config.commandDelayMs);
        EggplantResponse result = client.execute(command);
        return result;

    }

    /**
     * Pause the test for these milliseconds
     */
    public void delay(int ms) {
        try {
            Thread.sleep(Config.commandDelayMs);
        } catch (InterruptedException e) {
        }
    }

    /**
     * Start a specific eggPlant suite.  Should be passed the location on the local hard drive to the .suite directory.
     */
    public void startSuite(String path) {
        if (Config.logDriveCommands) {
            Logger.debug(String.format("Starting Suite : %s", path));
        }
        client.startSession(path);
    }

    /**
     * Ends the current suite.
     */
    public void endSuite() {
        if (Config.logDriveCommands) {
            Logger.debug("Ending Current Suite");
        }
        client.endSession();
    }

    /**
     * Find an eggplant element using a By locator
     */
    public EggplantElement findElement(By by) {
        return findElement(by.getLocator());
    }

    /**
     * Finds a list of all the locations of a specific locator on the page.
     */
    public List<EggplantElement> findElements(By by) {
        return findElements(by.getLocator());
    }

    /**
     * Find an element using a string locator
     */
    public EggplantElement findElement(String locator) {
        String output = execute(String.format("Put ImageLocation %s", locator)).Output;
        String[] rect = parseCoordinates(output);
        Point point = new Point(Integer.parseInt(rect[0]), Integer.parseInt(rect[1]));
        return new EggplantElement(By.Point(point));
    }

    /**
     * Finds an element and returns the location as a point using a by locator.
     */
    public Point findLocation(By by) {
        return findLocation(by.getLocator());
    }

    /**
     * Finds an element and returns the location as a point using a string locator.
     */
    public Point findLocation(String locator) {
        try {
            String output = execute(String.format("Put ImageLocation %s", locator)).Output;
            String[] rect = parseCoordinates(output);
            Point point = new Point(Integer.parseInt(rect[0]), Integer.parseInt(rect[1]));
            return point;
        } catch (Exception e) {
            if (!e.getMessage().contains("Image Not Found")) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return null;
    }

    /**
     * Finds a list of all the instances of an element on the page.
     */
    public List<EggplantElement> findElements(String locator) {
        return everyImageLocation(locator);
    }

    /**
     * Clicks on an element, using a string locator
     */
    public void click(String locator) {
        execute(String.format("Click %s", locator));
    }

    /**
     * Tap on an element, using a string locator
     */
    public void tap(String locator) {
        execute(String.format("Tap %s", locator));
    }

    /**
     * DoubleTap on an element, using a string locator
     */
    public void doubleTap(String locator) {
        execute(String.format("DoubleTap %s", locator));
    }

    /**
     * Long press on an element, using a string locator
     */
    public void press(String locator) {
        execute(String.format("Press %s", locator));
    }

    /**
     * Release a press on an element, using a string locator
     */
    public void release(String locator) {
        execute(String.format("Release %s", locator));
    }

    /**
     * Start dragging an element, using a string locator.  Should be followed by a drop
     */
    public void drag(String locator) {
        execute(String.format("Drag %s", locator));
    }

    /**
     * Drops the currently dragging element to a specific location.  Should be preceded by drag
     */
    public void drop(String locator) {
        execute(String.format("Drop %s", locator));
    }

    /**
     * Drag an element to another element
     */
    public void dragAndDrop(String fromlocator, String tolocator) {
        drag(fromlocator);
        drop(tolocator);
    }

    /**
     * Refresh the current view of the device under test.
     */
    public void refreshScreen() {
        execute("RefreshScreen");
    }

    /**
     * Internal Eggplant WaitFor command.  Waits for an element using a string locator to appear in the time specified
     */
    public void waitFor(String locator, String timeoutSec) {
        execute(String.format("WaitFor %s, %s", timeoutSec,locator));
    }


    /**
     * Waits for an Element to be preseent for up the to the time specified
     */
    public void waitForPresent(String locator, Integer waitTimeSec) {
        waitFor(locator,waitTimeSec.toString());
    }

    /**
     * Waits for an Element to not be preseent for up the to the time specified
     */
    public void waitForNotPresent(String locator, Integer waitTimeSec) {
        setOption("ImageSearchCount", "1");
        LocalTime now = new LocalTime();
        LocalTime endTime = now.plusSeconds(waitTimeSec);
        while (now.isBefore(endTime) && !Thread.interrupted()) {

            if (!isPresent(locator)){
                setOption("ImageSearchCount", Config.imageSearchCount);
                return;
            } else {
                refreshScreen();
                now = new LocalTime();
            }
        }
        throw new RuntimeException(String.format("Element %s is still present after %s seconds",locator,waitTimeSec));
    }

    /**
     * RightClicks on an element, using a string locator
     */
    public void rightClick(String locator) {
        execute(String.format("RightClick ", locator));
    }

    /**
     * Returns whether an element is present on the screen, using a string locator
     */
    public boolean isPresent(String locator) {
        return execute(String.format("put ImageFound %s", locator)).Output.contains("True");
    }


    /**
     * Returns whether an element is present on the screen, using a string locator
     */
    public boolean isPresent(String locator, Integer timeoutSec) {
        return execute(String.format("put ImageFound (%s,%s)", timeoutSec, locator)).Output.contains("True");
    }
    /**
     * Types the given text.  Will type into whatever element has focus.  So should be preceded by a click command to type into a specific field
     */
    public void typeText(String text) {
        execute(String.format("TypeText \"%s\"", text));
    }

    /**
     * Sends the following keys.  Should be used for Eggplant Keys, like HomeButton, and not to type standard text.
     */
    public void sendKeys(String keyText) {
        execute(String.format("TypeText %s", keyText));
    }

    /**
     * Scrolls up using the mouse wheel.  Not all devices support this command.
     */
    public void scrollWheelUp(String num) {
        execute(String.format("ScrollWheelUp %s", num));
    }

    /**
     * Scrolls downn using the mouse wheel.  Not all devices support this command.
     */
    public void scrollWheelDown(String num) {
        execute(String.format("ScrollWheelDown %s", num));
    }

    /**
     * Swipes down from the given point. The swipe length and speed cannot be controlled.
     */
    public void swipeDown(Point origin) {
        execute(String.format("SwipeDown (%s,%s)", origin.x, origin.y));
    }

    /**
     * Swipes down from the given element locator. The swipe length and speed cannot be controlled.
     */
    public void swipeDown(String locator) {
        execute(String.format("SwipeDown %s", locator));
    }

    /**
     * Swipes up from the given element locator. The swipe length and speed cannot be controlled.
     */
    public void swipeUp(String locator) {
        execute(String.format("SwipeUp %s", locator));
    }

    /**
     * Swipes right from the given element locator. The swipe length and speed cannot be controlled.
     */
    public void swipeRight(String locator) {
        execute(String.format("SwipeRight %s", locator));
    }

    /**
     * Swipes left from the given element locator. The swipe length and speed cannot be controlled.
     */
    public void swipeLeft(String locator) {
        execute(String.format("SwipeLeft %s", locator));
    }

    /**
     * Swipes up from the given point. The swipe length and speed cannot be controlled.
     */
    public void swipeUp(Point origin) {
        execute(String.format("SwipeUp (%s,%s)", origin.x, origin.y));
    }

    /**
     * Swipes left from the given point. The swipe length and speed cannot be controlled.
     */
    public void swipeLeft(Point origin) {
        execute(String.format("SwipeLeft (%s,%s)", origin.x, origin.y));
    }

    /**
     * Swipes right from the given point. The swipe length and speed cannot be controlled.
     */
    public void swipeRight(Point origin) {
        execute(String.format("SwipeDown (%s,%s)", origin.x, origin.y));
    }

    /**
     * Gets a screenshot of the current device, and returns the location of the file on the local hard drive.
     */
    public String getScreenshot() {
        return getScreenshot("");
    }

    /**
     * Gets a screenshot at the specified location.  Should return actual the path to the image.
     */
    public String getScreenshot(String name) {
        try {
            if (name == null) name = "";
            java.util.Date date = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhhmmss");
            String timestamp = sdf.format(date);
            name += "_" + timestamp;
            String separator = System.getProperty("file.separator");
            new File(Config.currentPath + separator + "Screenshots" + separator).mkdirs();
            String extension = "";
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                extension = ".png";
            } else {
                extension = ".tiff";
            }
            String path = Config.currentPath + separator + "Screenshots" + separator + name + extension;
            captureScreenshot(path);
            return path;
        } catch (Exception e) {
            Logger.warning("Error capturing image : " + e.getMessage());
        }
        return null;
    }

    /**
     * Capture a screenshot to the specified path
     */
    public void captureScreenshot(String path) {
        execute(String.format("CaptureScreen (Name: \"%s\")", path));
    }

    /**
     * Reads the text on the device for a specific element locator.
     */
    public String readText(String locator) {
        EggplantResponse result = execute(String.format("put ReadText ((%s))", locator));
        List<String> resultLines = Arrays.asList(result.Output.split("\n"));
        return Joiner.on("\n").join(resultLines.subList(1, resultLines.size()));
    }

    /**
     * Reads all text currently visible on the device.
     */
    public String getAllText() {

        SearchRectangle rectangle = SearchRectangle.wholeScreen();

        String locatorString = String.format("(%s,%s,%s,%s)", rectangle.upperLeft.x, rectangle.upperLeft.y, rectangle.lowerRight.x, rectangle.lowerRight.y);
        return readText(locatorString);
    }

    /**
     * Gets the screen size of the current device as a x,y point representing the bottom right corner
     */
    public Point getScreenSize() {
        String screenSizeString = execute("put RemoteScreenSize()").Output;
        screenSizeString = screenSizeString.substring(1, screenSizeString.length() - 1);
        String[] screenSizeRect = screenSizeString.split(",");
        Point screenSize = new Point(Integer.parseInt(screenSizeRect[0]), Integer.parseInt(screenSizeRect[1]));
        return screenSize;
    }

    /**
     * Gets the currently connected device's information from eggPlant
     */
    public String getConnectionInfo() {
        return (String) execute("put ConnectionInfo()").Output;
    }

    /**
     * Gets the current values of eggplant options.
     */
    public String getOptions() {
        String output = execute("put getOptions()").Output;
        return output;
    }

    /**
     * Gets the value of a specific option
     */
    public String getOption(String option) {
        String output = (String) execute(String.format("put getOption(%s)", option)).Output;
        return output;
    }

    /**
     * Sets an eggplant option to have a specific value.
     */
    public void setOption(String option, String value) {
        execute(String.format("set the %s to %s", option, value));
    }

    /**
     * Try to call the eggplant drive service.  If an exception is thrown, we know drive is not running.
     */
    public boolean isDriveRunning() {
        try {
            getOptions();
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    /**
     * Gets a Rectangle representing the outer dimensions of a given element locator
     */
    public Rectangle getImageRectangle(String locator) {
        String output = execute(String.format("Put ImageRectangle %s", locator)).Output;

        String[] rect = parseCoordinates(output);
        return new Rectangle(Integer.parseInt(rect[0]), Integer.parseInt(rect[1]), Integer.parseInt(rect[2]), Integer.parseInt(rect[3]));

    }

     /**
     * Gets list of every location of the specified element locator string
     */
    public List<EggplantElement> everyImageLocation(String locator) {
        EggplantResponse response = execute(String.format("Put everyImageLocation %s", locator));
        Matcher matcher = Pattern.compile("(\\(\\d+,\\d+\\))").matcher(response.Output);
        List<EggplantElement> elements = new ArrayList<EggplantElement>();
        while (matcher.find()) {
            String[] point = parseCoordinates(matcher.group());
            elements.add(new EggplantElement(
                    By.Point(new Point
                            (Integer.parseInt(point[0]), Integer.parseInt(point[1])))));
        }
        return elements;

    }

    /**
     * Parses the coordinates and returns them in an array.  Used to pull x,y values of of eggplant.
     */
    private String[] parseCoordinates(String output) {
        String complexOutputDelim = "\tat ";
        if (output.contains(complexOutputDelim)) {
            output = output.split("\n")[1];
        }
        output = output.substring(1, output.length() - 1);

        return output.split(",");
    }

    /**
     * Presses the home button on a mobile device
     */
    public void PressHomeButton(){

        Logger.debug("Pressing Mobile Home Button");
        execute("PressHomeButton");
    }

    /**
     * Presses the back button on a mobile device
     */
    public void PressBackButton(){
        Logger.debug("Pressing Mobile Back Button");
        execute("PressBackButton");
    }

}
