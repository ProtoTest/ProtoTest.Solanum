package com.echostar.dish_anywhere.tests.aphone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.Logger;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Brian on 6/4/2014.
 */
public class GalaxyS5Blockbuster {

    @Test
    public void movieCategory(){

        List<String> movieTitles = Arrays.asList("10 Years", "100 Girls", "12 Biggest Lies");

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
                .verifyTitlesPresent(movieTitles);
    }

    @Test
    public void tvShowsCategory(){

        List<String> movieTitles = Arrays.asList("A Nation Adrift", "Amen", "America's Godly Heritage");

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
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();
    }

    @Test
    public void kidsMovieCategory(){

        List<String> movieTitles = Arrays.asList("Adam Sandler", "Adventures of Bailey", "Alice Through the Looking", "An Ant's Life");

        new DeviceMain()
                .goHome()
                .openDishAnywhereApp()
                .exitPlayerIfOpen()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openDishAnywhereHome()
                .openOnDemand()
                .openBlockbuster()
                .openTVShows()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();
    }

    @Test
    public void kidsTvShowsCategory(){

        List<String> movieTitles = Arrays.asList("Angelina Ballerina", "Animal Crackers", "Art & Music", "Baby Class");

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
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();
    }

}
