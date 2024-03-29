package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SolanumRetryAnalyzer;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GalaxyS5OnDemandCategory extends GalaxyS5TestBase {

    private final int MOVIES_TO_TEST = 6;

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void moviesCategory(){
        Logger.info("BEGINNING TEST: ON DEMAND MOVIES CATEGORY.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_phone, 19);
        List<String> movieTitles = radishScraper.extractShortTitles(movies, MOVIES_TO_TEST, 40);
        new DishAnywhereHome()
                .openOnDemand()
                .openMovies()
                .verifyTitlesPresent(movieTitles);
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void featuredCategory(){
        Logger.info("BEGINNING TEST: ON DEMAND FEATURED CATEGORY.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getOnDemandFeatured(RadishScraper.Device.android_phone, 19);
        List<String> movieTitles = radishScraper.extractShortTitles(movies, MOVIES_TO_TEST, 40);
        new DishAnywhereHome()
                .openOnDemand()
                .openFeatured()
                .verifyTitlesPresent(movieTitles);
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void familyCategory(){
        Logger.info("BEGINNING TEST: ON DEMAND FAMILY CATEGORY.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getFamilyCategory(RadishScraper.Device.android_phone, 19);
        List<String> movieTitles = radishScraper.extractShortTitles(movies, MOVIES_TO_TEST, 40);
        new DishAnywhereHome()
                .openOnDemand()
                .openFamily()
                .verifyTitlesPresent(movieTitles);
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void tvShowsCategory(){
        Logger.info("ON DEMAND TV SHOWS CATEGORY.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getShowsCategory(RadishScraper.Device.android_phone, 19);
        List<String> movieTitles = radishScraper.extractShortTitles(movies, MOVIES_TO_TEST, 40);
        new DishAnywhereHome()
                .openOnDemand()
                .openTvShows()
                .verifyTitlesPresent(movieTitles);
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void networksCategory(){
        Logger.info("BEGINNING TEST: ON DEMAND NETWORKS CATEGORY.");
        List<String> movieTitles = Arrays.asList("MGM", "Starz", "Hallmark Channel", "Encore", "HBO");
        new DishAnywhereHome()
                .openOnDemand()
                .openNetworks()
                .verifyTitlesPresent(movieTitles);
    }

}
