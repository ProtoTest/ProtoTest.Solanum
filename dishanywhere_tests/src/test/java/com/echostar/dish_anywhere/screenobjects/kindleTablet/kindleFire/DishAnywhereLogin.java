package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.*;
import org.testng.Assert;

// Screen object for DishAnywhere app - Login screen

public class DishAnywhereLogin extends DeviceMain {
    private EggplantElement onlineId = new EggplantElement("onlineId", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Login/OnlineIDField"));
    private EggplantElement passwordField = new EggplantElement("passwordField", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Login/PasswordField"));
    private EggplantElement onlineIdEnd = new EggplantElement("onlineIdEnd", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Login/OnlineIDFieldEnd"));
    private EggplantElement passwordFieldEnd = new EggplantElement("passwordFieldEnd", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Login/PasswordFieldEnd"));
    private EggplantElement loginButton = new EggplantElement("loginButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Login/LoginButton"));
    private EggplantElement errorField = new EggplantElement("errorField", By.Text("The Online ID / Password combination", SearchRectangle.topHalf()));

    public final DishAnywherePopups popups = new DishAnywherePopups();

    public DishAnywhereHome login(String username, String password) {
        Logger.info("Logging in with credentials: (" + onlineId + ", " + password + ").");
        popups.waitForScreenToLoad();
        if(!onlineId.isPresent()){
            loginButton.click();
        }
        onlineId.press();
        onlineId.sendKeys(EggplantKeys.backspace);

        onlineId.type(username);
        passwordField.type(password);
        if (closeKeyboardButton.isPresent()){
            closeKeyboardButton.click();
        }
        loginButton.resetLocation().click();
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
