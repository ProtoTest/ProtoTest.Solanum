package com.prototest.solanum;

import org.apache.xmlrpc.XmlRpcException;

import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * Created by Brian on 5/12/2014.
 */
public class EggplantDriver {

    private EggplantDriveClient client;

    public EggplantDriver() {
        this.client = new EggplantDriveClient();
    }

    public void connect() {
        connect(Config.hostName,Config.hostPort);
    }

    public void connect(String host) {
        execute(String.format("Connect (ServerID:\"%s\")", host));
    }

    public void connect(String host, int portNum) {
        execute(String.format("Connect (ServerID:\"%s\", portNum: \"%s\")", host, portNum));
    }

    public void disconnect() {
        execute(String.format("Disconnect"));

    }

    public HashMap<String, String> execute(String command) {
        if (Config.logDriveCommands) {
            Logger.message(String.format("Executing : %s", command));
        }
        //delay(Config.commandDelayMs);
        HashMap result = client.execute(command);
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
            Logger.message(String.format("Starting Suite : %s", path));
        }
        client.startSession(path);
    }


    public void endSuite(){
        if(Config.logDriveCommands){
            Logger.message("Ending Curernt Suite");
        }
        client.endSession();
    }

    public EggplantElement findElement(By by)
    {
        return new EggplantElement(by);
    }

    public void click(String locator)
    {
        execute(String.format("Click %s", locator));
    }

    public void tap(String locator)
    {
        execute(String.format("Tap %s", locator));
    }

    public void doubleTap(String locator)
    {
        execute(String.format("DoubleTap %s", locator));
    }

    public void press(String locator)
    {
        execute(String.format("Press %s", locator));
    }

    public void release(String locator)
    {
        execute(String.format("Release %s", locator));
    }

    public void drag(String locator)
    {
        execute(String.format("Drag %s", locator));
    }

    public void drop(String locator)
    {
        execute(String.format("Drop %s", locator));
    }

    public void dragAndDrop(String fromlocator, String tolocator)
    {
        drag(fromlocator);
        drop(tolocator);
    }

    public void waitFor(String locator, String timeoutSec)
    {
        execute(String.format("WaitFor %s, %s",locator,timeoutSec));
    }

    public void rightClick(String locator)
    {
        execute(String.format("RightClick ", locator));
    }

    public boolean isPresent(String locator)
    {
        HashMap<String,String> output = (HashMap<String,String>)execute(String.format("put ImageFound %s", locator));
        String result = (String) output.get("Output");
        return result.contains("True");
    }

    public void typeText(String text)
    {
        execute(String.format("TypeText \"%s\""));
    }

    public void scrollWheelUp(String num)
    {
        execute(String.format("ScrollWheelUp %s", num));
    }

    public void scrollWheelDown(String num)
    {
        execute(String.format("ScrollWheelDown %s", num));
    }

    public void swipeDown(Point origin)
    {
        execute(String.format("SwipeDown (%s,%s)",origin.x,origin.y));
    }

    public void swipeUp(Point origin)
    {
        execute(String.format("SwipeUp (%s,%s)",origin.x,origin.y));
    }

    public void swipeLeft(Point origin)
    {
        execute(String.format("SwipeLeft (%s,%s)",origin.x,origin.y));
    }

    public void swipeRight(Point origin)
    {
        execute(String.format("SwipeDown (%s,%s)",origin.x,origin.y));
    }


    public String getScreenshot()
    {
        try
        {
            java.util.Date date = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhhmmss");
            String timestamp = sdf.format(date);

            new File(Config.currentPath +"\\Screenshots\\").mkdirs();
            String path = Config.currentPath + "\\Screenshots\\"+timestamp+".png";
            captureScreenshot(path);
            return path;
        }
        catch (Exception e)
        {
            Logger.warning("Error capturing image : " + e.getMessage());
        }
        return null;
    }

    public void captureScreenshot(String path){
        execute(String.format("CaptureScreen (Name: \"%s\")",path ));
    }

    public String readText(String locator)
    {
        String result = execute(String.format("put ReadText %s" + locator)).get("Result");
       return result;
    }

    public Rectangle getScreenRectangle()
    {
        String output = execute("put RemoteScreenRectangle()").get("Output").trim();
        output = output.substring(1,output.length()-1);
        String[] rect = output.split(",");

        return new Rectangle(Integer.parseInt(rect[0]),Integer.parseInt(rect[1]),Integer.parseInt(rect[2]),Integer.parseInt(rect[3]));
    }

    public String getConnectionInfo()
    {
        return (String) execute("put ConnectionInfo()").get("Output");
    }

    public String getOptions()
    {
        String output = (String) execute("put getOptions()").get("Output");
        return output;
    }

    public String getOption(String option)
    {
        String output = (String) execute(String.format("put getOption(%s)",option)).get("Output");
        return output;
    }

    public void setOption(String option,String value)
    {
        execute(String.format("set the %s to %s",option,value));
    }
}
