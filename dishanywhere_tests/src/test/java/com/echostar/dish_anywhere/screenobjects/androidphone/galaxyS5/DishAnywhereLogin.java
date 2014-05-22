package com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.SearchRectangle;
import com.prototest.solanum.TextOption;
import org.testng.Assert;

import java.awt.*;

/**
 */
public class DishAnywhereLogin extends AndroidScreen {
    private EggplantElement onlineId = new EggplantElement(By.Text("Online ID", TextOption.hotSpot(new Point(75,109))));
    private EggplantElement password = new EggplantElement(By.Text("Password", TextOption.hotSpot(new Point(75,109)), TextOption.searchRectangle(SearchRectangle.middleHalf())));
    private EggplantElement loginButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Login/LoginButton"));
    public DishAnywhereLogin() {
        super();
    }

    public DishAnywhereHome login(String onlineId, String password) {
        this.onlineId.type(onlineId);
        this.password.type(password);
        loginButton.click();
        EggplantElement errorField = new EggplantElement(By.Text("The Online ID / Password combination", SearchRectangle.topHalf()));
        if (errorField.isPresent()) {
            Assert.fail("Didn't login");
        }
        return new DishAnywhereHome();
    }


}
