package com.echostar.dish_anywhere.tests.aphone.galaxyS5;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

// DishAnywhere UI Tests - Galaxy Note 10.1 (Android Tablet)

@Test()
public class GalaxyS5OnDemandFilters extends EggplantTestBase {


    @Test
    public void onDemandTest() {
        List<String> movieTitles = Arrays.asList("10 Years", "100 Girls", "24 Hour Party People", "3 Times a Charm", "30 Years to Life", "50 First Dates");

        new DeviceMain()
                .goHome()
                .openDishAnywhereApp()
                .exitPlayerIfOpen()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openDishAnywhereHome()
                .openOnDemand()
                .openBlockbuster()
                .openMovies()
                .openFilters()
                .selectFilter("Comedy")
                .done()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();



    }

}
