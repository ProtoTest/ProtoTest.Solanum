package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DishAnywhereHome;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SolanumRetryAnalyzer;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class GalaxyNoteParentalControls extends EggplantTestBase {

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void clearAllBlockedContentAndPlayMovie(){
        Logger.info("Beginning Test: Parental Controls - Clear All Blocked Content And Play Movie.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_tablet, 30);
        String movieName = movies.get(1).get("franchiseName");
        new DishAnywhereHome()
                .openOnDemand()
                .openMovies()
                .openFilter()
                .sortByTitle()
                .done()
                .openMovie(movieName)
                .watchMovie()
                .verifyMoviePlays()
                .goBackHome();
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void setAllContentBlockedAndPlayMovie(){
        Logger.info("Beginning Test: Parental Controls - Set All Content to Blocked And Play Movie.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_tablet, 30);
        String movieName = movies.get(1).get("franchiseName");
        new DishAnywhereHome()
                .openOnDemand()
                .openMovies()
                .openFilter()
                .sortByTitle()
                .done()
                .openProtectedMovie(movieName)
                .enterPasscode("1111")
                .watchMovie()
                .verifyMoviePlays().goBackHome();
    }

}
