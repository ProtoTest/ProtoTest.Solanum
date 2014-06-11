package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;
import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Logger;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

// DishAnywhere UI Tests - Galaxy Note 10.1 (Android Tablet)

@Test()
public class KindleFireUiTests extends EggplantTestBase {

    @Test
    public void testLogoutAndLogin() {
        Logger.info("Beginning Test: Logout and Login.");
        new DeviceMain()
                .goHome()
                .openDishAnywhereHome()
                .goBackToDeviceScreen()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .verifyLoggedIn()
                .logOutIfLoggedIn()
                .verifyLoggedOut();
        Verifications.assertVerifications();

    }

}
