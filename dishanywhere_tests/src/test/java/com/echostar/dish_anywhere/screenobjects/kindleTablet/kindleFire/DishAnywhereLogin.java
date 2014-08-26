package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SearchRectangle;
import org.testng.Assert;

// Screen object for DishAnywhere app - Login screen

public class DishAnywhereLogin extends DishAnywhereHome {
    private EggplantElement onlineId = new EggplantElement("onlineId", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Login/OnlineIDField"));
    private EggplantElement passwordField = new EggplantElement("passwordField", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Login/PasswordField"));
    private EggplantElement onlineIdEnd = new EggplantElement("onlineIdEnd", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Login/OnlineIDFieldEnd"));
    private EggplantElement passwordFieldEnd = new EggplantElement("passwordFieldEnd", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Login/PasswordFieldEnd"));
    private EggplantElement loginButton = new EggplantElement("loginButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Login/LoginButton"));
    private EggplantElement errorField = new EggplantElement("errorField", By.Text("The Online ID / Password combination", SearchRectangle.Quadrants.TOP_HALF));

    public final DishAnywherePopups popups = new DishAnywherePopups();

    public DishAnywhereHome login(String username, String password) {
        Logger.info("Logging in with credentials: (" + onlineId + ", " + password + ").");
        popups.waitForScreenToLoad();
        if(!onlineId.isPresent()){
            loginButton.click();
        }

        onlineId.clearText();
        onlineId.type(username);
        passwordField.clearText();
        passwordField.type(password);
        if (closeKeyboardButton.isPresent()){
            closeKeyboardButton.click();
        }
        loginButton.click();
        waitForScreenToLoad();
        DishAnywhereHome home = new DishAnywhereHome();
        if(!home.guideButton.isPresent(10)){
            Assert.fail("Could not log in successfully");
        }
        Logger.info("Logged in.");
        return home;
    }


    public DishAnywhereLogin verifyLoggedOut() {
        Logger.info("Verifying app is logged out");
        loginButton.waitForPresent(10);
        return this;
    }
}
