package com.prototest.solanum;

import org.joda.time.LocalTime;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class EggplantElement {
    private By by;
    private String name;
    private EggplantDriver driver = EggplantTestBase.driver;
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
        driver.doubleTap(by.getLocator());
        return this;
    }

    public EggplantElement press() {
        waitForPresent();
        Logger.message(String.format("Performing click+hold on %s %s.", name, by.getLocator()));
        driver.press(by.getLocator());
        return this;
    }

    public EggplantElement release() {
        waitForPresent();
        Logger.message(String.format("Performing release on %s %s.", name, by.getLocator()));
        driver.release(by.getLocator());
        return this;
    }


    public EggplantElement tap() {
        waitForPresent();
        Logger.message(String.format("Tap on %s %s.", name, by.getLocator()));
        driver.tap(by.getLocator());
        return this;
    }

    public EggplantElement doubleTap() {
        waitForPresent();
        Logger.message(String.format("DoubleTap on %s %s.", name, by.getLocator()));
        driver.doubleTap(by.getLocator());
        return this;
    }

    public EggplantElement type(String text) {
        click();
        Logger.message(String.format("Typing text:(%s).", text));
        driver.typeText(text);
        return this;
    }

    public EggplantElement dragTo(EggplantElement element){
        waitForPresent();
        Logger.message(String.format("Dragging %s to %s.", name, by.getLocator()));
        driver.drag(by.getLocator());
        driver.drop(element.getBy().getLocator());
        return this;
    }

    public EggplantElement swipeUp(){
        waitForPresent();
        Logger.message(String.format("SwipingUp %s %s.", name, by.getLocator()));
        driver.swipeUp(by.getLocator());
        return this;
    }

    public EggplantElement swipeDown(){
        waitForPresent();
        Logger.message(String.format("SwipingDown %s %s.", name, by.getLocator()));
        driver.swipeDown(by.getLocator());
        return this;
    }
    public EggplantElement swipeLeft(){
        waitForPresent();
        Logger.message(String.format("SwipingLeft %s %s.", name, by.getLocator()));
        driver.swipeLeft(by.getLocator());
        return this;
    }
    public EggplantElement swipeRight(){
        waitForPresent();
        Logger.message(String.format("SwipingRight %s %s.", name, by.getLocator()));
        driver.swipeRight(by.getLocator());
        return this;
    }
    // Hard verification failures - Test will halt
    public EggplantElement waitForPresent() {
        return waitForPresent(this.waitSec);
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
        Logger.error(String.format("%s not found: %s.", name, by.getLocator()));
        throw new RuntimeException(String.format("%s was not present after %d seconds", name, secs));
    }

    private void logSourceImage() {
        throw new NotImplementedException();
    }

    public EggplantElement waitForNotPresent() {
        return waitForNotPresent(this.waitSec);
    }

    public EggplantElement waitForNotPresent(int secs) {
        Logger.message(String.format("Waiting for %s %s to not be present for %s seconds.", name, by.getLocator(),secs));
        LocalTime now = new LocalTime();
        LocalTime endTime = now.plusSeconds(secs);
        while (now.isBefore(endTime) && !Thread.interrupted()) {
            if (!driver.isPresent(by.getLocator())) {
                Logger.message("Element no longer present.");
                return this;
            } else {
                now = new LocalTime();
            }
        }

        Logger.error(String.format("%s is still present",name, by));
        //logSourceImage();
        throw new RuntimeException(String.format("WaitForNotPresent Failed : %s was still present after %d seconds", name, secs));
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

    public EggplantElement verifyText(String value){
        waitForPresent();
        Logger.message(String.format("Verifying %s %s text is %s.", name, by.getLocator(),value));
        Verifications.addVerification(String.format("%s %s should have text %s", name, by.getLocator(),value), getText()==value);
        return this;
    }

    public String getName() {
        return name;
    }

    public By getBy() {
        return by;
    }
}

