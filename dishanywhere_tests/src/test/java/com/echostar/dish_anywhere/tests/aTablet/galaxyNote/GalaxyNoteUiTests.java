package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DishAnywhereHome;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Logger;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

// DishAnywhere UI Tests - Galaxy Note 10.1 (Android Tablet)

@Test()
public class GalaxyNoteUiTests extends EggplantTestBase {

    @Test
    public void testLogoutAndLogin() {
        Logger.info("Beginning Test: Logout and Login.");
        new DeviceMain()
                .goToHomeScreen()
                .killApp()
                .goHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .verifyLoggedIn()
                .logOutIfLoggedIn()
                .verifyLoggedOut();
        Verifications.assertVerifications();

    }
    @Test
    public void testPredictiveSearch() {
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
