package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;

/**
 */
public class GalaxyS5TestBase extends EggplantTestBase
{


    @Override
    public void initializeApp() {

        new DeviceMain()
                .goHome()
                .openDishAnywhereApp()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"));
    }


    @Override
    public void uninitializeApp() {
        // Try to prevent the video player from being open before any future tests.
        DeviceMain deviceMain = new DeviceMain();
        for (int i = 0; i < 2 && !deviceMain.isOnHome(); i++) {
            deviceMain.nav.backButton.click();
        }
    }
}
