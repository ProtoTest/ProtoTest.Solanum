package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywherePopups;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;

//
// Enhanced TestBase class for any Galaxy S5 specific functionality
//

public class GalaxyS5TestBase extends EggplantTestBase
{
    @Override
    public void initializeApp() {
        // Runs at startup for any test
        new DeviceMain()
                .goHome()
                .openDishAnywhereApp()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openSettings()
                .openAuthorizedDevices()
                .authorizeThisDevice()
                .openParentalControls(Config.getTestProp("dishAnywherePassCode"))
                .clearMovieBlocks()
                .clearTVBlocks()
                .openGuide();
    }

    @Override
    public void uninitializeApp() {
        // Try to prevent the video player from being open before any future tests.
        new DeviceMain().goHome();
    }

}
