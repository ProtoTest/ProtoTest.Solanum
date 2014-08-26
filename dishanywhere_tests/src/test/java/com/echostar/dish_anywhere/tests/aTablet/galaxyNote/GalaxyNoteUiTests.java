package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DishAnywhereHome;
import com.prototest.solanum.Config;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SolanumRetryAnalyzer;
import org.testng.annotations.Test;

// DishAnywhere UI Tests - Galaxy Note 10.1 (Android Tablet)

public class GalaxyNoteUiTests extends GalaxyNoteTestBase {

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void testLogoutAndLogin() {
        Logger.info("BEGINNING TEST: LOGOUT AND LOGIN.");
        new DishAnywhereHome()
                .verifyLoggedIn()
                .logOutIfLoggedIn()
                .verifyLoggedOut()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .verifyLoggedIn();
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void testPredictiveSearch() {
        Logger.info("BEGINNING TEST: PREDICTIVE SEARCH.");
        RadishScraper radishScraper = new RadishScraper();
        radishScraper.getMovies();
        String movie = radishScraper.findMovieWithDrm("nagra");
        new DishAnywhereHome()
                .openOnDemand()
                .verifyPredictiveSearch(movie)
                .openMovie(movie)
                .watchMovie()
                .verifyMoviePlays();
    }

}
