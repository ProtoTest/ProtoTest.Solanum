package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SearchRectangle;

/**
 *
 */
public class DishAnywhereHome extends DeviceMain {
    private EggplantElement settingsButton = new EggplantElement(By.Text("Settings", SearchRectangle.bottomQuarter()));
    private EggplantElement guideButton = new EggplantElement(By.Text("Guide", SearchRectangle.bottomQuarter()));
    private EggplantElement onDemandButton = new EggplantElement(By.Text("On Demand", SearchRectangle.bottomQuarter()));
    private EggplantElement blockbusterButton = new EggplantElement(By.Text("BlockBuster", SearchRectangle.bottomQuarter()));


    public DishAnywhereHome() {
    }

    public DishAnywhereLogin logOutIfLoggedIn(){
        if(loggedIn()){
           return openSettings().logout();
        }
        return new DishAnywhereLogin();
    }

    private boolean loggedIn() {
        if(settingsButton.isPresent())
            return true;
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
        settingsButton.waitForPresent(20);
        return this;
    }

    public DeviceMain returnToDeviceMain(){
        goHome();
        return this;
    }
}
