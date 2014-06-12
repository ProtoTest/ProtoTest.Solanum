package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;

/**
 */
public class GalaxyNoteTestBase extends EggplantTestBase {
    @Override
    public void initializeApp() {
        new DeviceMain()
                .goHome()
                .killApp()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"));
    }

    @Override
    public void uninitializeApp() {
        new DeviceMain()
             .nav.backButton.click().click();
    }
}
