package com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5;

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
        new EggplantElement(By.Text("Guide", TextOption.searchRectangle(SearchRectangle.bottomHalf()))).click();
    }

    public DishAnywhereSettings openSettings() {
        settingsButton.click();
        return new DishAnywhereSettings();
    }
}
