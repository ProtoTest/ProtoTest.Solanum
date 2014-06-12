package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.*;
import org.testng.annotations.Test;

// DishAnywhere API Tests - GalaxyS5 (Android Phone)

public class GalaxyS5VideoDrm extends GalaxyS5TestBase {


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
