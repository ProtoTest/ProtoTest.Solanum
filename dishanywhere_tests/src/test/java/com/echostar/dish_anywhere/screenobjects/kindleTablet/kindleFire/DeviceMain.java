package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.*;

import java.awt.*;

// Screen Object for Device's MainScreen ViewGroup

public class DeviceMain {
    protected EggplantElement closeKeyboardButton = new EggplantElement("closeKeyboardButton", By.Image("KindleTablet/KindleFireHDX/System/Device/closeKeyboardButton"));
    protected EggplantElement keyboardDeleteKey = new EggplantElement("keyboardDeleteKey", By.Image("KindleTablet/KindleFireHDX/System/Keyboard/DeleteKey"));
    protected EggplantElement dishAnywhereApp = new EggplantElement("Anywhere App", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/DishAnywhereAppIcon"));
    protected EggplantElement appsTab = new EggplantElement("Kindle Apps Tab", By.Text("Apps", SearchRectangle.topHalf()));

    public final DeviceNavigation nav = new DeviceNavigation();

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
        appsTab.click();
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
