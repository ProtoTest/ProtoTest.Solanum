package com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5;

import com.prototest.solanum.*;
import org.testng.Assert;

import java.awt.*;

/**
 */
public class DishAnywhereLogin extends AndroidScreen {
    private EggplantElement onlineId = new EggplantElement(By.Text("Online ID", TextOption.hotSpot(new Point(75,109))));
    private EggplantElement password = new EggplantElement(By.Text("Password",SearchRectangle.middleHalf(), TextOption.hotSpot(new Point(75,109))));
    private EggplantElement loginButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Login/LoginButton"));
    public DishAnywhereLogin() {
        super();
    }

    public DishAnywhereHome login(String onlineId, String password) {
        Logger.info("Logging in...");
        this.onlineId.type(onlineId);
        this.password.type(password);
        loginButton.click();
        EggplantElement errorField = new EggplantElement(By.Text("The Online ID / Password combination", SearchRectangle.topHalf()));
        if (errorField.isPresent()) {
            Assert.fail("Didn't login");
        }
        Logger.info("Logged in.");
        return new DishAnywhereHome();
    }


}
