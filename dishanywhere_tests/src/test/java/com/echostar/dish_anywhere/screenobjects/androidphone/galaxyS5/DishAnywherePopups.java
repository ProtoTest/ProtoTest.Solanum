package com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SearchRectangle;

// Screen object for DishAnywhere app - Popups

public class DishAnywherePopups extends DeviceMain {
    private EggplantElement LoadingMessage = new EggplantElement(By.Text("Loading"));

    public DishAnywherePopups() {
        super();
    }

    public DishAnywherePopups waitForScreenToLoad() {
        Logger.info("Waiting for screen to load...");
        LoadingMessage.waitForNotPresent(15);
        return null;
    }
}
