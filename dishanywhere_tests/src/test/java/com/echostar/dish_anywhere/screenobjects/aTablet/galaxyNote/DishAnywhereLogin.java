package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.*;
import org.testng.Assert;

// Screen object for DishAnywhere app - Login screen

public class DishAnywhereLogin extends DeviceMain {
    private EggplantElement onlineId = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Login/OnlineIDField"));
    private EggplantElement passwordField = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Login/PasswordField"));
    private EggplantElement onlineIdEnd = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Login/OnlineIDFieldEnd"));
    private EggplantElement passwordFieldEnd = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Login/PasswordFieldEnd"));
    private EggplantElement loginButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Login/LoginButton"));
    private EggplantElement errorField = new EggplantElement(By.Text("The Online ID / Password combination", SearchRectangle.topHalf()));

    public final DishAnywherePopups popups = new DishAnywherePopups();

    public DishAnywhereHome login(String onlineId, String password) {
        Logger.info("Logging in with credentials: (" + onlineId + ", " + password + ").");
        popups.waitForScreenToLoad();
        this.onlineId.type(onlineId);
        this.passwordField.type(password);
        if (closeKeyboardButton.isPresent()){
            closeKeyboardButton.click();
        }
        loginButton.click();
        popups.waitForScreenToLoad();
        //EggplantTestBase.sleep(10000);
        if (errorField.isPresent()) {
            Assert.fail("Could not login.");
        }
        Logger.info("Logged in.");
        return new DishAnywhereHome();
    }


    public DishAnywhereLogin verifyLoggedOut() {
        loginButton.waitForPresent(10);
        return this;
    }
}
