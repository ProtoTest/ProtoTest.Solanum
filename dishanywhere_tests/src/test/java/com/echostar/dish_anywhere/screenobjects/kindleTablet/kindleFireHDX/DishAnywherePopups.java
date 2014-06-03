package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFireHDX;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;

// Screen object for DishAnywhere app - Popups

public class DishAnywherePopups extends DeviceMain {
    private EggplantElement LoadingMessage = new EggplantElement(By.Text("Logging"));

    public DishAnywherePopups() {
        super();
    }

    public DishAnywherePopups waitForScreenToLoad() {
        Logger.info("Waiting for screen to load...");
        LoadingMessage.waitForNotPresent(15);
        return null;
    }
}
