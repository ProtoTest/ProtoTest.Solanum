package com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SearchRectangle;
import org.testng.Assert;

// Screen object for DishAnywhere app - Login screen

public class DishAnywhereLogin extends DeviceMain {
    private EggplantElement onlineId = new EggplantElement("ID Field", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Login/OnlineIDField"));
    private EggplantElement passwordField = new EggplantElement("Password Field", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Login/PasswordField"));
    private EggplantElement onlineIdEnd = new EggplantElement(By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Login/OnlineIDFieldEnd"));
    private EggplantElement passwordFieldEnd = new EggplantElement(By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Login/PasswordFieldEnd"));
    private EggplantElement loginButton = new EggplantElement("Login Button", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Login/LoginButton"));
    private EggplantElement errorField = new EggplantElement("Error Field", By.Text("The Online ID / Password combination", SearchRectangle.Quadrants.TOP_HALF));

    public final DishAnywherePopups popups = new DishAnywherePopups();

    public DishAnywhereHome login(String onlineId, String password) {
        Logger.info("Logging in with credentials: (" + onlineId + ", " + password + ").");
        popups.waitForScreenToLoad();
        this.onlineId.setText(onlineId);
        this.passwordField.setText(password);
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
