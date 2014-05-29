package com.prototest.solanum;

import org.joda.time.LocalTime;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class EggplantElement {
    private final By by;
    private final String name;
    private final EggplantDriver driver = EggplantTestBase.driver;
    private int waitSec;

    public EggplantElement(String name, By by) {
        this.by = by;
        this.name = name;
        this.waitSec = Config.elementWaitTimeSec;
    }

    public EggplantElement(String name, By by, int waitSec) {
        this.by = by;
        this.name = name;
        this.waitSec = waitSec;
    }

    public EggplantElement(By by) {
        this.by = by;
        this.name = "element";
        this.waitSec = Config.elementWaitTimeSec;
    }

    public EggplantElement(By by, int waitSec) {
        this.by = by;
        this.name = "element";
        this.waitSec = waitSec;
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
        Logger.info(String.format("Typing text:(%s).", text));
        driver.typeText(text);
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

        Logger.debug(String.format("Waiting for %s to be present within %d seconds.", by.getLocator(), secs));
        if (Config.debugElementLocators) {
            if (by.getSearchRectangle() == null) {
                Logger.screenshot(name);
            } else {
                Logger.screenshot(name, by.getSearchRectangle().searchRectangle);
            }
        }
        LocalTime now = new LocalTime();
        LocalTime endTime = now.plusSeconds(secs);
        while (now.isBefore(endTime) && !Thread.interrupted()) {
            if (isPresent()) {
                Logger.debug(String.format("Verification Passed : %s %s is present.", name, by.getLocator()));
                return this;
            } else {
                sleep(500);
                now = new LocalTime();
            }
        }
        Logger.error(String.format("%s not found: %s.", name, by.getLocator()));
        if (Config.screenshotOnError && !Config.debugElementLocators) {
            if (by.getSearchRectangle() == null) {
                Logger.screenshot(name);
            } else {
                Logger.screenshot(name, by.getSearchRectangle().searchRectangle);
            }
        }
        throw new RuntimeException(String.format("%s was not present after %d seconds", name, secs));
    }

    private void logSourceImage() {
        throw new NotImplementedException();
    }

    public EggplantElement waitForNotPresent() {
        return waitForNotPresent(this.waitSec);
    }

    public EggplantElement waitForNotPresent(int secs) {
        Logger.debug(String.format("Waiting for %s %s to not be present for %s seconds.", name, by.getLocator(), secs));
        if (Config.debugElementLocators) {
            if (by.getSearchRectangle() == null) {
                Logger.screenshot(name);
            } else {
                Logger.screenshot(name, by.getSearchRectangle().searchRectangle);
            }
        }
        LocalTime now = new LocalTime();
        LocalTime endTime = now.plusSeconds(secs);
        while (now.isBefore(endTime) && !Thread.interrupted()) {
            if (!driver.isPresent(by.getLocator())) {
                Logger.debug("Element no longer present.");
                return this;
            } else {
                now = new LocalTime();
            }
        }

        Logger.error(String.format("%s is still present", name, by));
        if (Config.screenshotOnError && !Config.debugElementLocators) {
            if (by.getSearchRectangle() == null) {
                Logger.screenshot(name);
            } else {
                Logger.screenshot(name, by.getSearchRectangle().searchRectangle);
            }
        }
        throw new RuntimeException(String.format("WaitForNotPresent Failed : %s was still present after %d seconds", name, secs));
    }

    // Soft verification failures - Test will keep progressing
    public EggplantElement verifyPresent() {
        Logger.debug(String.format("Verifying %s %s should be present.", name, by.getLocator()));
        Verifications.addVerification(String.format("%s %s should be present.", name, by.getLocator()), driver.isPresent(by.getLocator()));
        return this;
    }

    public EggplantElement verifyNotPresent() {
        Logger.debug(String.format("Verifying %s %s is not be present.", name, by));
        Verifications.addVerification(String.format("%s %s should be present.", name, by.getLocator()), !driver.isPresent(by.getLocator()));
        return this;
    }

    public EggplantElement verifyText(String value) {
        waitForPresent();
        Logger.debug(String.format("Verifying %s %s text is %s.", name, by.getLocator(), value));
        Verifications.addVerification(String.format("%s %s should have text %s", name, by.getLocator(), value), getText() == value);
        return this;
    }

    public String getName() {
        return name;
    }

    public By getBy() {
        return by;
    }
}

