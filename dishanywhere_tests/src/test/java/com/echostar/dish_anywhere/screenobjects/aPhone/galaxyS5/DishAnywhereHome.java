package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SearchRectangle;

/**
 *
 */
public class DishAnywhereHome extends DeviceMain {
    private EggplantElement settingsButton = new EggplantElement("Settings", By.Text("Settings", SearchRectangle.bottomHalf().trimTop(30)));
    private EggplantElement guideButton = new EggplantElement("Guide", By.Text("Guide", SearchRectangle.bottomHalf().trimTop(60).trimRight(50)));

    public DishAnywhereHome() {
    }

    public void loginIfLoggedOut() {
        new DishAnywhereLogin().loginIfLoggedOut();
    }

    public DishAnywhereSettings openSettings() {
        Logger.info("Opening Settings panel.");
        settingsButton.click();
        return new DishAnywhereSettings();
    }

    public DishAnywhereHome openGuide() {
        guideButton.click();
        return this;
    }

    public DishAnywhereHome verifyLoggedIn() {
        guideButton.waitForPresent(10);
        return this;
    }

    public DeviceMain returnToDeviceMain(){
        goHome();
        return this;
    }
}
