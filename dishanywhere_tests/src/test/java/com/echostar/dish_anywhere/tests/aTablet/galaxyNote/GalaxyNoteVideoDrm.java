package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DishAnywhereHome;
import com.prototest.solanum.Logger;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

// DishAnywhere API Tests - GalaxyS5 (Android Phone)

public class GalaxyNoteVideoDrm extends GalaxyNoteTestBase {


    @Test
    public void watchNagraMovie() {
        RadishScraper radishScraper = new RadishScraper();
        radishScraper.getMovies();
        String movie = radishScraper.findMovieWithDrm("nagra");
        watchMovie(movie);

        Verifications.addVerification("Watched onDemand nagra movie.", true);
        Verifications.assertVerifications();

    }

    @Test
    public void watchWidevineMovie() {
        RadishScraper radishScraper = new RadishScraper();
        radishScraper.getMovies();
        String movie = radishScraper.findMovieWithDrm("widevine");
        watchMovie(movie);

        Verifications.addVerification("Watched onDemand widevine movie.", true);
        Verifications.assertVerifications();

    }

    private void watchMovie(String movie) {
        new DishAnywhereHome()
                .openOnDemand()
                .searchFor(movie)
                .openOnDemandResults()
                .openMovie(movie)
                .watchMovie()
                .openControls()
                .verifyMoviePlays()
                .nav.homeButton.click();
        Logger.screenshot("OnDemandMovie");

    }
}
