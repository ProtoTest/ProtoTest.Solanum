package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DishAnywhereHome;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SolanumRetryAnalyzer;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GalaxyNoteOnDemandCategory extends GalaxyNoteTestBase {

    private final int MOVIES_TO_TEST = 6;

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void onDemandMovieCategory(){
        Logger.info("BEGINNING TEST: ON DEMAND MOVIE CATEGORY.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_tablet, 30);
        List<String> movieTitles = radishScraper.extractShortTitles(movies, MOVIES_TO_TEST, 40);
        new DishAnywhereHome()
                .openOnDemand()
                .clearSearch()
                .openMovies()
                .openFilter()
                .sortByTitle()
                .done()
                .verifyTitlesPresent(movieTitles);
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void onDemandFeaturedCategory(){
        Logger.info("BEGINNING TEST: ON DEMAND FEATURED CATEGORY.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getOnDemandFeatured(RadishScraper.Device.android_tablet, 30);
        List<String> movieTitles = radishScraper.extractShortTitles(movies, MOVIES_TO_TEST, 40);
        new DishAnywhereHome()
                .openOnDemand()
                .clearSearch()
                .openFeatured()
                .verifyTitlesPresent(movieTitles);
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void onDemandFamilyCategory(){
        Logger.info("BEGINNING TEST: ON DEMAND FAMILY CATEGORY.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getFamilyCategory(RadishScraper.Device.android_tablet, 30);
        List<String> movieTitles = radishScraper.extractShortTitles(movies, MOVIES_TO_TEST, 40);
        new DishAnywhereHome()
                .openOnDemand()
                .clearSearch()
                .openFamily()
                .openFilter()
                .sortByTitle()
                .done()
                .verifyTitlesPresent(movieTitles);
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void onDemandTvShowsCategory(){
        Logger.info("BEGINNING TEST: ON DEMAND TV SHOWS CATEGORY.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getShowsCategory(RadishScraper.Device.android_tablet, 30);
        List<String> movieTitles = radishScraper.extractShortTitles(movies, MOVIES_TO_TEST, 40);
        new DishAnywhereHome()
                .openOnDemand()
                .clearSearch()
                .openTVShows()
                .openFilter()
                .sortByTitle()
                .done()
                .verifyTitlesPresent(movieTitles);
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void onDemandNetworksCategory(){
        Logger.info("BEGINNING TEST: ON DEMAND MOVIE CATEGORY.");
        List<String> movieTitles = Arrays.asList("BabyFirstTV", "Cinemax", "Content Media", "Cookie Jar", "Echo Bridge", "Encore");
        new DishAnywhereHome()
                .openOnDemand()
                .clearSearch()
                .openNetworks()
                .verifyTitlesPresent(movieTitles);
    }

}
