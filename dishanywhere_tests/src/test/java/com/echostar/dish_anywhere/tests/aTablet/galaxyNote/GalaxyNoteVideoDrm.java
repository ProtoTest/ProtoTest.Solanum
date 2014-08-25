package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DishAnywhereHome;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SolanumRetryAnalyzer;
import org.testng.annotations.Test;

// DishAnywhere API Tests - Galaxy Note (Android Tablet)

public class GalaxyNoteVideoDrm extends GalaxyNoteTestBase {

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void watchNagraMovie() {
        Logger.info("Beginning Test: Watch Nagra Movie.");
        RadishScraper radishScraper = new RadishScraper();
        radishScraper.getMovies();
        String movie = radishScraper.findMovieWithDrm("nagra");
        watchMovie(movie);
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void watchWidevineMovie() {
        Logger.info("Beginning Test: Watch Widevine Movie.");
        RadishScraper radishScraper = new RadishScraper();
        radishScraper.getMovies();
        String movie = radishScraper.findMovieWithDrm("widevine");
        watchMovie(movie);
    }

    private void watchMovie(String movie) {
        Logger.info("User will now watch movie: (" + movie + ").");
        new DishAnywhereHome()
                .openOnDemand()
                .searchFor(movie)
                .openOnDemandResults()
                .openMovie(RadishScraper.getShortName(movie,25))
                .watchMovie()
                .openControls()
                .verifyMoviePlays()
                .goBackHome();
    }
}
