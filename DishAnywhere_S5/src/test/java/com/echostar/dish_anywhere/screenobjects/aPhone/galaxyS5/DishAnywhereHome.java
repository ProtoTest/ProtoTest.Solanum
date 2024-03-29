package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.*;

public class DishAnywhereHome extends DishAnywhereMain {

    private EggplantElement settingsButton = new EggplantElement("Settings", By.Text("Settings", SearchRectangle.Quadrants.BOTTOM_QUARTER));
    private EggplantElement guideButton = new EggplantElement("Guide", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/AppNav/Guide"));
    public EggplantElement onDemandButton = new EggplantElement("OnDemand", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/AppNav/OnDemand", SearchRectangle.Quadrants.BOTTOM_HALF));
    private EggplantElement dishAnywhereApp = new EggplantElement("Anywhere App", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/DishAnywhereAppIcon"));


    public DishAnywhereHome() {
    }

    public DishAnywhereLogin logOutIfLoggedIn(){
        Logger.info("Determining user 'logged in' state...");
        if(loggedIn()){
            Logger.info("User is already logged in.  Logging out...");
            return openSettings().openSettingsRoot().logout();
        }
        Logger.info("User is already logged out.");
        return new DishAnywhereLogin();
    }

    private boolean loggedIn() {
        // Returns true if settings button is present (false if not)
        return settingsButton.isPresent();
    }

    public DishAnywhereSettings openSettings() {
        Logger.info("Opening Settings panel...");
        settingsButton.click();
        return new DishAnywhereSettings();
    }

    public DishAnywhereHome openGuide() {
        Logger.info("Opening Guide...");
        guideButton.click();
        return this;
    }

    public DishAnywhereHome verifyLoggedIn() {
        Logger.info("Verifying 'logged in' status...");
        settingsButton.waitForPresent();
        return this;
    }

    public DeviceMain returnToDeviceMain(){
        Logger.info("Returning to device main...");
        goHome();
        return this;
    }

    public DishAnywhereOnDemand openOnDemand() {
        Logger.info("Opening 'On Demand' panel...");
        onDemandButton.click();
        return new DishAnywhereOnDemand().goToOnDemandRoot();
    }
    public DeviceMain goBackToDeviceScreen() {
        Logger.info("Pressing back button until device is on home.");
        DeviceMain main = new DeviceMain();
        for (int i=0;i<5&&!dishAnywhereApp.isPresent();i++) {
            EggplantTestBase.driver.PressBackButton();
        }
        return new DeviceMain();
    }

    public DishAnywhereHome exitPlayerIfOpen() {
        Logger.info("Exiting player, if open...");
        for (int i = 0; i < 10 && ! settingsButton.isPresent(); i++) {
            nav.backButton.click();
        }
        return this;
    }

}
