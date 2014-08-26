package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.*;

import java.awt.*;

// Screen Object for Device's MainScreen ViewGroup

public class DeviceMain {
    protected EggplantElement closeKeyboardButton = new EggplantElement("closeKeyboardButton", By.Image("KindleTablet/KindleFireHDX/System/Device/closeKeyboardButton"));
    protected EggplantElement keyboardDeleteKey = new EggplantElement("keyboardDeleteKey", By.Image("KindleTablet/KindleFireHDX/System/Keyboard/DeleteKey"));
    protected EggplantElement dishAnywhereApp = new EggplantElement("Anywhere App", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/DishAnywhereAppIcon"));
    protected EggplantElement appsTab = new EggplantElement("Kindle Apps Tab", By.Text("Apps", SearchRectangle.Quadrants.TOP_HALF));

    protected EggplantElement settingsButton = new EggplantElement("System settings button", By.Image("KindleTablet/KindleFireHDX/System/Menus/SettingsButton", SearchRectangle.Quadrants.TOP_HALF));
    protected EggplantElement applicationsButton = new EggplantElement("System settings device button", By.Image("KindleTablet/KindleFireHDX/System/Menus/Applications"));
    protected EggplantElement manageAllApplicationsButton = new EggplantElement("Manage all applications button", By.Image("KindleTablet/KindleFireHDX/System/Menus/ManageAllApplications"));
    protected EggplantElement dishThumbnail = new EggplantElement("Dish application thumbnail", By.Image("KindleTablet/KindleFireHDX/System/Menus/DishThumbnail"));
    protected EggplantElement forceStopButton = new EggplantElement("Application stop button", By.Image("KindleTablet/KindleFireHDX/System/Menus/ForceStop"));

    public final DeviceNavigation nav = new DeviceNavigation();

    public DishAnywhereHome goHome() {
        nav.homeButton.click();
        appsTab.click();
        dishAnywhereApp.click();
        return new DishAnywhereHome();
    }

    public DishAnywhereHome resetApp() {
        Logger.debug("Going home");
        nav.homeButton.click();
        Logger.debug("Killing app");
        killApp();
        nav.homeButton.click();
        Logger.debug("Opening app");
        appsTab.click();
        dishAnywhereApp.click();
        return new DishAnywhereHome();
    }

    public DeviceMain killApp() {
        Logger.info("Killing Dish Anywhere app");
        nav.homeButton.click();
        EggplantElement settingsOverlaySwipePoint = new EggplantElement(By.Point(new Point(EggplantTestBase.driver.getScreenSize().x / 2, 1)));

        settingsOverlaySwipePoint.swipeDown(ActionCondition.isPresent(settingsButton));
        settingsButton.click();
        new KindleSettings().stopApplication("Anywhere");
        EggplantTestBase.driver.PressHomeButton();
        return new DeviceMain();
    }

    public DeviceMain clearField() {
        Logger.info("Clearing form field...");
        keyboardDeleteKey.press();
        EggplantTestBase.sleep(2500);
        keyboardDeleteKey.release();
        return new DeviceMain();
    }
}
