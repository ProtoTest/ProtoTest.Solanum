package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.Logger;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

//
//Tests for proper functionality of Video content's Digital Rights Management
//

public class GalaxyS5VideoDrm extends GalaxyS5TestBase {

    @Test
    public void watchNagraMovie() {
        Logger.info("Beginning Test: Watch Nagra Movie.");
        RadishScraper radishScraper = new RadishScraper();
        radishScraper.getMovies();
        String movie = radishScraper.findMovieWithDrm("nagra");

        watchMovie(movie);
        Verifications.addVerification("Watched onDemand nagra movie.", true);
    }

    @Test
    public void watchWidevineMovie() {
        Logger.info("Beginning Test: Watch Widevine Movie.");
        RadishScraper radishScraper = new RadishScraper();
        radishScraper.getMovies();
        String movie = radishScraper.findMovieWithDrm("widevine");

        watchMovie(movie);
        Verifications.addVerification("Watched onDemand widevine movie.", true);
    }

    //Not a standalone test - method used by above tests
    private void watchMovie(String movie) {
        new DishAnywhereHome()
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
