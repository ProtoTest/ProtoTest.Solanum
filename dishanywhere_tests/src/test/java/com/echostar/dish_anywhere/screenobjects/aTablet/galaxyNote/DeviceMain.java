package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SearchRectangle;

// Screen Object for Device's MainScreen ViewGroup

public class DeviceMain {
    private EggplantElement homeScreenIcon = new EggplantElement("homeScreenIcon", By.Image("AndroidTablet/GalaxyNote/System/Screens/homeScreenIcon"));
    private EggplantElement usbConnectedIcon = new EggplantElement("usbConnectedIcon", By.Image("AndroidTablet/GalaxyNote/System/Device/usbConnectedIcon"));
    private EggplantElement dishAnywhereApp = new EggplantElement("Anywhere App", By.Image("AndroidTablet/GalaxyNote/System/Apps/DishAnywhereIcon"));

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

    public DeviceMain killApp(){
        
    }

    public DishAnywhereHome openDishAnywhereHome() {
        dishAnywhereApp.click();
        //DishAnywhereHome dishAnywhereHome = new DishAnywhereHome();
        //dishAnywhereHome.openGuide();
        return new DishAnywhereHome();
    }
}
