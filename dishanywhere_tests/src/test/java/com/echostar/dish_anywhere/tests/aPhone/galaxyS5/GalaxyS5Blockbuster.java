package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.Config;
import com.prototest.solanum.Logger;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Brian on 6/4/2014.
 */
public class GalaxyS5Blockbuster extends GalaxyS5TestBase {

    private final int MOVIES_TO_TEST = 6;

    @Test
    public void movieCategory(){

        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getBlockbusterMoviesCategory();

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(i).get("franchiseName"));
        }
        new DishAnywhereHome()
                .openDishAnywhereHome()
                .openOnDemand()
                .openBlockbuster()
                .openMovies()
                .verifyTitlesPresent(movieTitles);
    }

    @Test
    public void tvShowsCategory(){

        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getBlockbusterShowsCategory();

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(i).get("franchiseName"));
        }
        new DishAnywhereHome()
                .openDishAnywhereHome()
                .openOnDemand()
                .openBlockbuster()
                .openMovies()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();
    }

    @Test
    public void kidsMovieCategory(){

        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getBlockbusterKidsMoviesCategory();

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(i).get("franchiseName"));
        }
        new DishAnywhereHome()
                .openDishAnywhereHome()
                .openOnDemand()
                .openBlockbuster()
                .openTVShows()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();
    }

    @Test
    public void kidsTvShowsCategory(){

        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getBlockbusterKidsShowsCategory();

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(i).get("franchiseName"));
        }
        new DishAnywhereHome()
                .openDishAnywhereHome()
                .openOnDemand()
                .openBlockbuster()
                .openMovies()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();
    }

}
