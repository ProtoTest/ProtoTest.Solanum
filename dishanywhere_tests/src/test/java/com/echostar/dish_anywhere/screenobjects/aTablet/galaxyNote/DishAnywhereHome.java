package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SearchRectangle;

public class DishAnywhereHome extends DishAnywhereMain {
    public EggplantElement settingsButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/AppNav/Settings"));
    public EggplantElement guideButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/AppNav/Guide"));

    public EggplantElement onDemandButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/AppNav/OnDemand"));

    public EggplantElement blockbusterButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/AppNav/BlockBuster"));
    public EggplantElement viewAllButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/ViewAllButton", SearchRectangle.bottomHalf()));


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
        return settingsButton.isPresent(15);
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
        viewAllButton.waitForPresent(20);
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
        goToHomeScreen();
        return this;
    }
}
