package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.*;

public class DishAnywhereHome extends DishAnywhereMain {
    private EggplantElement settingsButton = new EggplantElement("Settings", By.Text("Settings", SearchRectangle.bottomHalf().trimTop(75)));
    private EggplantElement guideButton = new EggplantElement("Guide", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/AppNav/Guide"));
    private EggplantElement onDemandButton = new EggplantElement("OnDemand", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/AppNav/OnDemand", SearchRectangle.bottomHalf()));
    private EggplantElement okButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/OkButton"));

    public DishAnywhereHome closePopups() {
        Logger.info("Closing popups...");
        if (okButton.isPresent()) {
            okButton.click();
        }
        return this;
    }

    public DishAnywhereHome() {
    }

    public DishAnywhereHome openDishAnywhereHome() {
        //dishAnywhereHome.loginIfLoggedOut();
        exitPlayerIfOpen();
        //EggplantTestBase.sleep(5000);
        openGuide();
        return this;
    }

    public DishAnywhereLogin logOutIfLoggedIn(){
        if(loggedIn()){
            return openSettings().openSettingsRoot().logout();
        }
        return new DishAnywhereLogin();
    }

    private boolean loggedIn() {
        if(settingsButton.isPresent())
            return true;
        return settingsButton.isPresent(10);
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

//    public Blockbuster openBlockbuster(){
//        blockbusterButton.click();
//        return new Blockbuster();
//    }
    public DishAnywhereHome verifyLoggedIn() {
        Logger.info("Verifying 'logged in' status...");
        settingsButton.waitForPresent(20);
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

    public DishAnywhereHome exitPlayerIfOpen() {
        Logger.info("Exiting player, if open...");
        for (int i = 0; i < 10 && ! settingsButton.isPresent(); i++) {
            nav.backButton.click();
        }
        return this;
    }

}
