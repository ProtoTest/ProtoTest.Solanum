package com.prototest.solanum;

import org.apache.xmlrpc.XmlRpcException;

import java.awt.*;
import java.text.SimpleDateFormat;

/**
 * Created by Brian on 5/12/2014.
 */
public class EggplantDriver {

    private EggplantDriveClient client;

    public EggplantDriver(){
        this.client = new EggplantDriveClient();
    }
    public void connect(String host) {
        execute(String.format("Connect (ServerID:\"%s\")",host));
    }
    public void connect(String host,int portNum){
        execute(String.format("Connect (ServerID:\"%s\", portNum: \"%s\")",host,portNum));
    }

     public void disconnect(){
         execute(String.format("Disconnect"));

     }

    public Object execute(String command)
    {
        if(Config.logDriveCommands){
            Logger.message(String.format("Executing : %s", command));
        }
        delay(Config.commandDelayMs);
            return client.execute(command);

    }

    public void delay(int ms){
        try {
            Thread.sleep(Config.commandDelayMs);
        } catch (InterruptedException e) {
        }
    }

    public void startSuite(String path){
        if(Config.logDriveCommands){
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
        execute(String.format("Click ", locator));
    }

    public void tap(String locator)
    {
        execute(String.format("Tap ", locator));
    }

    public void doubleTap(String locator)
    {
        execute(String.format("DoubleTap", locator));
    }

    public void press(String locator)
    {
        execute(String.format("Press", locator));
    }

    public void release(String locator)
    {
        execute(String.format("Release", locator));
    }

    public void drag(String locator)
    {
        execute(String.format("Drag", locator));
    }

    public void drop(String locator)
    {
        execute(String.format("Drop", locator));
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
        boolean output = (Boolean) execute(String.format("put ImageFound %s", locator));
        return output;
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
            SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhhmmssffff");
            String timestamp = sdf.format(date);
            String path = Config.currentPath + "\\Screenshots\\timestamp.png";
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
        String result = (String) execute(String.format("put ReadText %s" + locator));
       return result;
    }

    public SearchRectangle getScreenRectangle()
    {
        Rectangle output = (Rectangle) execute("put RemoteScreenRectangle()");
        return new SearchRectangle(output);
    }

    public String getConnectionInfo()
    {
        return (String) execute("put ConnectionInfo()");
    }

    public String getOptions()
    {
        String output = (String) execute("put getOptions()");
        return output;
    }

    public String getOption(String option)
    {
        String output = (String) execute(String.format("put getOption(%s)",option));
        return output;
    }

    public void setOption(String option,String value)
    {
        execute(String.format("set the %s to %s",option,value));
    }
}
