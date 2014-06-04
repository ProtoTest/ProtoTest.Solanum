package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SearchRectangle;

public class DishAnywhereHome extends DishAnywhereMain {
    private EggplantElement settingsButton = new EggplantElement(By.Text("Settings", SearchRectangle.bottomQuarter()));
    private EggplantElement guideButton = new EggplantElement(By.Text("Guide", SearchRectangle.bottomQuarter()));
    private EggplantElement onDemandButton = new EggplantElement(By.Text("On Demand", SearchRectangle.bottomQuarter()));
    private EggplantElement blockbusterButton = new EggplantElement(By.Text("BlockBuster", SearchRectangle.bottomQuarter()));
    private EggplantElement viewAllButton = new EggplantElement(By.Text("View All"));


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
        return settingsButton.isPresent(10);
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

    public DishAnywhereOnDemand openOnDemand(){
        onDemandButton.click();
        viewAllButton.click();
        return new DishAnywhereOnDemand();
    }
    public Blockbuster openBlockbuster(){
        blockbusterButton.click();
        return new Blockbuster();
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
