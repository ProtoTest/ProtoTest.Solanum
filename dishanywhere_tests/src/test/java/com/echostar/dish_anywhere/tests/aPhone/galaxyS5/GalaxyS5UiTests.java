package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.Config;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SolanumRetryAnalyzer;
import org.testng.annotations.Test;

//
//Tests for proper functionality of basic app functionality
//

public class GalaxyS5UiTests extends GalaxyS5TestBase {

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void testLogoutAndLogin() {
        Logger.info("BEGINNING TEST: LOGOUT AND LOGIN.");
        new DishAnywhereHome()
                .openSettings()
                .logout()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .verifyLoggedIn()
                .returnToDeviceMain();
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void testPredictiveSearch() {
        Logger.info("BEGINNING TEST: PREDICTIVE SEARCH.");
        RadishScraper radishScraper = new RadishScraper();
        radishScraper.getMovies();
        String movie = radishScraper.findMovieWithDrm("nagra");
        new DishAnywhereHome()
                .openOnDemand()
                .clickSearchButton()
                .verifyPredictiveSearch(movie)
                .openOnDemandResults()
                .openMovie()
                .watchMovie()
                .verifyMoviePlays();
    }
}
