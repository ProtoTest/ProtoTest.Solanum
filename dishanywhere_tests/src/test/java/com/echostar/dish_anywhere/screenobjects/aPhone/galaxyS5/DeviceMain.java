package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.*;
import com.prototest.solanum.*;

// Screen Object for Device's MainScreen ViewGroup

public class DeviceMain {
    private EggplantElement homeScreenIcon = new EggplantElement("homeScreenIcon", By.Image("/AndroidPhone/GalaxyS5/System/Screens/homeScreenIcon"));
    private EggplantElement CloseKeyboardButton = new EggplantElement("closeKeyboardButton", By.Image("/AndroidPhone/GalaxyS5/System/Device/closeKeyboardButton"));
    private EggplantElement KeyboardDeleteKey = new EggplantElement("keyboardDeleteKey", By.Image("/AndroidPhone/GalaxyS5/System/Keyboard/DeleteKey"));
    private EggplantElement usbConnectedIcon = new EggplantElement("usbConnectedIcon", By.Image("/AndroidPhone/GalaxyS5/System/Device/usbConnectedIcon"));
    private EggplantElement dishAnywhereApp = new EggplantElement("Anywhere App", By.Text("Anywhere", SearchRectangle.bottomHalf()));

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
        DishAnywherePopups popups = new DishAnywherePopups();
        popups.waitForScreenToLoad();
        DishAnywhereHome dishAnywhereHome = new DishAnywhereHome();
        dishAnywhereHome.loginIfLoggedOut();
        dishAnywhereHome.openGuide();
        return dishAnywhereHome;
    }
}
