package com.echostar.dish_anywhere.eggplant_suite.androidphone;

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
        if (! logout.isPresent()) {
            new EggplantElement(By.Text("On Demand", TextOption.searchRectangle(SearchRectangle.bottomQuarter()),
                        TextOption.hotSpot(new Point(0,-400))))
                .swipeUp();
        }
        logout.click();
        new EggplantElement(By.Text("OK", TextOption.searchRectangle(SearchRectangle.middleHalf().trimTop(25)))).click();
        return new DishAnywhereLogin();
    }
}
