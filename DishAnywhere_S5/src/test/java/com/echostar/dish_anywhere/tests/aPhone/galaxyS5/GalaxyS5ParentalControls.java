package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.Config;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SolanumRetryAnalyzer;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

//
//Tests for proper functionality of "Settings" menu, "Parental Controls" option
//

public class GalaxyS5ParentalControls extends GalaxyS5TestBase {

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void clearAllBlockedContentAndPlayMovie(){
        Logger.info("BEGINNING TEST: CLEAR ALL PARENTAL CONTROLS BLOCKS AND PLAY MOVIE.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_phone, 19);
        String movieName = RadishScraper.getShortName(movies.get(0).get("franchiseName"),25);

        new DishAnywhereHome()
                .openSettings()
                .openParentalControls(Config.getTestProp("dishAnywherePassCode"))
                .clearMovieBlocks()
                .clearTVBlocks()
                .openOnDemand()
                .openMovies()
                .openMovie(movieName)
                .watchMovie()
                .verifyMoviePlays();
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void setAllContentBlockedAndPlayMovie(){
        Logger.info("BEGINNING TEST: SET ALL PARENTAL CONTROLS BLOCKS AND PLAY MOVIE.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_phone, 19);
        String movieName = RadishScraper.getShortName(movies.get(0).get("franchiseName"),25);
        new DishAnywhereHome()
                .openSettings()
                .openParentalControls(Config.getTestProp("dishAnywherePassCode"))
                .setMovieGBlocked()
                .setTVYBlocked()
                .openOnDemand()
                .openMovies()
                .openProtectedMovie(movieName)
                .enterPasscode(Config.getTestProp("dishAnywherePassCode"))
                .watchMovie()
                .verifyMoviePlays().goBackToDeviceScreen();
    }

}
