package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;

// Screen object for DishAnywhere app - Popups

public class DishAnywherePopups extends DeviceMain {

    private EggplantElement LoadingMessage = new EggplantElement("LoadingMessage", By.Text("Loading"));

    public DishAnywherePopups() {
        super();
    }

    public DishAnywherePopups waitForScreenToLoad() {
        Logger.info("Waiting for screen to load...");
        LoadingMessage.waitForNotPresent(20);
        return null;
    }

}
