package com.echostar.dish_anywhere.tests.aphone.galaxyS5;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

// DishAnywhere UI Tests - Galaxy Note 10.1 (Android Tablet)

@Test()
public class GalaxyS5OnDemandFilters extends EggplantTestBase {


    @Test
    public void onDemandTest() {
        List<String> movieTitles = Arrays.asList("Lewis Black","Patton Oswalt","Amen","Ben Stiller","Jim Norton");

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



    }

}
