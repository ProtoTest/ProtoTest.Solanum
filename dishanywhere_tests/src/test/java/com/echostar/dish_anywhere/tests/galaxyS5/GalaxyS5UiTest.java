package com.echostar.dish_anywhere.tests.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5.DishAnywhereHome;
import com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5.DishAnywhereLogin;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Logger;
import org.testng.annotations.Test;

// DishAnywhere UI Tests - GalaxyS5 (Android Phone)

@Test()
public class GalaxyS5UiTest extends EggplantTestBase {

    @Test
    public void testLogoutAndLogin() {
        Logger.info("Beginning Test: Logout and Login.");
        new DeviceMain().goHome()
                .openDishAnywhereHome()
                .openSettings()
                .logout()
                .login(Config.dishAnywhereLoginName, Config.dishAnywhereLoginPass)
                .verifyLoggedIn();
    }
}
