package com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5;

import com.prototest.solanum.*;

/**
 */
public class DishAnywhereHome extends AndroidScreen {
    private EggplantElement settingsButton = new EggplantElement(By.Text("Settings", TextOption.searchRectangle(SearchRectangle.bottomHalf().trimTop(30))));

    public DishAnywhereHome() {
        super();
        new EggplantElement(By.Text("Guide", TextOption.searchRectangle(SearchRectangle.bottomHalf()))).click();
    }

    public DishAnywhereSettings openSettings() {
        Logger.message("Opening Settings panel.");
        settingsButton.click();
        return new DishAnywhereSettings();
    }
}
