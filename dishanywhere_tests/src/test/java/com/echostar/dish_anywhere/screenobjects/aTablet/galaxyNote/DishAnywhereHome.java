package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SearchRectangle;

/**
 *
 */
public class DishAnywhereHome extends DeviceMain {
    private EggplantElement settingsButton = new EggplantElement(By.Text("Settings", SearchRectangle.bottomHalf()));
    private EggplantElement guideButton = new EggplantElement(By.Text("Guide", SearchRectangle.bottomHalf()));

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
        guideButton.verifyPresent();
        return this;
    }

    public DeviceMain returnToDeviceMain(){
        goHome();
        return this;
    }
}
