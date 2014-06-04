package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
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

    }

    @Test
    public void familyCategory(){

        List<String> movieTitles = Arrays.asList("Edge of Tomorrow","Captain Phillips","Parkland","Prisoners","Battle of the Year","Getaway","One Direction: This is Us");

        new DeviceMain()
                .goHome()
                .killApp()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openOnDemand()
                .openFamily()
                .verifyTitlesPresent(movieTitles);

    }

    @Test
    public void tvShowsCategory(){

        List<String> movieTitles = Arrays.asList("Edge of Tomorrow","Captain Phillips","Parkland","Prisoners","Battle of the Year","Getaway","One Direction: This is Us");

        new DeviceMain()
                .goHome()
                .killApp()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openOnDemand()
                .openTVShows()
                .verifyTitlesPresent(movieTitles);

    }

    @Test
    public void networksCategory(){

        List<String> movieTitles = Arrays.asList("Edge of Tomorrow","Captain Phillips","Parkland","Prisoners","Battle of the Year","Getaway","One Direction: This is Us");

        new DeviceMain()
                .goHome()
                .killApp()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openOnDemand()
                .openNetworks()
                .verifyTitlesPresent(movieTitles);

    }
}
