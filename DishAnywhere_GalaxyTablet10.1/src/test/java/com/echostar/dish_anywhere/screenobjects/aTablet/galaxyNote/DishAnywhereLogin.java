package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SearchRectangle;

// Screen object for DishAnywhere app - Login screen

public class DishAnywhereLogin extends DeviceMain {

    public EggplantElement onlineId = new EggplantElement("Online ID field", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Login/OnlineIDField"));
    public EggplantElement passwordField = new EggplantElement("Password field", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Login/PasswordField"));
    public EggplantElement onlineIdEnd = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Login/OnlineIDFieldEnd"));
    public EggplantElement passwordFieldEnd = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Login/PasswordFieldEnd"));
    public EggplantElement loginButton = new EggplantElement("Login button", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Login/LoginButton"));
    public EggplantElement errorField = new EggplantElement(By.Text("The Online ID / Password combination", SearchRectangle.Quadrants.TOP_HALF));


    public final DishAnywherePopups popups = new DishAnywherePopups();

    public DishAnywhereHome login(String onlineId, String password) {
        Logger.info("Logging in with credentials: (" + onlineId + ", " + password + ").");
        popups.waitForScreenToLoad();
        this.onlineId.clearText();
        this.onlineId.type(onlineId);
        this.passwordField.clearText();
        this.passwordField.type(password);
        if (closeKeyboardButton.isPresent()){
            closeKeyboardButton.click();
        }
        loginButton.click();
        popups.waitForScreenToLoad();
        DishAnywhereHome home = new DishAnywhereHome();
        if(!home.guideButton.isPresent(60)){
            throw new RuntimeException("Did not log in successfully");
        }
        Logger.info("Logged in.");
        return home;
    }

    public DishAnywhereLogin verifyLoggedOut() {
        Logger.info("Verifying user is logged out...");
        loginButton.waitForPresent(10);
        return this;
    }
}
