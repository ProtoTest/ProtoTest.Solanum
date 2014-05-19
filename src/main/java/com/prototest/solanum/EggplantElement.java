package com.prototest.solanum;

import org.joda.time.LocalTime;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class EggplantElement {
    private By by;
    private String name;
    private EggplantDriver driver = EggplantTestBase.driver;

    public EggplantElement(String name, By by) {
        this.by = by;
        this.name = name;
    }
    public EggplantElement(By by) {
        this.by = by;
        this.name = "element";
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            // TODO should we actually interrupt execution? What cases will interrupt be called?
            Thread.currentThread().interrupt();
        }
    }

    public boolean isPresent() {
        return driver.isPresent(by.getLocator());
    }

    public String getText() {
        waitForPresent();
        Logger.message(String.format("Reading text on %s %s.", name, by.getLocator()));
        return driver.readText(by.getLocator());
    }


    public EggplantElement click() {

        waitForPresent();
        Logger.message(String.format("Clicking on %s %s.", name, by.getLocator()));
        driver.click(by.getLocator());
        return this;
    }

    public EggplantElement doubleClick() {
        waitForPresent();
        Logger.message(String.format("Double-clicking on %s %s.",name,  by.getLocator()));
        sleep(Config.clickExecuteDelay);
        driver.doubleTap(by.getLocator());
        sleep(1000);
        return this;
    }

    public EggplantElement press() {
        waitForPresent();
        Logger.message(String.format("Performing click+hold on %s %s.", name, by.getLocator()));
        driver.press(by.getLocator());
        sleep(1000);
        return this;
    }


    public EggplantElement type(String text) {
        Logger.message(String.format("Clicking on %s",name));
        click();
        Logger.message(String.format("Typing text:(%s).", text));
        sleep(2000);
        driver.typeText(text);
        sleep(2000);
        return this;
    }

    // Hard verification failures - Test will halt
    public EggplantElement waitForPresent() {
        return waitForPresent(Config.elementWaitTimeSec);
    }

    public EggplantElement waitForPresent(int secs) {

        Logger.message(String.format("Waiting for %s to be present within %d ms.", by.getLocator(), secs));
        LocalTime now = new LocalTime();
        LocalTime endTime = now.plusSeconds(secs);
        while (now.isBefore(endTime) && !Thread.interrupted()) {
            if (isPresent()) {
                Logger.message(String.format("Verification Passed : %s %s is present.", name, by.getLocator()));
                return this;
            } else {
                sleep(500);
                now = new LocalTime();
            }
        }
        //TestLog.BeginSection("ERROR FOUND");
        Logger.message(String.format("!----ERROR : %s not found: %s.", name, by.getLocator()));
        //LogSourceImage();
        //LogFailureImage(string.Format("!----ERROR : Element not found: " + by + "."));
        //TestLog.End();
        throw new RuntimeException(String.format("%s was not present after %d seconds", name, secs));
    }

    private void logSourceImage() {
        throw new NotImplementedException();

//        if (by.Contains("image"))
//        {
//            string nameOfImage = by.Split(':')[1].Trim(' ').Trim(')').Trim('"').Replace("/", "\\");
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

    public EggplantElement waitForNotPresent() {
        return waitForNotPresent(Config.elementWaitTimeSec);
    }

    public EggplantElement waitForNotPresent(int millis) {
        Logger.message(String.format("Waiting for %s %s to not be present for %s seconds.", name, by.getLocator(),millis));
        LocalTime now = new LocalTime();
        LocalTime endTime = now.plusSeconds(millis);
        while (now.isBefore(endTime) && !Thread.interrupted()) {
            if (!driver.isPresent(by.getLocator())) {
                Logger.message("Element no longer present.");
                return this;
            } else {
                sleep(500);
                now = new LocalTime();
            }
        }

        Logger.message(String.format("%s is still present",name, by));
        //logSourceImage();
        throw new RuntimeException(String.format("WaitForNotPresent Failed : %s was still present after %d seconds", name, millis));
    }

    // Soft verification failures - Test will keep progressing
    public EggplantElement verifyPresent() {
        Logger.message(String.format("Verifying %s %s should be present.", name, by.getLocator()));
        Verifications.addVerification(String.format("%s %s should be present.", name, by.getLocator()), driver.isPresent(by.getLocator()));
        return this;
    }

    public EggplantElement verifyNotPresent() {
        Logger.message(String.format("Verifying %s %s is not be present.",name, by));
        Verifications.addVerification(String.format("%s %s should be present.",name, by.getLocator()), ! driver.isPresent(by.getLocator()));
        return this;
    }

    public String getName() {
        return name;
    }
}

