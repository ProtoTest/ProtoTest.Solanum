package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.*;

// Screen Object for Device's MainScreen ViewGroup

public class DeviceMain {
    private EggplantElement homeScreenIcon = new EggplantElement("homeScreenIcon", By.Image("/AndroidPhone/GalaxyS5/System/Screens/homeScreenIcon"));
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
        DishAnywhereHome dishAnywhereHome = new DishAnywhereHome();

        dishAnywhereHome.loginIfLoggedOut();
        dishAnywhereHome.openGuide();
        return dishAnywhereHome;
    }
}
