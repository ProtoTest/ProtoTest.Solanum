package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SearchRectangle;


public class DishAnywhereHome extends DishAnywhereMain {
    private EggplantElement settingsButton = new EggplantElement("Settings", By.Text("Settings", SearchRectangle.bottomHalf().trimTop(75)));
    private EggplantElement guideButton = new EggplantElement("Guide", By.Text("Guide"));
    private EggplantElement onDemandButton = new EggplantElement("OnDemand", By.Text("On Demand", SearchRectangle.bottomHalf()));


    public DishAnywhereHome() {
    }

    public DishAnywhereHome openDishAnywhereHome() {
        //dishAnywhereHome.loginIfLoggedOut();
        exitPlayerIfOpen();
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
        Logger.info("Opening Settings panel.");
        settingsButton.click();
        return new DishAnywhereSettings();
    }

    public DishAnywhereHome openGuide() {
        guideButton.click();
        return this;
    }

//    public Blockbuster openBlockbuster(){
//        blockbusterButton.click();
//        return new Blockbuster();
//    }
    public DishAnywhereHome verifyLoggedIn() {
        settingsButton.waitForPresent(20);
        return this;
    }

    public DeviceMain returnToDeviceMain(){
        goHome();
        return this;
    }

    public DishAnywhereOnDemand openOnDemand() {
        onDemandButton.click();
        return new DishAnywhereOnDemand();
    }

    public DishAnywhereHome exitPlayerIfOpen() {
        for (int i = 0; i < 10 && ! settingsButton.isPresent(); i++) {
            nav.backButton.click();
        }
        return this;
    }
}
