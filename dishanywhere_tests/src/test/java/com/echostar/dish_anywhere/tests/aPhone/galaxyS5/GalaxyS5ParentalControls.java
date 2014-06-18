package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by Brian on 6/4/2014.
 */
public class GalaxyS5ParentalControls extends GalaxyS5TestBase {
    @Test
    public void clearAllBlockedContentAndPlayMovie(){

        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_phone, 19);

        String movieName = movies.get(0).get("franchiseName");
        new DishAnywhereHome()
                .openSettings()
                .openParentalControls("1111")
                .clearMovieBlocks()
                .clearTVBlocks()
                .openOnDemand()
                .openMovies()
                .openMovie(movieName)
                .watchMovie()
                .verifyMoviePlays();

    }

    @Test
    public void setAllContentBlockedAndPlayMovie(){


        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_phone, 19);

        String movieName = movies.get(0).get("franchiseName");

        new DishAnywhereHome()
                .openSettings()
                .openParentalControls("1111")
                .setMovieGBlocked()
                .setTVYBlocked()
                .openOnDemand()
                .openMovies()
                .openProtectedMovie(movieName)
                .enterPasscode("1111")
                .watchMovie()
                .verifyMoviePlays();
        Verifications.assertVerifications();

    }
}
