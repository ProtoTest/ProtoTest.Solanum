package com.echostar.dish_anywhere.tests.aphone.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Brian on 6/4/2014.
 */
public class GalaxyS5OnDemandCategory extends EggplantTestBase{
    @Test
    public void movieCategory(){

        List<String> movieTitles = Arrays.asList("10 Years", "100 Girls", "12 Biggest Lies", "12th & Delaware", "180 Segundos", "2 Guns");

        new DeviceMain()
                .goHome()
                .openDishAnywhereApp()
                .exitPlayerIfOpen()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openDishAnywhereHome()
                .openOnDemand()
                .openMovies()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();
    }

    @Test
    public void featuredCategory(){

        List<String> movieTitles = Arrays.asList("Getaway", "The Normal Heart", "To Rome With Love", "Game of Thrones", "Da Vinci's Demons");

        new DeviceMain()
                .goHome()
                .openDishAnywhereApp()
                .exitPlayerIfOpen()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openDishAnywhereHome()
                .openOnDemand()
                .openFeatured()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();

    }

    @Test
    public void familyCategory(){
        List<String> movieTitles = Arrays.asList("12 Biggest Lies", "2012: Prophecy or Panic", "A Christmas Without Snow", "A Letter to Dad", "A Little Curious");


        new DeviceMain()
                .goHome()
                .openDishAnywhereApp()
                .exitPlayerIfOpen()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openDishAnywhereHome()
                .openOnDemand()
                .openFamily()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();

    }

    @Test
    public void tvShowsCategory(){

        List<String> movieTitles = Arrays.asList("2 Days", "2 Days: Gennady Golovkin", "2 Days: Nonito Donaire");

        new DeviceMain()
                .goHome()
                .openDishAnywhereApp()
                .exitPlayerIfOpen()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openDishAnywhereHome()
                .openOnDemand()
                .openTvShows()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();

    }

    @Test
    public void networksCategory(){

        List<String> movieTitles = Arrays.asList("MGM", "Starz", "Hallmark Channel", "Encore", "HBO");

        new DeviceMain()
                .goHome()
                .openDishAnywhereApp()
                .exitPlayerIfOpen()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openDishAnywhereHome()
                .openOnDemand()
                .openNetworks()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();

    }
}
