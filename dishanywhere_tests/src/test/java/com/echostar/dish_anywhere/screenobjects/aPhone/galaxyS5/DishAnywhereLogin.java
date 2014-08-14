package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.*;
import org.testng.Assert;

import java.awt.*;

public class DishAnywhereLogin extends DishAnywhereMain {

    private EggplantElement onlineId = new EggplantElement(By.Text("Online ID", TextOption.hotSpot(new Point(75,109))));


    private EggplantElement passwordField = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Login/PasswordField"));
    private EggplantElement loginButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Login/LoginButton", ImageOption.tolerance("45")));

    public DishAnywhereHome login(String onlineId, String password) {
        Logger.info("Logging in...");
        popups.waitForScreenToLoad();
        this.onlineId.clearText();
        this.onlineId.type(onlineId);
        passwordField.clearText();
        passwordField.type(password);
        loginButton.click();
        DishAnywhereHome home = new DishAnywhereHome();
        if(!home.onDemandButton.isPresent(5000))
        {
            Assert.fail("Login not successful.");
        }
        Logger.info("Logged in.");
        return home;
    }

    public DishAnywhereLogin loginIfLoggedOut() {
        Logger.info("Scanning for app login state...");
        if(loginButton.isPresent(10)){
            Logger.info("Logged state is required.");
            login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"));
        }
        else {
            Logger.info("App is already logged in.");
        }
        return null;
    }

}
