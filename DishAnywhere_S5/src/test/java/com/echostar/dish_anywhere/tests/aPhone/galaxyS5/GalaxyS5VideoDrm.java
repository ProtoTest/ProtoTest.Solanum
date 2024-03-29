package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SolanumRetryAnalyzer;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

//
//Tests for proper functionality of Video content's Digital Rights Management
//

public class GalaxyS5VideoDrm extends GalaxyS5TestBase {

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void watchNagraMovie() {
        Logger.info("BEGINNING TEST: WATCH NAGRA MOVIE.");
        RadishScraper radishScraper = new RadishScraper();
        radishScraper.getMovies();
        String movie = radishScraper.findMovieWithDrm("nagra");
        watchMovie(RadishScraper.getShortName(movie, 25));
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void watchWidevineMovie() {
        Logger.info("BEGINNING TEST: WATCH WIDEVINE MOVIE.");
        RadishScraper radishScraper = new RadishScraper();
        radishScraper.getMovies();
        String movie = RadishScraper.getShortName(radishScraper.findMovieWithDrm("widevine"),25);

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
                .verifyMoviePlays();
        Logger.screenshot("OnDemandMovie");
    }

}
