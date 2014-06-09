package com.echostar.dish_anywhere.tests.aphone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceNavigation;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Brian on 6/4/2014.
 */
public class GalaxyS5OnDemandCategory extends GalaxyS5TestBase {

    private final int MOVIES_TO_TEST = 6;
    @Test
    public void movieCategory(){

        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory();

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(0).get("franchiseName"));
        }
        new DishAnywhereHome()
                .openDishAnywhereHome()
                .openOnDemand()
                .openMovies()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();
    }

    @Test
    public void featuredCategory(){

        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getOnDemandFeatured();

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(0).get("franchiseName"));
        }

        new DishAnywhereHome()
                .openDishAnywhereHome()
                .openOnDemand()
                .openFeatured()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();

    }

    @Test
    public void familyCategory(){
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getFamilyCategory();

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(0).get("franchiseName"));
        }

        new DishAnywhereHome()
                .openDishAnywhereHome()
                .openOnDemand()
                .openFamily()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();

    }

    @Test
    public void tvShowsCategory(){

        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getShowsCategory();

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(0).get("franchiseName"));
        }

        new DishAnywhereHome()
                .openDishAnywhereHome()
                .openOnDemand()
                .openTvShows()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();

    }

    @Test
    public void networksCategory(){

        List<String> movieTitles = Arrays.asList("MGM", "Starz", "Hallmark Channel", "Encore", "HBO");

        new DishAnywhereHome()
                .openDishAnywhereHome()
                .openOnDemand()
                .openNetworks()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();

    }

}