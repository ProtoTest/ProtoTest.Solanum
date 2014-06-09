package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

import java.util.*;

/**
 * Created by Brian on 6/4/2014.
 */
public class GalaxyNoteOnDemandCategory extends EggplantTestBase{
    @Test
    public void movieCategory(){

        List<String> movieTitles = Arrays.asList("Edge of Tomorrow","Captain Phillips","Parkland","Prisoners","Battle of the Year","Getaway","One Direction: This is Us");

        new DeviceMain()
                .goHome()
                .killApp()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openOnDemand()
                .openMovies()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();

    }

    @Test
    public void featuredCategory(){

        List<String> movieTitles = Arrays.asList("Edge of Tomorrow","Captain Phillips","Parkland","Prisoners","Battle of the Year","Getaway","One Direction: This is Us");

        new DeviceMain()
                .goHome()
                .killApp()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openOnDemand()
                .openFeatured()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();

    }

    @Test
    public void familyCategory(){

        List<String> movieTitles = Arrays.asList("El Chavo Animado", "Color Crew", "Joey's Toy Box", "Sweet Dreams", "Baby Class", "Bloop & Loop");

        new DeviceMain()
                .goHome()
                .killApp()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openOnDemand()
                .openFamily()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();

    }

    @Test
    public void tvShowsCategory(){

        List<String> movieTitles = Arrays.asList("Power", "What to Watch", "Pat & Stu", "Glenn Beck Program");

        new DeviceMain()
                .goHome()
                .killApp()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openOnDemand()
                .openTVShows()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();

    }

    @Test
    public void networksCategory(){

        List<String> movieTitles = Arrays.asList("BabyFirstTV", "Cinemax", "Content Media", "Cookie Jar", "Echo Bridge", "Encore");

        new DeviceMain()
                .goHome()
                .killApp()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openOnDemand()
                .openNetworks()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();

    }
}
