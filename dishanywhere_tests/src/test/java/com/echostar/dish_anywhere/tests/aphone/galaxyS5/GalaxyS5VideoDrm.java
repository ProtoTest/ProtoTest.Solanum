package com.echostar.dish_anywhere.tests.aphone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Logger;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

// DishAnywhere API Tests - GalaxyS5 (Android Phone)

public class GalaxyS5VideoDrm extends EggplantTestBase {


    @Test
    public void watchNagraMovie() {
        RadishScraper radishScraper = new RadishScraper();
        radishScraper.getMovies();
        String movie = radishScraper.findMovieWithDrm("nagra");
        watchMovie(movie);

        Verifications.addVerification("Watched onDemand nagra movie.", true);
    }

    @Test
    public void watchWidevineMovie() {
        RadishScraper radishScraper = new RadishScraper();
        radishScraper.getMovies();
        String movie = radishScraper.findMovieWithDrm("widevine");
        watchMovie(movie);

        Verifications.addVerification("Watched onDemand widevine movie.", true);
    }

    private void watchMovie(String movie) {
        new DeviceMain()
                .goHome()
                .openDishAnywhereApp()
                .exitPlayerIfOpen()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openOnDemand()
                .clickSearchButton()
                .searchFor(movie)
                .openOnDemandResults()
                .openMovie()
                .watchMovie()
                .openControls()
                .verifyMoviePlays()
                .nav.homeButton.click();
        Verifications.addVerification("Opened OnDemand movie.", true);
        Logger.screenshot("OnDemandMovie");
    }
}
