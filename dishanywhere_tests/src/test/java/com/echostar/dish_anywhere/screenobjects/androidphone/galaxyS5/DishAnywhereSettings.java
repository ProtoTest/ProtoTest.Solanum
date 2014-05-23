package com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5;

import com.prototest.solanum.*;

import java.awt.*;

/**
 */
public class DishAnywhereSettings extends AndroidScreen {
    private EggplantElement logout = new EggplantElement(By.Text("Logout"));

    public DishAnywhereSettings() {
        super();
    }

    public DishAnywhereLogin logout() {
        Logger.message("Logging out...");
        if (! logout.isPresent()) {
            new EggplantElement(By.Text("On Demand", TextOption.searchRectangle(SearchRectangle.bottomQuarter()),
                        TextOption.hotSpot(new Point(0,-400))))
                .swipeUp();
        }
        logout.click();
        new EggplantElement(By.Text("OK", TextOption.searchRectangle(SearchRectangle.middleHalf().trimTop(25)))).click();
        Logger.message("Logout complete.");
        return new DishAnywhereLogin();
    }
}
