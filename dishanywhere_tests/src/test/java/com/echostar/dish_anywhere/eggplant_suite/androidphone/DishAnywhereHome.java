package com.echostar.dish_anywhere.eggplant_suite.androidphone;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.SearchRectangle;
import com.prototest.solanum.TextOption;

/**
 */
public class DishAnywhereHome extends AndroidScreen {
    private EggplantElement settingsButton = new EggplantElement(By.Text("Settings", TextOption.searchRectangle(SearchRectangle.bottomHalf().trimTop(30))));

    public DishAnywhereHome() {
        super();
    }

    public DishAnywhereSettings openSettings() {
        settingsButton.click();
        return new DishAnywhereSettings();
    }
}
