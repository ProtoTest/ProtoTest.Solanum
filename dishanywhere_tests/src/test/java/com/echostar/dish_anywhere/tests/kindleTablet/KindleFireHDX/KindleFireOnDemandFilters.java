package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;
import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

// DishAnywhere UI Tests - Galaxy Note 10.1 (Android Tablet)

@Test()
public class KindleFireOnDemandFilters extends EggplantTestBase {


    @Test
    public void onDemandTest() {
        List<String> movieTitles = Arrays.asList("Lewis Black","Patton Oswalt","Amen","Ben Stiller","Jim Norton");

        new DeviceMain()
                .goHome()
                .killApp()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openBlockbuster()
                .openFilters()
                .selectFilter("Comedy")
                .done()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();



    }

}
