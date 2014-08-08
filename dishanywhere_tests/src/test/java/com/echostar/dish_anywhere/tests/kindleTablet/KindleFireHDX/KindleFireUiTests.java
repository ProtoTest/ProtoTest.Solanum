package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DishAnywhereHome;
import com.prototest.solanum.Config;
import com.prototest.solanum.Logger;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

// DishAnywhere UI Tests - Galaxy Note 10.1 (Android Tablet)

@Test()
public class KindleFireUiTests extends KindleTestBase {

    @Test
    public void testLogoutAndLogin() {
        Logger.info("Beginning Test: Logout and Login.");
        new DishAnywhereHome()
                .verifyLoggedIn()
                .logOutIfLoggedIn()
                .verifyLoggedOut()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .verifyLoggedIn();
        Verifications.assertVerifications();

    }
    @Test
    public void testPredictiveSearch() {
        Logger.info("Beginning Test: Predictive Search.");
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
