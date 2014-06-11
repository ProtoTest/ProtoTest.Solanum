package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.*;

import java.awt.*;

// Screen Object for Device's MainScreen ViewGroup

public class DeviceMain {
    protected EggplantElement homeScreenIcon = new EggplantElement("homeScreenIcon", By.Image("KindleTablet/KindleFireHDX/System/Screens/homeScreenIcon"));
    protected EggplantElement closeKeyboardButton = new EggplantElement("closeKeyboardButton", By.Image("KindleTablet/KindleFireHDX/System/Device/closeKeyboardButton"));
    protected EggplantElement keyboardDeleteKey = new EggplantElement("keyboardDeleteKey", By.Image("KindleTablet/KindleFireHDX/System/Keyboard/DeleteKey"));
    protected EggplantElement usbConnectedIcon = new EggplantElement("usbConnectedIcon", By.Image("KindleTablet/KindleFireHDX/System/Device/usbConnectedIcon"));
    protected EggplantElement dishAnywhereApp = new EggplantElement("Anywhere App", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/DishAnywhereAppIcon"));
    protected EggplantElement dishAnywhereTaskIcon = new EggplantElement("Anywhere Task Icon", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/TaskIcon",SearchRectangle.leftQuarter()));
    protected EggplantElement removeFromListButton = new EggplantElement("Remove from list button", By.Image("KindleTablet/KindleFireHDX/System/Device/RemoveFromList", SearchRectangle.leftQuarter()));

    public final DeviceNavigation nav = new DeviceNavigation();

    public DeviceMain VerifyElements() {
        Logger.info("Verifying main device screen elements...");
        homeScreenIcon.waitForPresent();
        usbConnectedIcon.waitForPresent();
        return this;
    }

    public DeviceMain goHome() {
        Logger.info("Returning to main device screen...");
        nav.homeButton.waitForPresent(20).click();
        return new DeviceMain();
    }

    public DeviceMain killApp(){
        nav.homeButton.click();
        EggplantTestBase.driver.swipeDown(new Point(EggplantTestBase.driver.getScreenSize().x/2,0));
        nav.settingsButton.waitForPresent(30).click();
        new KindleSettings().stopApplication("Anywhere");
        nav.homeButton.click();
        return new DeviceMain();
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
