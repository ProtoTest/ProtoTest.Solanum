package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.*;

// Screen Object for Device's MainScreen ViewGroup

public class DeviceMain {
    private EggplantElement homeScreenIcon = new EggplantElement("homeScreenIcon", By.Image("AndroidPhone/GalaxyS5/System/Screens/homeScreenIcon"));
    private EggplantElement usbConnectedIcon = new EggplantElement("usbConnectedIcon", By.Image("AndroidPhone/GalaxyS5/System/Device/usbConnectedIcon"));
    private EggplantElement dishAnywhereApp = new EggplantElement("Anywhere App", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/DishAnywhereAppIcon"));

    public final DeviceNavigation nav = new DeviceNavigation();

    public DeviceMain VerifyElements() {
        Logger.info("Verifying main device screen elements...");
        homeScreenIcon.waitForPresent();
        usbConnectedIcon.waitForPresent();
        return this;
    }

    public DeviceMain goHome() {
        Logger.info("Returning to main device screen...");

        nav.backButton.click();
        EggplantTestBase.sleep(500);
        if (nav.backButton.isPresent()) {
            nav.backButton.click();
        }
        // If the movie player was open, switching from horizontal to vertical screen causes detection errors.
        if (!nav.homeButton.isPresent()) {
            EggplantTestBase.driver.disconnect();
            EggplantTestBase.driver.connect();
        }
        nav.homeButton.click();
        return new DeviceMain();
    }

    public DishAnywhereHome openDishAnywhereHome() {
        dishAnywhereApp.waitForPresent(10);
        dishAnywhereApp.click();
        DishAnywherePopups popups = new DishAnywherePopups();
        popups.waitForScreenToLoad();
        DishAnywhereHome dishAnywhereHome = new DishAnywhereHome();

        dishAnywhereHome.loginIfLoggedOut();
        dishAnywhereHome.exitPlayerIfOpen();
        dishAnywhereHome.openGuide();
        return dishAnywhereHome;
    }
}
