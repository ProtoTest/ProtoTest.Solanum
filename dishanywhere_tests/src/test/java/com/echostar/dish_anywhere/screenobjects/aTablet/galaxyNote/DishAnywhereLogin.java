package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.*;
import org.testng.Assert;

import java.awt.*;

// Screen object for DishAnywhere app - Login screen

public class DishAnywhereLogin extends DeviceMain {
    private EggplantElement onlineId = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Login/OnlineIDField"));
    private EggplantElement passwordField = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Login/PasswordField"));
    private EggplantElement loginButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Login/LoginButton"));

    public final DishAnywherePopups popups = new DishAnywherePopups();

    public DishAnywhereHome login(String onlineId, String password) {
        Logger.info("Logging in...");
        popups.waitForScreenToLoad();
        this.onlineId.type(onlineId);
        this.passwordField.type(password);
        loginButton.click();
        EggplantElement errorField = new EggplantElement(By.Text("The Online ID / Password combination", SearchRectangle.topHalf()));
        if (errorField.isPresent()) {
            Assert.fail("Could not login.");
        }
        Logger.info("Logged in.");
        return new DishAnywhereHome();
    }

    public DishAnywhereLogin loginIfLoggedOut() {
        Logger.info("Scanning for app login state...");
        EggplantTestBase.sleep(10000);
        if(loginButton.isPresent()){
            Logger.info("Logged state is required.");
            login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"));
        }
        else {
            Logger.info("App is already logged in.");
        }
        return null;
    }

}