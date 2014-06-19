package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.*;

// Screen Object for Device's MainScreen ViewGroup

public class DeviceMain {
    protected EggplantElement homeScreenIcon = new EggplantElement("homeScreenIcon", By.Image("AndroidTablet/GalaxyNote/System/Screens/homeScreenIcon"));
    protected EggplantElement closeKeyboardButton = new EggplantElement("closeKeyboardButton", By.Image("AndroidTablet/GalaxyNote/System/Device/closeKeyboardButton"));
    protected EggplantElement keyboardDeleteKey = new EggplantElement("keyboardDeleteKey", By.Image("AndroidTablet/GalaxyNote/System/Keyboard/DeleteKey"));
    protected EggplantElement usbConnectedIcon = new EggplantElement("usbConnectedIcon", By.Image("AndroidTablet/GalaxyNote/System/Device/usbConnectedIcon"));
    protected EggplantElement dishAnywhereApp = new EggplantElement("Anywhere App", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/DishAnywhereAppIcon"));
    protected EggplantElement dishAnywhereTaskIcon = new EggplantElement("Anywhere Task Icon", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/TaskIcon",SearchRectangle.leftQuarter()));
    protected EggplantElement removeFromListButton = new EggplantElement("Remove from list button", By.Image("AndroidTablet/GalaxyNote/System/Device/RemoveFromList", SearchRectangle.leftQuarter()));

    public final DeviceNavigation nav = new DeviceNavigation();

    public DeviceMain VerifyElements() {
        Logger.info("Verifying main device screen elements...");
        homeScreenIcon.waitForPresent();
        usbConnectedIcon.waitForPresent();
        return this;
    }

    public DeviceMain goHome() {
        Logger.info("Returning to main device screen...");
        if (closeKeyboardButton.isPresent()) {
            closeKeyboardButton.tap();
        }
        while (!dishAnywhereApp.isPresent()) {
            nav.backButton.tap();
        }
        //nav.homeButton.waitForPresent(20).click();
        return new DeviceMain();
    }

    public DeviceMain killApp(){
        nav.taskManagerButton.click();
        if(dishAnywhereTaskIcon.isPresent())
            dishAnywhereTaskIcon.swipeRight();
       return goHome();
    }

    public DishAnywhereHome openDishAnywhereHome() {
        dishAnywhereApp.click();
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
