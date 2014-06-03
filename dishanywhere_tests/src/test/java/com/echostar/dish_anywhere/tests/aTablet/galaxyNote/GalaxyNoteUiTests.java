package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereScrollView;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Logger;
import org.testng.annotations.Test;

// DishAnywhere UI Tests - Galaxy Note 10.1 (Android Tablet)

@Test()
public class GalaxyNoteUiTests extends EggplantTestBase {

    @Test
    public void testLogoutAndLogin() {
        Logger.info("Beginning Test: Logout and Login.");
        new DeviceMain().goHome()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .verifyLoggedIn()
                .logOutIfLoggedIn()
                .verifyLoggedOut();
    }

    public void testMoviePlayback(){

        new DeviceMain().goHome()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                        .openDishAnywhereHome();
    }
}
