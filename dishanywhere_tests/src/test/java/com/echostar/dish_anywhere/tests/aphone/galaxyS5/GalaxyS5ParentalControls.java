package com.echostar.dish_anywhere.tests.aphone.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import org.testng.annotations.Test;

/**
 * Created by Brian on 6/4/2014.
 */
public class GalaxyS5ParentalControls extends EggplantTestBase{
    @Test
    public void clearAllBlockedContentAndPlayMovie(){
        new DeviceMain()
                .goHome()
                .openDishAnywhereApp()
                .exitPlayerIfOpen()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openSettings()
                .openParentalControls("1111")
                .clearMovieBlocks()
                .clearTVBlocks()
                .openOnDemand()
                .openMovies()
                .openMovie("Parkland")
                .watchMovie()
                .verifyMoviePlays();
    }

    @Test
    public void setAllContentBlockedAndPlayMovie(){
        new DeviceMain()
                .goHome()
                .openDishAnywhereApp()
                .exitPlayerIfOpen()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openSettings()
                .openParentalControls("1111")
                .setMovieGBlocked()
                .setTVYBlocked()
                .openOnDemand()
                .openMovies()
                .openProtectedMovie("Parkland")
                .enterPasscode("1111")
                .watchMovie()
                .verifyMoviePlays();
    }
}
