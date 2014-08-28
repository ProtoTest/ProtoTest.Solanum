package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DishAnywhereHome;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SolanumRetryAnalyzer;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

public class KindleFireVideoDrm extends KindleTestBase {


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
                .goHome()
                .openOnDemand()
                .searchFor(movie)
                .openOnDemandResults()
                .openMovie(movie)
                .watchMovie()
                .openControls()
                .verifyMoviePlays();
                EggplantTestBase.driver.PressHomeButton();
        Verifications.addVerification("Opened OnDemand movie.", true);
        Logger.screenshot("OnDemandMovie");
    }

}
