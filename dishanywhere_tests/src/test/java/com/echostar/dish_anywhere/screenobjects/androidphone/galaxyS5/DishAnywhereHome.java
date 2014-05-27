package com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5;

import com.prototest.solanum.*;

/**
 */
public class DishAnywhereHome extends AndroidScreen {
    private EggplantElement settingsButton = new EggplantElement(By.Text("Settings", SearchRectangle.bottomHalf()));

    public DishAnywhereHome() {
        super();
        new EggplantElement(By.Text("Guide", SearchRectangle.bottomHalf())).click();
    }

    public DishAnywhereSettings openSettings() {
        Logger.info("Opening Settings panel.");
        settingsButton.click();
        return new DishAnywhereSettings();
    }
}
