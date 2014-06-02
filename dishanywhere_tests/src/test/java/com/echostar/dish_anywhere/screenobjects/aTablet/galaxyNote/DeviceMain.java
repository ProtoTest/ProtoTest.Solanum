package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.*;

// Screen Object for Device's MainScreen ViewGroup

public class DeviceMain {
    protected EggplantElement homeScreenIcon = new EggplantElement("homeScreenIcon", By.Image("AndroidTablet/GalaxyNote/System/Screens/homeScreenIcon"));
    protected EggplantElement closeKeyboardButton = new EggplantElement("closeKeyboardButton", By.Image("AndroidTablet/GalaxyNote/System/Device/closeKeyboardButton"));
    protected EggplantElement keyboardDeleteKey = new EggplantElement("keyboardDeleteKey", By.Image("AndroidTablet/GalaxyNote/System/Keyboard/DeleteKey"));
    protected EggplantElement usbConnectedIcon = new EggplantElement("usbConnectedIcon", By.Image("AndroidTablet/GalaxyNote/System/Device/usbConnectedIcon"));
    protected EggplantElement dishAnywhereApp = new EggplantElement("Anywhere App", By.Image("AndroidTablet/GalaxyNote/System/Apps/DishAnywhereIcon"));

    public final DeviceNavigation nav = new DeviceNavigation();

    public DeviceMain VerifyElements() {
        Logger.info("Verifying main device screen elements...");
        homeScreenIcon.waitForPresent();
        usbConnectedIcon.waitForPresent();
        return this;
    }

    public DeviceMain goHome() {
        Logger.info("Returning to main device screen...");
        nav.homeButton.click();
        return new DeviceMain();
    }

    public DishAnywhereHome openDishAnywhereHome() {
        dishAnywhereApp.click();
        DishAnywherePopups dishAnywherePopups = new DishAnywherePopups();
        dishAnywherePopups.waitForScreenToLoad();
        DishAnywhereHome dishAnywhereHome = new DishAnywhereHome();
                dishAnywhereHome.loginIfLoggedOut();
        dishAnywhereHome.openGuide();
        return dishAnywhereHome;
    }

    public DeviceMain clearField(){
        Logger.info("Clearing form field...");
        keyboardDeleteKey.press();
        EggplantTestBase.sleep(2500);
        keyboardDeleteKey.release();
        return new DeviceMain();
    }
}
