package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.*;
import sun.swing.SwingUtilities2;

public class DeviceMain {
    private EggplantElement homeScreenIcon = new EggplantElement("homeScreenIcon", By.Image("AndroidPhone/GalaxyS5/System/Screens/homeScreenIcon"));
    private EggplantElement usbConnectedIcon = new EggplantElement("usbConnectedIcon", By.Image("AndroidPhone/GalaxyS5/System/Device/usbConnectedIcon"));
    private EggplantElement dishAnywhereApp = new EggplantElement("Anywhere App", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/DishAnywhereAppIcon"));

    public final DeviceNavigation nav = new DeviceNavigation();
    private EggplantElement okButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/OkButton", SearchRectangle.Quadrants.BOTTOM_HALF));

    public boolean isOnHome() {
        return dishAnywhereApp.isPresent();
    }

    public DeviceMain VerifyElements() {
        Logger.info("Verifying main device screen elements...");
        homeScreenIcon.waitForPresent();
        usbConnectedIcon.waitForPresent();
        return this;
    }



    public DishAnywhereHome goHome() {
        EggplantTestBase.driver.PressHomeButton();
        dishAnywhereApp.click();
        for (int i=0;i<5&&!dishAnywhereApp.isPresent();i++) {
            EggplantTestBase.driver.PressBackButton();
        }
        dishAnywhereApp.click();
        return new DishAnywhereHome();
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
