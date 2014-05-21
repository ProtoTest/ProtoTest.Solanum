package com.echostar.dish_anywhere.eggplant_suite.androidphone;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

/**
 */
public class DishAnywhereHome extends AndroidScreen {
    private EggplantElement settingsButton = new EggplantElement(By.Text("Settings"));

    public DishAnywhereHome() {
        super();
    }

    public DishAnywhereSettings openSettings() {
        settingsButton.click();
        return new DishAnywhereSettings();
    }
}
