package com.echostar.dish_anywhere.eggplant_suite.androidphone;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.SearchRectangle;
import com.prototest.solanum.TextOption;

/**
 */
public class DishAnywhereSettings extends AndroidScreen {
    private EggplantElement logout = new EggplantElement(By.Text("Logout"));

    public DishAnywhereSettings() {
        super();
    }

    public DishAnywhereLogin logout() {
        logout.click();
        new EggplantElement(By.Text("OK", TextOption.searchRectangle(SearchRectangle.middleHalf().trimTop(25)))).click();
        return new DishAnywhereLogin();
    }
}
