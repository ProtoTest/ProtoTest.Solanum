package com.prototest.solanum;

import org.joda.time.LocalTime;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class EggplantElement {
    private By by;
    private By originalBy;
    private String name;
    private EggplantDriver driver = EggplantTestBase.driver;
    private int waitSec;
    private Point location;

    public EggplantElement(String name, By by) {
        this.by = by;
        this.originalBy = by;
        this.name = name;
        this.waitSec = Config.elementWaitTimeSec;
    }

    public EggplantElement(String name, By by, int waitSec) {
        this.by = by;
        this.originalBy = by;
        this.name = name;
        this.waitSec = waitSec;
    }

    public EggplantElement(By by) {
        this.by = by;
        this.originalBy = by;
        this.name = by.getLocator();
        this.waitSec = Config.elementWaitTimeSec;
    }


    public EggplantElement(By by, int waitSec) {
        this.by = by;
        this.originalBy = by;
        this.name = by.getLocator().replaceAll("[()]", "").replaceAll("[:]]", "_").replaceAll("[\"/:]", "-");
        this.waitSec = waitSec;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
        }
    }

    private void findLocation() {
        location = driver.findLocation(originalBy);
    }

    public EggplantElement resetLocation() {
        location = null;
        this.by = originalBy;
        return this;
    }

    public boolean isPresent() {
        if (originalBy.type.equals(By.ByType.point)) return true;
        findLocation();
        if (location == null) {
            return false;
        }
        this.by = By.Point(location);
        return true;
    }

    public boolean isPresent(int secs) {
        LocalTime now = new LocalTime();
        LocalTime endTime = now.plusSeconds(secs);
        while (now.isBefore(endTime) && !Thread.interrupted()) {
            if (isPresent()) {
                return true;
            } else {
                sleep(500);
                now = new LocalTime();
            }
        }
        Logger.info("Element ("+name+") not present after " + secs + " seconds.");
        return false;
    }


    public String getText() {

        waitForPresent();
        Logger.debug(String.format("Reading text on %s %s.", name, by.getLocator()));
        return driver.readText(by.getLocator());
    }


    public EggplantElement click() {
        waitForPresent();
        Logger.debug(String.format("Clicking on %s %s.", name, by.getLocator()));
        driver.click(by.getLocator());
        return this;
    }

    public EggplantElement doubleClick() {
        waitForPresent();
        Logger.debug(String.format("Double-clicking on %s %s.", name, by.getLocator()));
        driver.doubleTap(by.getLocator());
        return this;
    }

    public EggplantElement press() {
        waitForPresent();
        Logger.debug(String.format("Performing click+hold on %s %s.", name, by.getLocator()));
        driver.press(by.getLocator());
        return this;
    }

    public EggplantElement release() {
        waitForPresent();
        Logger.debug(String.format("Performing release on %s %s.", name, by.getLocator()));
        driver.release(by.getLocator());
        return this;
    }


    public EggplantElement tap() {
        waitForPresent();
        Logger.debug(String.format("Tap on %s %s.", name, by.getLocator()));
        driver.tap(by.getLocator());
        return this;
    }

    public EggplantElement doubleTap() {
        waitForPresent();
        Logger.debug(String.format("DoubleTap on %s %s.", name, by.getLocator()));
        driver.doubleTap(by.getLocator());
        return this;
    }

    public EggplantElement type(String text) {
        click();
        Logger.info(String.format("Typing text: (%s).", text));
        driver.typeText(text);
        // Eggplant returns immediately from the TypeText command instead of waiting for the text to type.
        // Compensate by sleeping about 1 second per 3 keys typed.
        EggplantTestBase.sleep(text.length() / 3 * 1000);
        return this;
    }

    public EggplantElement dragTo(EggplantElement element) {
        waitForPresent();
        Logger.debug(String.format("Dragging %s to %s.", name, by.getLocator()));
        driver.drag(by.getLocator());
        driver.drop(element.getBy().getLocator());
        return this;
    }

    public EggplantElement swipeUp() {
        waitForPresent();
        Logger.debug(String.format("SwipingUp %s %s.", name, by.getLocator()));
        driver.swipeUp(by.getLocator());
        return this;
    }

    public EggplantElement swipeDown() {
        waitForPresent();
        Logger.debug(String.format("SwipingDown %s %s.", name, by.getLocator()));
        driver.swipeDown(by.getLocator());
        return this;
    }

    public EggplantElement swipeLeft() {
        waitForPresent();
        Logger.debug(String.format("SwipingLeft %s %s.", name, by.getLocator()));
        driver.swipeLeft(by.getLocator());
        return this;
    }

    public EggplantElement swipeRight() {
        waitForPresent();
        Logger.debug(String.format("SwipingRight %s %s.", name, by.getLocator()));
        driver.swipeRight(by.getLocator());
        return this;
    }

    // Hard verification failures - Test will halt
    public EggplantElement waitForPresent() {
        return waitForPresent(this.waitSec);
    }

    public EggplantElement waitForPresent(int secs) {
        if (by.type.equals(By.ByType.point)) return this;
        Logger.debug(String.format("Waiting for %s to be present within %d seconds.", originalBy.getLocator(), secs));
        if (Config.debugElementLocators) {
            if (by.getSearchRectangle() == null) {
                Logger.screenshot();
            } else {
                Logger.screenshot(by.getSearchRectangle().searchRectangle);
            }
        }
        LocalTime now = new LocalTime();
        LocalTime endTime = now.plusSeconds(secs);
        while (now.isBefore(endTime) && !Thread.interrupted()) {
            if (isPresent()) {
                Logger.debug(String.format("Verification Passed : %s %s is present.", name, originalBy.getLocator()));
                return this;
            } else {
                driver.refreshScreen();
                now = new LocalTime();
            }
        }
        Logger.error(String.format("%s not found: %s.", name, originalBy.getLocator()));
        LogElementDiagnosticInfo();
        if (Config.screenshotOnError && !Config.debugElementLocators) {
            if (originalBy.getSearchRectangle() == null) {
                Logger.screenshot();
            } else {
                Logger.screenshot(originalBy.getSearchRectangle().searchRectangle);
            }
        }
        throw new RuntimeException(String.format("%s was not present after %d seconds", name, secs));
    }

    private void LogElementDiagnosticInfo() {
        if (originalBy.type == By.ByType.image) {
            File image = getBy().getImageFile();
            if (image.isDirectory()) {
                File[] files = image.listFiles();
                Logger.images(files);
            } else {
                Logger.image(image);
            }

        } else if (originalBy.type == By.ByType.text) {
            Logger.warning(driver.getAllText());
        }
    }

    private void logSourceImage() {
        throw new NotImplementedException();
    }

    public EggplantElement waitForNotPresent() {
        return waitForNotPresent(this.waitSec);
    }

    public EggplantElement waitForNotPresent(int secs) {
        if (by.type.equals(By.ByType.point)) return this;
        Logger.debug(String.format("Waiting for %s %s to not be present for %s seconds.", name, originalBy.getLocator(), secs));
        if (Config.debugElementLocators) {
            if (originalBy.getSearchRectangle() == null) {
                Logger.screenshot(getSafeName());
            } else {
                Logger.screenshot(getSafeName(), originalBy.getSearchRectangle().searchRectangle);
            }
        }
        LocalTime now = new LocalTime();
        LocalTime endTime = now.plusSeconds(secs);
        while (now.isBefore(endTime) && !Thread.interrupted()) {

            if (!driver.isPresent(originalBy.getLocator())) {
                Logger.debug("Element no longer present.");
                return this;
            } else {
                driver.refreshScreen();
                now = new LocalTime();
            }
        }

        Logger.error(String.format("%s is still present", name, originalBy));
        LogElementDiagnosticInfo();
        if (Config.screenshotOnError && !Config.debugElementLocators) {
            if (originalBy.getSearchRectangle() == null) {
                Logger.screenshot(getSafeName());
            } else {
                Logger.screenshot(getSafeName(), originalBy.getSearchRectangle().searchRectangle);
            }
        }
        throw new RuntimeException(String.format("WaitForNotPresent Failed : %s was still present after %d seconds", name, secs));
    }

    // Soft verification failures - Test will keep progressing
    public EggplantElement verifyPresent() {
        Logger.debug(String.format("Verifying %s %s should be present.", name, originalBy.getLocator()));
        Verifications.addVerification(String.format("%s %s should be present.", name, originalBy.getLocator()), driver.isPresent(originalBy.getLocator()));
        return this;
    }

    public EggplantElement verifyNotPresent() {
        Logger.debug(String.format("Verifying %s %s is not be present.", name, originalBy));
        Verifications.addVerification(String.format("%s %s should be present.", name, originalBy.getLocator()), !driver.isPresent(originalBy.getLocator()));
        return this;
    }

    public EggplantElement verifyText(String value) {
        waitForPresent();
        Logger.debug(String.format("Verifying %s %s text is %s.", name, originalBy.getLocator(), value));
        Verifications.addVerification(String.format("%s %s should have text %s", name, originalBy.getLocator(), value), getText().equals(value));
        return this;
    }

    public String getSafeName() {
        String newName = this.name.split(",")[0].replaceAll("[:()\"]", "").replaceAll("[ ,\"/\\:]", "-");
        return newName;
    }

    public String getName() {
        return name;
    }

    public By getBy() {
        return by;
    }

    public List<EggplantElement> allInstances() {
        waitForPresent();
        driver.findElement(originalBy.getLocator());
        return driver.EveryImageLocation(originalBy.getLocator());
    }

    public void sendKeys(EggplantKeys... keys) {
        click();
        String keysPart = "";
        for (EggplantKeys key : keys) {
            keysPart += key.keyword + ",";
        }
        keysPart = keysPart.substring(0, keysPart.length() - 1);
        driver.sendKeys(keysPart);
    }

}

