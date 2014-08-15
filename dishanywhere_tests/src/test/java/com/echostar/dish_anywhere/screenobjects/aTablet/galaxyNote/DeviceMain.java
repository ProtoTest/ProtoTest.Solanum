package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.*;

// Screen Object for Device's MainScreen ViewGroup

public class DeviceMain {
    protected EggplantElement homeScreenIcon = new EggplantElement("homeScreenIcon", By.Image("AndroidTablet/GalaxyNote/System/Screens/homeScreenIcon"));
    protected EggplantElement closeKeyboardButton = new EggplantElement("closeKeyboardButton", By.Image("AndroidTablet/GalaxyNote/System/Device/closeKeyboardButton"));
    protected EggplantElement keyboardDeleteKey = new EggplantElement("keyboardDeleteKey", By.Image("AndroidTablet/GalaxyNote/System/Keyboard/DeleteKey"));
    protected EggplantElement usbConnectedIcon = new EggplantElement("usbConnectedIcon", By.Image("AndroidTablet/GalaxyNote/System/Device/usbConnectedIcon"));
    protected EggplantElement dishAnywhereApp = new EggplantElement("Anywhere App", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/DishAnywhereAppIcon"));
    protected EggplantElement dishAnywhereTaskIcon = new EggplantElement("Anywhere Task Icon", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/TaskIcon",SearchRectangle.Quadrants.LEFT_QUARTER));
    protected EggplantElement removeFromListButton = new EggplantElement("Remove from list button", By.Image("AndroidTablet/GalaxyNote/System/Device/RemoveFromList", SearchRectangle.Quadrants.LEFT_QUARTER));

    public final DeviceNavigation nav = new DeviceNavigation();

    public DeviceMain VerifyElements() {
        Logger.info("Verifying main device screen elements...");
        homeScreenIcon.waitForPresent();
        usbConnectedIcon.waitForPresent();
        return this;
    }

    public DeviceMain goToHomeScreen() {
        Logger.info("Returning to device home screen...");
        EggplantTestBase.driver.PressBackButton();
        EggplantTestBase.sleep(1000);
        EggplantTestBase.driver.PressBackButton();
        EggplantTestBase.sleep(1000);
        EggplantTestBase.driver.PressBackButton();
        EggplantTestBase.sleep(1000);
        EggplantTestBase.driver.PressHomeButton();
        return this;
    }

    public DeviceMain confirmHomeScreen() {
        dishAnywhereApp.waitForPresent();
        return this;
    }

    public DeviceMain killApp() {
        EggplantTestBase.driver.PressHomeButton();
        nav.taskManagerButton.click();
        dishAnywhereTaskIcon.swipeRight();
       return this;
    }

    public DishAnywhereHome goHome() {
        Logger.info("Returning to device home screen and launching app...");
        EggplantTestBase.driver.PressHomeButton();
        dishAnywhereApp.click();
//        for (int i=0;i<10&&!dishAnywhereApp.isPresent();i++) {
//            EggplantTestBase.driver.PressBackButton();
//        }
//        for (int i=0;i<5&&dishAnywhereApp.isPresent();i++) {
//            dishAnywhereApp.click();
//        }
        return new DishAnywhereHome();
    }
    public DeviceMain clearField(){
        Logger.info("Clearing form field...");
        keyboardDeleteKey.press();
        EggplantTestBase.sleep(2500);
        keyboardDeleteKey.release();
        return new DeviceMain();
    }
}
