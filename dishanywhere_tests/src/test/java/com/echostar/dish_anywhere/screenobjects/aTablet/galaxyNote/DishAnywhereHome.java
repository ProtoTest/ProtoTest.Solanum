package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.*;

public class DishAnywhereHome extends DishAnywhereMain {
    public EggplantElement settingsButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/AppNav/Settings"));
    public EggplantElement guideButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/AppNav/Guide"));

    public EggplantElement onDemandButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/AppNav/OnDemand"));

    public EggplantElement blockbusterButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/AppNav/BlockBuster"));
    public EggplantElement viewAllButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/ViewAllButton", SearchRectangle.Quadrants.BOTTOM_HALF));


    public DishAnywhereHome() {
    }

    public DishAnywhereLogin logOutIfLoggedIn(){
        Logger.info("Determining user 'logged in' state...");
        if(loggedIn()){
            Logger.info("User is already logged in.  Logging out...");
            return openSettings().logout();
        }
        Logger.info("User is already logged out.");
         return new DishAnywhereLogin();
    }

    private boolean loggedIn() {
        if(settingsButton.isPresent())
            return true;
        return settingsButton.isPresent(15);
    }

    public DishAnywhereSettings openSettings() {
        Logger.info("Opening Settings panel...");
        settingsButton.click();
        return new DishAnywhereSettings();
    }

    public DishAnywhereHome openGuide() {
        guideButton.click();
        return this;
    }

    public DishAnywhereOnDemand openOnDemand(){
        onDemandButton.click();
        viewAllButton.waitForPresent();
        viewAllButton.click();
        return new DishAnywhereOnDemand();
    }
    public Blockbuster openBlockbuster(){
        blockbusterButton.click();
        return new Blockbuster();
    }
    public DishAnywhereHome verifyLoggedIn() {
        Logger.info("Verifying user is logged in...");
        settingsButton.waitForPresent();
        return this;
    }

}
