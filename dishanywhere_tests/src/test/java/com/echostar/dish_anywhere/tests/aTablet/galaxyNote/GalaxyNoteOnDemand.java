package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereScrollView;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Logger;
import org.testng.annotations.Test;

// DishAnywhere UI Tests - Galaxy Note 10.1 (Android Tablet)

@Test()
public class GalaxyNoteOnDemand extends EggplantTestBase {


    @Test
    public void onDemandTest() {
        new DeviceMain()
                .goHome()
                .killApp()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openOnDemand()
                .openMovies()
                .openProtectedMovie("Captain Phillips")
                .enterPasscode("1111")
                .watchMovie()
                .waitForControls();

    }

}
