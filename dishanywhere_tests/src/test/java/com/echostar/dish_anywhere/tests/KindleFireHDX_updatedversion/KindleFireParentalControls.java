package com.echostar.dish_anywhere.tests.KindleFireHDX_updatedversion;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DishAnywhereHome;
import com.prototest.solanum.Config;
import com.prototest.solanum.SolanumRetryAnalyzer;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
* Created by Brian on 6/4/2014.
*/
public class KindleFireParentalControls extends KindleTestBase {
    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void clearAllBlockedContentAndPlayMovie(){

        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_phone, 19);

        String movieName = movies.get(0).get("franchiseName");
        new DishAnywhereHome()
                .openSettings()
                .openParentalControls("1111")
                .clearMovieBlocks()
                .clearTVBlocks()
                .save()
                .openOnDemand()
                .searchFor(movieName)
                .openOnDemandResults()
                .openMovie(movieName)
                .watchMovie()
                .verifyMoviePlays();
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void setAllContentBlockedAndPlayMovie(){

        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_phone, 19);

        String movieName = movies.get(0).get("franchiseName");
        new DishAnywhereHome()
                .openSettings()
                .openParentalControls("1111")
                .setMovieGBlocked()
                .setTVYBlocked()
                .save()
                .openOnDemand()
                .searchFor(movieName)

                .openProtectedMovie(movieName, Config.getTestProp("dishAnywherePassCode"))
                .watchMovie()
                .verifyMoviePlays();

    }
}
