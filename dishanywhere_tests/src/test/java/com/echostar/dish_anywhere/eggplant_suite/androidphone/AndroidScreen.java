package com.echostar.dish_anywhere.eggplant_suite.androidphone;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.TextOption;

/**
 */
public class AndroidScreen {
    public final Navigation nav = new Navigation();

    public AndroidScreen clickOn(String text, TextOption... options) {
        new EggplantElement(By.Text(text, options)).click();
        return this;
    }
}
