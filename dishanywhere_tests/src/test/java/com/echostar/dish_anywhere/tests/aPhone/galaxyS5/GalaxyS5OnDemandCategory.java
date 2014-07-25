package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.Logger;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//
//Tests for proper functionality of "On Demand" content, "Categories" sub-section
//

public class GalaxyS5OnDemandCategory extends GalaxyS5TestBase {

    private final int MOVIES_TO_TEST = 6;

    @Test
    public void moviesCategory(){
        Logger.info("Beginning Test: On Demand Movies Category.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_phone, 19);
        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);
        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(RadishScraper.getShortName(movies.get(i).get("franchiseName"),25));
        }

        new DishAnywhereHome()
                .goHome()
                .openOnDemand()
                .openMovies()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();
    }

    @Test
    public void featuredCategory(){
        Logger.info("Beginning Test: On Demand Featured Category.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getOnDemandFeatured(RadishScraper.Device.android_phone, 19);
        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);
        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(RadishScraper.getShortName(movies.get(i).get("franchiseName"),25));
        }

        new DishAnywhereHome()
                .goHome()
                .openOnDemand()
                .openFeatured()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();
    }

    @Test
    public void familyCategory(){
        Logger.info("Beginning Test: On Demand Family Category.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getFamilyCategory(RadishScraper.Device.android_phone, 19);
        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);
        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(RadishScraper.getShortName(movies.get(i).get("franchiseName"),25));
        }

        new DishAnywhereHome()
                .goHome()
                .openOnDemand()
                .openFamily()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();
    }

    @Test
    public void tvShowsCategory(){
        Logger.info("On Demand TV Shows Category.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getShowsCategory(RadishScraper.Device.android_phone, 19);
        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);
        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(RadishScraper.getShortName(movies.get(i).get("franchiseName"),25));
        }

        new DishAnywhereHome()
                .goHome()
                .openOnDemand()
                .openTvShows()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();
    }

    @Test
    public void networksCategory(){
        Logger.info("Beginning Test: On Demand Networks Category.");
        List<String> movieTitles = Arrays.asList("MGM", "Starz", "Hallmark Channel", "Encore", "HBO");

        new DishAnywhereHome()
                .goHome()
                .openOnDemand()
                .openNetworks()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();
    }

}
