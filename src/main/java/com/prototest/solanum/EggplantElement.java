package com.prototest.solanum;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Brian on 5/12/2014.
 */
public class EggplantElement {
    private By locater;
    private String name;
    private EggplantDriver driver = EggplantTestBase.DRIVER;


    public EggplantElement(By by) {
        locater = by;
        name = by.toString();
    }

    public boolean isPresent()
    {
        throw new NotImplementedException();
//        return driver.IsPresent(locator);
    }

    public String getText()
    {
        throw new NotImplementedException();

//        WaitForPresent();
//        Log.Message(string.Format("Reading text on element {0}.", locator));
//        var text = Driver.ReadText(locator);
//        return text;
    }



    public EggplantElement click()
    {
        throw new NotImplementedException();

//        WaitForPresent();
//        Log.Message(string.Format("Clicking on element {0}.",locator));
//        Thread.Sleep(Config.ClickExecuteDelay);
//        Driver.Click(locator);
//        Thread.Sleep(2000);
//        return this;
    }

    public EggplantElement doubleClick()
    {
        throw new NotImplementedException();

//        WaitForPresent();
//        Log.Message(string.Format("Double-clicking on element {0}.", locator));
//        Thread.Sleep(Config.ClickExecuteDelay);
//        Driver.DoubleTap(locator);
//        Thread.Sleep(2000);
//        return this;
    }

    public EggplantElement press()
    {
        throw new NotImplementedException();

//        WaitForPresent();
//        Log.Message(string.Format("Performing click+hold on element {0}.", locator));
//        Driver.Press(locator);
//        Thread.Sleep(2000);
//        return this;
    }

    public EggplantElement type(String text)
    {
        throw new NotImplementedException();

//        Log.Message(string.Format("Clicking on text field..."));
//        Click();
//        Log.Message(string.Format("Typing text:({0}).", text));
//        Thread.Sleep(2000);
//        Driver.Type(text);
//        Thread.Sleep(2000);
//        return this;
    }

    // Hard verification failures - Test will halt
    public EggplantElement waitForPresent()
    {
        throw new NotImplementedException();

//        return WaitForPresent(Config.ElementWaitSec);
    }

    public EggplantElement waitForPresent(int secs)
    {
        throw new NotImplementedException();

//        Log.Message(string.Format("Waiting for element {0} to be present within (" + secs + ") seconds.",locator));
//        var now = DateTime.Now;
//        var endTime = DateTime.Now.AddSeconds(secs);
//        while(now<endTime)
//        {
//            if (Driver.IsPresent(locator))
//            {
//                Log.Message(string.Format("Verification Passed : Element {0} is present.", locator));
//                return this;
//            }
//            else
//            {
//                Thread.Sleep(500);
//                now = DateTime.Now;
//            }
//        }
//        TestLog.BeginSection("ERROR FOUND");
//        Log.Message(string.Format("!----ERROR : Element not found: " + locator + "."));
//        LogSourceImage();
//        //LogFailureImage(string.Format("!----ERROR : Element not found: " + locator + "."));
//        TestLog.End();
//        throw new Exception(string.Format("Element was not present after {0} seconds", secs));
    }

    private void logSourceImage()
    {
        throw new NotImplementedException();

//        if (locator.Contains("image"))
//        {
//            string nameOfImage = locator.Split(':')[1].Trim(' ').Trim(')').Trim('"').Replace("/", "\\");
//            string pathToImage = Config.SuitePath + "\\Images\\" + nameOfImage;
//            if (Directory.Exists(pathToImage))
//            {
//                TestLog.Failures.WriteLine("Below element collection was not found on device screen - refer to attached screenshot.");
//                TestLog.Failures.WriteLine("Note: screenshot will not appear if error was within Teardown.");
//                foreach (var file in Directory.GetFiles(pathToImage, "*.png"))
//                {
//                    TestLog.Failures.EmbedImage(null, Image.FromFile(file));
//                    TestLog.EmbedImage(null, Image.FromFile(file));
//                }
//            }
//            else
//            {
//                pathToImage += ".png";
//                TestLog.Failures.WriteLine("Below element was not found on device screen - refer to attached screenshot.");
//                TestLog.Failures.WriteLine("Note: screenshot will not appear if error was within Teardown.");
//                TestLog.Failures.EmbedImage(null, Image.FromFile(pathToImage));
//                TestLog.EmbedImage(null, Image.FromFile(pathToImage));
//            }
//
//        }
    }

    public EggplantElement waitForNotPresent()
    {
        throw new NotImplementedException();

//        return WaitForNotPresent(Config.ElementWaitSec);
    }

    public EggplantElement waitForNotPresent(int secs)
    {
        throw new NotImplementedException();

//        Log.Message(string.Format("Waiting for element {0} to not be present for " +secs+ " seconds.", locator));
//        var now = DateTime.Now;
//        var endTime = DateTime.Now.AddSeconds(secs);
//        while (now < endTime)
//        {
//            if (!Driver.IsPresent(locator))
//            {
//                Log.Message("Element no longer present.");
//                return this;
//            }
//            else
//            {
//                Thread.Sleep(500);
//                now = DateTime.Now;
//            }
//        }
//
//        Log.Message(string.Format("Element still present: " + locator));
//        LogSourceImage();
//        throw new Exception(string.Format("WaitForNotPresent Failed : Element was still present after {0} seconds", secs));
    }

    // Soft verification failures - Test will keep progressing
    public EggplantElement verifyPresent()
    {
        throw new NotImplementedException();

//        Log.Message(string.Format("Verifying element {0} should be present.",locator));
//        if (!Driver.IsPresent(locator))
//        {
//            VerificationErrors.AddVerificationError(string.Format("Verification Error : Element {0} should be present.", locator));
//        }
//        else
//        {
//            Log.Message(string.Format("Verification Passed : Element {0} is present.", locator));
//        }
//        return this;
    }

    public EggplantElement verifyNotPresent()
    {
        throw new NotImplementedException();

//        Log.Message(string.Format("Verifying element {0} is not be present.",locator));
//
//        if (Driver.IsPresent(locator))
//        {
//            VerificationErrors.AddVerificationError(string.Format("Verification Error : Element {0} should not be present.",locator));
//        }
//        else
//        {
//            Log.Message(string.Format("Verification Passed : Element {0} is not be present",locator));
//        }
//        return this;
    }

    public String getName() {
        return name;
    }
}

