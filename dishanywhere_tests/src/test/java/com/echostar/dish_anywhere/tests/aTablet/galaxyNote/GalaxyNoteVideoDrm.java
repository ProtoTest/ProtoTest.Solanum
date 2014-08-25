package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DishAnywhereHome;
import com.prototest.solanum.SolanumRetryAnalyzer;
import org.testng.annotations.Test;

// DishAnywhere API Tests - Galaxy Note (Android Tablet)

public class GalaxyNoteVideoDrm extends GalaxyNoteTestBase {

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void watchNagraMovie() {
        RadishScraper radishScraper = new RadishScraper();
        radishScraper.getMovies();
        String movie = radishScraper.findMovieWithDrm("nagra");
        watchMovie(movie);
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void watchWidevineMovie() {
        RadishScraper radishScraper = new RadishScraper();
        radishScraper.getMovies();
        String movie = radishScraper.findMovieWithDrm("widevine");
        watchMovie(movie);
    }

    private void watchMovie(String movie) {
        new DishAnywhereHome()
                .openOnDemand()
                .searchFor(movie)
                .openOnDemandResults()
                .openMovie(RadishScraper.getShortName(movie,25))
                .watchMovie()
                .openControls()
                .verifyMoviePlays().goBackHome();
    }
}
