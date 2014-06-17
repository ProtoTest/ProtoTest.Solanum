package com.prototest.solanum;

import org.apache.xmlrpc.XmlRpcException;

import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Brian on 5/12/2014.
 */
public class EggplantDriver {

    private EggplantDriveClient client;
    private Rectangle screenRectangle;
    private Point screenSize;

    public EggplantDriver() {
        this.client = new EggplantDriveClient();
    }

    public void connect() {
        connect(Config.hostName, Config.hostPort);
    }

    public void connect(String host) {
        execute(String.format("Connect (ServerID:\"%s\")", host));
        Logger.debug("Connected to device : " + getConnectionInfo());
        initProperties();
    }

    public void connect(String host, int portNum) {
        execute(String.format("Connect (ServerID:\"%s\", portNum: \"%s\")", host, portNum));
        Logger.debug("Connected to device : " + getConnectionInfo());
        initProperties();
    }

    private void initProperties() {
        String screenRectString = execute("put RemoteScreenRectangle()").Output;
        String[] rect = parseCoordinates(screenRectString);
        this.screenRectangle = new Rectangle(Integer.parseInt(rect[0]),
                Integer.parseInt(rect[1]),
                Integer.parseInt(rect[2]),
                Integer.parseInt(rect[3]));

        String screenSizeString = execute("put RemoteScreenSize()").Output;
        screenSizeString = screenSizeString.substring(1, screenSizeString.length() - 1);
        String[] screenSizeRect = screenSizeString.split(",");
        screenSize = new Point(Integer.parseInt(screenSizeRect[0]), Integer.parseInt(screenSizeRect[1]));
    }

    public void disconnect() {
        disconnect(Config.hostName, Config.hostPort);

    }

    public void disconnect(String host) {
        execute(String.format("Disconnect (ServerID:\"%s\")", host));
    }

    public void disconnect(String host, int portNum) {
        execute(String.format("Disconnect (ServerID:\"%s\", portNum: \"%s\")", host, portNum));
    }

    public EggplantResponse execute(String command) {
        if (Config.logDriveCommands) {
            Logger.debug(String.format(":: Execute : '%s'", command));
        }
        delay(Config.commandDelayMs);
        EggplantResponse result = client.execute(command);
        return result;

    }

    public void delay(int ms) {
        try {
            Thread.sleep(Config.commandDelayMs);
        } catch (InterruptedException e) {
        }
    }

    public void startSuite(String path) {
        if (Config.logDriveCommands) {
            Logger.debug(String.format("Starting Suite : %s", path));
        }
        client.startSession(path);
    }


    public void endSuite() {
        if (Config.logDriveCommands) {
            Logger.debug("Ending Current Suite");
        }
        client.endSession();
    }


    public EggplantElement findElement(By by) {
        return findElement(by.getLocator());
    }
    public List<EggplantElement> findElements(By by) {
        return findElements(by.getLocator());
    }
    public EggplantElement findElement(String locator) {
        String output = execute(String.format("Put ImageLocation %s", locator)).Output;
        String[] rect = parseCoordinates(output);
        Point point = new Point(Integer.parseInt(rect[0]), Integer.parseInt(rect[1]));
        return new EggplantElement(By.Point(point));
    }
    public Point findLocation(By by) {
        return findLocation(by.getLocator());
    }
    public Point findLocation(String locator) {
    try{
        String output = execute(String.format("Put ImageLocation %s", locator)).Output;
        String[] rect = parseCoordinates(output);
        Point point = new Point(Integer.parseInt(rect[0]), Integer.parseInt(rect[1]));
        return point;
    }
    catch(Exception e){
        if(!e.getMessage().contains("Image Not Found")){
            throw new RuntimeException(e.getMessage());
        }
    }
        return null;
    }

    public List<EggplantElement> findElements(String locator) {
        return EveryImageLocation(locator);
    }

    public void click(String locator) {
        execute(String.format("Click %s", locator));
    }

    public void tap(String locator) {
        execute(String.format("Tap %s", locator));
    }

    public void doubleTap(String locator) {
        execute(String.format("DoubleTap %s", locator));
    }

    public void press(String locator) {
        execute(String.format("Press %s", locator));
    }

    public void release(String locator) {
        execute(String.format("Release %s", locator));
    }

    public void drag(String locator) {
        execute(String.format("Drag %s", locator));
    }

    public void drop(String locator) {
        execute(String.format("Drop %s", locator));
    }

    public void dragAndDrop(String fromlocator, String tolocator) {
        drag(fromlocator);
        drop(tolocator);
    }

    public void refreshScreen(){
        execute("RefreshScreen");
        initProperties();
    }


    public void waitFor(String locator, String timeoutSec) {
        execute(String.format("WaitFor %s, %s", locator, timeoutSec));
    }

    public void rightClick(String locator) {
        execute(String.format("RightClick ", locator));
    }

    public boolean isPresent(String locator) {
        return execute(String.format("put ImageFound %s", locator)).Output.contains("True");
    }

    public void typeText(String text) {
        execute(String.format("TypeText \"%s\"", text));
    }

    public void sendKeys(String keyText) {
        execute(String.format("TypeText %s", keyText));
    }

    public void scrollWheelUp(String num) {
        execute(String.format("ScrollWheelUp %s", num));
    }

    public void scrollWheelDown(String num) {
        execute(String.format("ScrollWheelDown %s", num));
    }

    public void swipeDown(Point origin) {
        execute(String.format("SwipeDown (%s,%s)", origin.x, origin.y));
    }

    public void swipeDown(String locator) {
        execute(String.format("SwipeDown %s", locator));
    }

    public void swipeUp(String locator) {
        execute(String.format("SwipeUp %s", locator));
    }


    public void swipeRight(String locator) {
        execute(String.format("SwipeRight %s", locator));
    }

    public void swipeLeft(String locator) {
        execute(String.format("SwipeLeft %s", locator));
    }

    public void swipeUp(Point origin) {
        execute(String.format("SwipeUp (%s,%s)", origin.x, origin.y));
    }

    public void swipeLeft(Point origin) {
        execute(String.format("SwipeLeft (%s,%s)", origin.x, origin.y));
    }

    public void swipeRight(Point origin) {
        execute(String.format("SwipeDown (%s,%s)", origin.x, origin.y));
    }

    public String getScreenshot() {
        return getScreenshot("");
    }

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

    public void captureScreenshot(String path) {
        execute(String.format("CaptureScreen (Name: \"%s\")", path));
    }

    public String readText(String locator) {
        EggplantResponse result = execute(String.format("put ReadText %s" , locator));
        return result.Output;
    }

    public String getAllText(){

        SearchRectangle rectangle = SearchRectangle.wholeScreen();

      String locatorString = String.format("(%s,%s,%s,%s)", rectangle.upperLeft.x,rectangle.upperLeft.y,rectangle.lowerRight.x,rectangle.lowerRight.y);
      return readText(locatorString);
    }

    public Point getScreenSize() {
        return screenSize;
    }

    public String getConnectionInfo() {
        return (String) execute("put ConnectionInfo()").Output;
    }

    public String getOptions() {
        String output = execute("put getOptions()").Output;
        return output;
    }

    public String getOption(String option) {
        String output = (String) execute(String.format("put getOption(%s)", option)).Output;
        return output;
    }

    public void setOption(String option, String value) {
        execute(String.format("set the %s to %s", option, value));
    }

    public boolean isDriveRunning() {
        try {
            getOptions();
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public Rectangle getImageRectangle(String locator) {
        String output = execute(String.format("Put ImageRectangle %s", locator)).Output;

        String[] rect = parseCoordinates(output);
        return new Rectangle(Integer.parseInt(rect[0]), Integer.parseInt(rect[1]), Integer.parseInt(rect[2]), Integer.parseInt(rect[3]));

    }


    public Rectangle getScreenRectangle() {
        return screenRectangle;
    }

    public List<EggplantElement> EveryImageLocation(String locator) {
        EggplantResponse response = execute(String.format("Put EveryImageLocation %s", locator));
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

    private String[] parseCoordinates(String output) {
        String complexOutputDelim = "\tat ";
        if (output.contains(complexOutputDelim)) {
            output = output.split("\n")[1];
        }
        output = output.substring(1, output.length() - 1);

        return output.split(",");
    }
}
