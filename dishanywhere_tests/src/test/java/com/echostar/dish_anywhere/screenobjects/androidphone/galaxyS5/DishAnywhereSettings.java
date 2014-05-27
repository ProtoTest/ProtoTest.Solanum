package com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5;

import com.prototest.solanum.*;

import java.awt.*;

/**
 */
public class DishAnywhereSettings extends DeviceMain {
    private EggplantElement logout = new EggplantElement(By.Text("Logout"));

    public DishAnywhereSettings() {
        super();
    }

    public DishAnywhereLogin logout() {
        Logger.info("Logging out...");
        if (! logout.isPresent()) {
            new EggplantElement(By.Text("On Demand", SearchRectangle.bottomQuarter(),
                        TextOption.hotSpot(new Point(0,-400))))
                .swipeUp();
        }
        logout.click();
        new EggplantElement(By.Text("OK", SearchRectangle.middleHalf().trimTop(25))).click();
        Logger.info("Logout complete.");
        return new DishAnywhereLogin();
    }
}
