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

public class GalaxyNoteParentalControls extends GalaxyNoteTestBase {

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void clearAllBlockedContentAndPlayMovie(){
        Logger.info("BEGINNING TEST: PARENTAL CONTROLS - CLEAR ALL BLOCKED CONTENT AND PLAY MOVIE.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_tablet, 30);
        String movieName = movies.get(1).get("franchiseName");
        new DishAnywhereHome()
                .openOnDemand()
                .searchFor(movieName)
                .openOnDemandResults()
                .openMovie(movieName)
                .watchMovie()
                .verifyMoviePlays()
                .goBackHome();
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void setAllContentBlockedAndPlayMovie(){
        Logger.info("BEGINNING TEST: PARENTAL CONTROLS - SET ALL CONTENT TO BLOCKED AND PLAY MOVIE.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_tablet, 30);
        String movieName = movies.get(1).get("franchiseName");
        new DishAnywhereHome()
                .openSettings()
                .openParentalControls(Config.getTestProp("dishAnywherePassCode"))
                .setMovieGBlocked()
                .setTVYBlocked()
                .save()
                .openOnDemand()
                .searchFor(movieName)
                .openOnDemandResults()
                .openProtectedMovie(movieName, Config.getTestProp("dishAnywherePassCode"))
                .watchMovie()
                .verifyMoviePlays()
                .goBackHome();
    }

}
