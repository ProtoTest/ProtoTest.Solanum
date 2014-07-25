package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.*;

public class DeviceMain {
    private EggplantElement homeScreenIcon = new EggplantElement("homeScreenIcon", By.Image("AndroidPhone/GalaxyS5/System/Screens/homeScreenIcon"));
    private EggplantElement usbConnectedIcon = new EggplantElement("usbConnectedIcon", By.Image("AndroidPhone/GalaxyS5/System/Device/usbConnectedIcon"));
    private EggplantElement dishAnywhereApp = new EggplantElement("Anywhere App", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/DishAnywhereAppIcon"));

    public final DeviceNavigation nav = new DeviceNavigation();
    private EggplantElement okButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/OkButton", SearchRectangle.bottomHalf()));

    public boolean isOnHome() {
        return dishAnywhereApp.isPresent();
    }

    public DeviceMain VerifyElements() {
        Logger.info("Verifying main device screen elements...");
        homeScreenIcon.waitForPresent();
        usbConnectedIcon.waitForPresent();
        return this;
    }

    public DeviceMain goHome() {
        Logger.info("Returning to main device screen...");
        if (nav.homeButton.isPresent()) {
            nav.homeButton.click();
            if(dishAnywhereApp.isPresent()){
                return this;
            }
        }
        for (int i=0;i<5&&!dishAnywhereApp.isPresent();i++) {
            nav.backButton.click();
        }
        if (!nav.homeButton.isPresent()) {
            EggplantTestBase.driver.disconnect();
            EggplantTestBase.driver.connect();
        }
        nav.homeButton.click();
        return new DeviceMain();
    }

    public DishAnywhereHome openDishAnywhereApp() {
        Logger.info("Opening Dish Anywhere app...");
        dishAnywhereApp.click();
        DishAnywherePopups popups = new DishAnywherePopups();
        popups.waitForScreenToLoad();
        DishAnywhereHome dishAnywhereHome = new DishAnywhereHome();
        return dishAnywhereHome;
    }

    public DeviceMain closePopups() {
        Logger.info("Closing popups...");
        if (okButton.isPresent(5)) {
            if (Config.logLevel == 0)
            okButton.click();
        }
        return this;
    }
}
