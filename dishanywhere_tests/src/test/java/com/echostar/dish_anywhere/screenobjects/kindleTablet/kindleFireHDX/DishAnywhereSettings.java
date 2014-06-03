package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFireHDX;

import com.prototest.solanum.*;

import java.awt.*;

/**
 */
public class DishAnywhereSettings extends DeviceMain {
    private EggplantElement logout = new EggplantElement(By.Text("Logout"));
    private EggplantElement privacyPolicy = new EggplantElement(By.Text("Privacy Policy"));

    public DishAnywhereSettings() {
        super();
    }

    public DishAnywhereLogin logout() {
        Logger.info("Logging out...");
        //EggplantDriver driver = new EggplantDriver();
        //driver.scrollWheelDown("20");
        privacyPolicy.swipeUp();
        logout.click();
        new EggplantElement(By.Text("OK", SearchRectangle.middleHalf())).click();
        Logger.info("Logout complete.");
        return new DishAnywhereLogin();
    }
}
