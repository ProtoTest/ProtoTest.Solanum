package com.prototest.solanum;

import org.joda.time.LocalTime;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.io.*;
import java.util.List;

/**
 * <p>EggplantElement encapsulates the methods of finding and interacting with screen elements in EggPlant.</p>
 *
 * <p>Use {@link By} to specify how the element should be located.</p>
 *
 * <p>For example:</p>
 *
 * <pre>
 *     // Locate and click on element by on-screen text:
 *     EggplantElement textElement = new EggplantElement(By.Text("Text on screen"));
 *     textElement.click(); // or .tap()
 *
 *     // Locate and click on element by on-screen image:
 *     EggplantElement imageElement = new EggplantElement(By.Image("path/to/image"));
 *     imageElement.click();
 *
 *     // Locate and click on element by raw pixel location:
 *     EggplantElement pointElement = new EggplantElement(By.Point(new {@link Point}(x, y));
 *     pointElement.click();
 * </pre>
 *
 * <p>EggplantElement caches the point location of the found on-screen element the first time it is interacted with.
 * This allows faster interaction with the element. Verification methods such as {@link #isPresent()} will always refer
 * to the original {@link By}.</p>
 *
 * <p>EggplantElement provides a set of verification methods.</p>
 *
 * <p>Hard verification methods throw a {@link RuntimeException} if the verification fails. They are:
 *
 * <ul>
 *     <li>{@link #waitForPresent()}</li>
 *     <li>{@link #waitForPresent(Integer)}</li>
 *     <li>{@link #waitForNotPresent()}</li>
 *     <li>{@link #waitForNotPresent(Integer)}</li>
 * </ul>
 *
 *
 * <p>Soft verifications are used for testing the existence of the element. They are:
 * <ul>
 *     <li>{@link #isPresent()}</li>
 *     <li>{@link #isPresent(int)}</li> <li>{@link #verifyPresent()} -- also adds a test verification; {@link Verifications}</li>
 * <li>{@link #verifyNotPresent()} -- also adds a test verification; {@link Verifications}</li>
 * <li>{@link #verifyText(String)} -- also adds a test verification; {@link Verifications}</li></ul>
 */
public class EggplantElement {
    private By by;
    private String name;
    private EggplantDriver driver = EggplantTestBase.driver;
    private int waitSec;

    /**
     * @param name The name of this element used in logs.
     * @param by   {@link By} locator.
     */
    public EggplantElement(String name, By by) {
        this.by = by;
        this.name = name;
        this.waitSec = Config.elementWaitTimeSec;
    }

    /**
     * @param name    The name of this element used in logs.
     * @param by      {@link By} locator.
     * @param waitSec The amount of time to wait when calling {@link #waitForPresent()}.
     */
    public EggplantElement(String name, By by, int waitSec) {
        this.by = by;
        this.name = name;
        this.waitSec = waitSec;
    }

    /**
     * @param by {@link By} locator.
     */
    public EggplantElement(By by) {
        this.by = by;
        this.name = by.getLocator();
        this.waitSec = Config.elementWaitTimeSec;
    }

    /**
     * @param by      {@link By} locator.
     * @param waitSec The amount of time to wait when calling {@link #waitForPresent()}.
     */
    public EggplantElement(By by, int waitSec) {
        this.by = by;
        this.name = by.getLocator();
        this.waitSec = waitSec;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
        }
    }

    private Point getLocation() {
        return driver.findLocation(by);
    }

    /**
     * Determines whether the element is present on the device screen.
     *
     * @return True if the element is present, otherwise false.
     */
    public boolean isPresent() {
        if (by.type.equals(By.ByType.point)) return true;
        return driver.isPresent(by.getLocator());
    }

    /**
     * Determines whether the element is present on the device screen.
     *
     * @param secs Max number of seconds to wait.
     * @return True if the element is present, otherwise false.
     */
    public boolean isPresent(int secs) {
        if (by.type.equals(By.ByType.point)) return true;
        return driver.isPresent(by.getLocator(),secs);
    }

    /**
     * Get text on screen at the element's location.
     *
     * @return Text at the location.
     */
    public String getText() {

        waitForPresent();
        Logger.debug(String.format("Reading text on %s %s.", name, by.getLocator()));
        if(by.type== By.ByType.point){
            return driver.readText(by.getLocator());
        }
        else{
            return driver.readText("FoundImageLocation()");
        }

    }

    /**
     * Click the screen at the location of the element. For mobile devices this is the same as {@link #tap()}.
     *
     * @return This {@link EggplantElement}.
     */
    public EggplantElement click() {
        waitForPresent();
        Logger.debug(String.format("Clicking on %s %s.", name, by.getLocator()));
        if(by.type== By.ByType.point){
            driver.click(by.getLocator());
        }
        else{
            driver.click("FoundImageLocation()");
        }
        return this;
    }

    /**
     * Double click the screen at the location of the element.
     *
     * @return This {@link EggplantElement}.
     */
    public EggplantElement doubleClick() {
        waitForPresent();
        Logger.debug(String.format("Double-clicking on %s %s.", name, by.getLocator()));
        if(by.type== By.ByType.point){
            driver.doubleTap(by.getLocator());
        }
        else{
            driver.doubleTap("FoundImageLocation()");
        }

        return this;
    }

    /**
     * Press and hold at the location of the element. Call {@link #release()} to release.
     *
     * @return This {@link EggplantElement}.
     */
    public EggplantElement press() {
        waitForPresent();
        Logger.debug(String.format("Performing click+hold on %s %s.", name, by.getLocator()));
        if(by.type== By.ByType.point){
            driver.press(by.getLocator());
        }
        else{
            driver.press("FoundImageLocation()");
        }
        return this;
    }

    /**
     * Release press and hold, if EggPlant is currently holding a press. Use {@link #press()} to initiate a press and
     * hold.
     *
     * @return This {@link EggplantElement}.
     */
    public EggplantElement release() {
        waitForPresent();
        Logger.debug(String.format("Performing release on %s %s.", name, by.getLocator()));
        if(by.type== By.ByType.point){
            driver.release(by.getLocator());
        }
        else{
            driver.release("FoundImageLocation()");
        }
        return this;
    }

    /**
     * Tap the screen at the location of this element.
     *
     * @return This {@link EggplantElement}.
     */
    public EggplantElement tap() {
        waitForPresent();
        Logger.debug(String.format("Tap on %s %s.", name, by.getLocator()));
        if(by.type== By.ByType.point){
            driver.tap(by.getLocator());
        }
        else{
            driver.tap("FoundImageLocation()");
        }
        return this;
    }

    /**
     * Tap the screen at the location of this element.
     *
     * @return This {@link EggplantElement}.
     */
    public EggplantElement doubleTap() {
        waitForPresent();
        Logger.debug(String.format("DoubleTap on %s %s.", name, by.getLocator()));
        if(by.type== By.ByType.point){
            driver.doubleTap(by.getLocator());
        }
        else{
            driver.doubleTap("FoundImageLocation()");
        }
        return this;
    }

    /**
     * Tap the screen at the location of this element.
     *
     * @return This {@link EggplantElement}.
     */
    public EggplantElement type(String text) {
        click();
        Logger.info(String.format("Typing text: (%s).", text));
        driver.typeText(text);
        // Eggplant returns immediately from the TypeText command instead of waiting for the text to type.
        // Compensate by sleeping about 1 second per 3 keys typed.
        EggplantTestBase.sleep(text.length() / 3 * 1000);
        return this;
    }

    /**
     * Tap the screen at the location of this element.
     *
     * @return This {@link EggplantElement}.
     */
    public EggplantElement setText(String text) {
        click();
        clearText();
        type(text);
        return this;
    }

    /**
     * Tap the screen at the location of this element.
     *
     * @return This {@link EggplantElement}.
     */
    public EggplantElement clearText(){
        press();
        sendKeys(EggplantKeys.backspace);
        return this;
    }

    /**
     * Tap the screen at the location of this element.
     *
     * @return This {@link EggplantElement}.
     */
    public EggplantElement dragTo(EggplantElement element) {
        waitForPresent();
        Logger.debug(String.format("Dragging %s to %s.", name, by.getLocator()));
        if(by.type== By.ByType.point){
            driver.drag(this.by.getLocator());
            driver.drop(element.getBy().getLocator());
        }
        else{
            driver.drag("FoundImageLocation()");
            driver.drop(element.getBy().getLocator());
        }

        return this;
    }

    /**
     * Tap the screen at the location of this element.
     *
     * @return This {@link EggplantElement}.
     */
    public EggplantElement swipeUp() {
        waitForPresent();
        Logger.debug(String.format("SwipingUp %s %s.", name, by.getLocator()));
        if(by.type== By.ByType.point){
            driver.swipeUp(this.by.getLocator());
        }
        else{
            driver.swipeUp("FoundImageLocation()");
        }
        return this;
    }

    /**
     * Tap the screen at the location of this element.
     *
     * @return This {@link EggplantElement}.
     */
    public EggplantElement swipeDown() {
        waitForPresent();
        Logger.debug(String.format("SwipingDown %s %s.", name, by.getLocator()));
        if(by.type== By.ByType.point){
            driver.swipeDown(this.by.getLocator());
        }
        else{
            driver.swipeDown("FoundImageLocation()");
        }
        return this;
    }

    /**
     * Tap the screen at the location of this element.
     *
     * @return This {@link EggplantElement}.
     */
    public EggplantElement swipeLeft() {
        waitForPresent();
        Logger.debug(String.format("SwipingLeft %s %s.", name, by.getLocator()));
        if(by.type== By.ByType.point){
            driver.swipeLeft(this.by.getLocator());
        }
        else{
            driver.swipeLeft("FoundImageLocation()");
        }
        return this;
    }

    /**
     * Tap the screen at the location of this element.
     *
     * @return This {@link EggplantElement}.
     */
    public EggplantElement swipeRight() {
        waitForPresent();
        Logger.debug(String.format("SwipingRight %s %s.", name, by.getLocator()));
        if(by.type== By.ByType.point){
            driver.swipeRight(this.by.getLocator());
        }
        else{
            driver.swipeRight("FoundImageLocation()");
        }
        return this;
    }

    /**
     * Wait for the element to be detected. Polls EggPlant every half second. * If {@link
     * com.prototest.solanum.Config}.debugElementLocators is true, logs a screenshot.
     *
     * @return This {@link EggplantElement}.
     * @throws RuntimeException if the element is not present after the wait time.
     */
    // Hard verification failures - Test will halt
    public EggplantElement waitForPresent() {
        return waitForPresent(this.waitSec);
    }

    /**
     * Wait for the element to be detected. Polls EggPlant every half second. If {@link
     * com.prototest.solanum.Config}.debugElementLocators is true, logs a screenshot.
     *
     * @param secs Max number of seconds to wait.
     * @return This EggplantElement.
     * @throws RuntimeException if the element is not present after the wait time.
     */
    public EggplantElement waitForPresent(Integer secs) {
        Logger.debug(String.format("Waiting for %s to be present within %d seconds.", by.getLocator(), secs));
        LocalTime now = new LocalTime();
        LocalTime endTime = now.plusSeconds(secs);
        while (now.isBefore(endTime) && !Thread.interrupted()) {
            if (isPresent()) {
                return this;
            } else {
                driver.refreshScreen();
                now = new LocalTime();
            }
        }

        if(Config.diagnoseFailedImages){
            Logger.warning(String.format("%s not found.  Opening EggPlant GUI to diagnose failure", name));

            EggplantGUIHook hook = new EggplantGUIHook(this.by);
            hook.runBatch();
            Logger.warning(String.format("Eggplant GUI has been closed.  Finishing Test", name));

            now = new LocalTime();
            endTime = now.plusSeconds(secs);
            while (now.isBefore(endTime) && !Thread.interrupted()) {
                if (isPresent()) {
                    return this;
                } else {
                    driver.refreshScreen();
                    now = new LocalTime();
                }
            }
        }

        Logger.error(String.format("%s not found: %s.", name, by.getLocator()));

        LogElementDiagnosticInfo();
        if (Config.screenshotOnError && !Config.debugElementLocators) {
            if (by.getSearchRectangle() == null) {
                Logger.screenshot();
            } else {
                Logger.screenshot(by.getSearchRectangle().searchRectangle);
            }
        }
            throw new RuntimeException(String.format("%s was not present after %d seconds", name, secs));
    }


    /**
     * Wait for the element to not be detected. Polls EggPlant every half second. If {@link
     * com.prototest.solanum.Config}.debugElementLocators is true, logs a screenshot.
     *
     * @return This {@link EggplantElement}.
     * @throws RuntimeException if the element is present after the wait time.
     */
    public EggplantElement waitForNotPresent() {
        return waitForNotPresent(this.waitSec);
    }

    /**
     * Wait for the element to not be detected. Polls EggPlant every half second. If {@link
     * com.prototest.solanum.Config}.debugElementLocators is true, logs a screenshot.
     *
     * @param secs Max number of seconds to wait.
     * @return This EggplantElement.
     * @throws RuntimeException if the element is present after the wait time.
     */
    public EggplantElement waitForNotPresent(Integer secs) {
        Logger.debug(String.format("Waiting for %s %s to not be present for %s seconds.", name, by.getLocator(), secs));
        if (Config.debugElementLocators) {
            if (by.getSearchRectangle() == null) {
                Logger.screenshot(getSafeName());
            } else {
                Logger.screenshot(getSafeName(), by.getSearchRectangle().searchRectangle);
            }
        }
        driver.setOption("ImageSearchCount", "1");
        LocalTime now = new LocalTime();
        LocalTime endTime = now.plusSeconds(secs);
        while (now.isBefore(endTime) && !Thread.interrupted()) {

            if (!isPresent()) {
                Logger.debug("Element no longer present.");
                driver.setOption("ImageSearchCount", Config.imageSearchCount);
                return this;
            } else {
                driver.refreshScreen();
                now = new LocalTime();
            }
        }
        driver.setOption("ImageSearchCount", Config.imageSearchCount);
        Logger.error(String.format("%s is still present", name, by));
        LogElementDiagnosticInfo();
        if (Config.screenshotOnError && !Config.debugElementLocators) {
            if (by.getSearchRectangle() == null) {
                Logger.screenshot(getSafeName());
            } else {
                Logger.screenshot(getSafeName(), by.getSearchRectangle().searchRectangle);
            }
        }
        throw new RuntimeException(String.format("WaitForNotPresent Failed : %s was still present after %d seconds", name, secs));
    }

    /**
     * Checks whether the element is present and adds a verification with {@link Verifications#addVerification(String, boolean)}.
     *
     * @return This {@link EggplantElement}.
     */
    // Soft verification failures - Test will keep progressing
    public EggplantElement verifyPresent() {
        Logger.debug(String.format("Verifying %s %s should be present.", name, by.getLocator()));
        Verifications.addVerification(String.format("%s %s should be present.", name, by.getLocator()), driver.isPresent(by.getLocator()));
        return this;
    }

    /**
     * Checks whether the element is not present and adds a verification with {@link Verifications#addVerification(String, boolean)}.
     *
     * @return This {@link EggplantElement}.
     */
    public EggplantElement verifyNotPresent() {
        Logger.debug(String.format("Verifying %s %s is not be present.", name, by));
        Verifications.addVerification(String.format("%s %s should be present.", name, by.getLocator()), !driver.isPresent(by.getLocator()));
        return this;
    }

    /**
     * Checks whether the element contains the text and adds a verification with {@link Verifications#addVerification(String, boolean)}.
     *
     * @return This {@link EggplantElement}.
     */
    public EggplantElement verifyText(String value) {
        waitForPresent();
        Logger.debug(String.format("Verifying %s %s text is %s.", name, by.getLocator(), value));
        Verifications.addVerification(String.format("%s %s should have text %s", name, by.getLocator(), value), getText().equals(value));
        return this;
    }

    /**
     * Return a filename-safe name for this element.
     *
     * @return The name with punctuation replaced by '-'.
     */
    public String getSafeName() {
        String newName = this.name.split(",")[0].replaceAll("[:()\"]", "").replaceAll("[ ,\"/\\:]", "-");
        return newName;
    }

    /**
     *
     *
     * @return This element's name.
     */
    public String getName() {
        return name;
    }

    /**
     *
     *
     * @return The by this element is located by. Can either be the original by or a point if the element has been interacted with.
     */
    public By getBy() {
        return by;
    }

    /**
     * Get all instances of this element currently on screen.
     *
     * @return A {@link List} of {@link EggplantElement}s found on screen.
     */
    public List<EggplantElement> allInstances() {
        waitForPresent();
        return driver.everyImageLocation(by.getLocator());
    }

    /**
     * Click on the element then type text.
     *
     */
    public void sendKeys(EggplantKeys... keys) {
        click();
        String keysPart = "";
        for (EggplantKeys key : keys) {
            keysPart += key.keyword + ",";
        }
        keysPart = keysPart.substring(0, keysPart.length() - 1);
        driver.sendKeys(keysPart);
    }

    private void LogElementDiagnosticInfo() {
        if (by.type == By.ByType.image) {
            File image = getBy().getImageFile();
            if (image.isDirectory()) {
                File[] files = image.listFiles();
                Logger.images(files);
            } else {
                Logger.image(image);
            }

        } else if (by.type == By.ByType.text) {
            Logger.warning(driver.getAllText());
        }
    }

    private void logSourceImage() {
        throw new NotImplementedException();
    }
}

