package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;

import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Logger;
import org.testng.annotations.Test;

// DishAnywhere UI Tests - Kindle Fire HDX (Kindle Tablet)

@Test()
public class KindleFireHdxUiTests extends EggplantTestBase {

    @Test
    public void testLogoutAndLogin() {
        Logger.info("Beginning Test: Logout and Login.");
        new DeviceMain()
                .goHome()
                .openSettings()
                .logout()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .verifyLoggedIn();
    }
}
