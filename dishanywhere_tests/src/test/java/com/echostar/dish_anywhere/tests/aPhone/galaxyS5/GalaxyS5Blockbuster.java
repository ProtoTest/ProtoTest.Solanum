package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SolanumRetryAnalyzer;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//
//Tests for proper functionality of "Blockbuster" content section
//

public class GalaxyS5Blockbuster extends GalaxyS5TestBase {

    private final int MOVIES_TO_TEST = 6;
    private final int MAX_NAME_LENGTH = 25;

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void movieCategory(){
        Logger.info("Beginning Test: Blockbuster Movie Category.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getBlockbusterMoviesCategory(RadishScraper.Device.android_phone, 19);
        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);
        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            String name =movies.get(i).get("franchiseName");
            movieTitles.add(RadishScraper.getShortName(name,MAX_NAME_LENGTH));
        }

        new DishAnywhereHome()
                .openOnDemand()
                .openBlockbuster()
                .openMovies()
                .verifyTitlesPresent(movieTitles);
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void tvShowsCategory(){
        Logger.info("Beginning Test: Blockbuster TV Shows Category.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getBlockbusterShowsCategory(RadishScraper.Device.android_phone, 19);
        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);
        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            String name =movies.get(i).get("franchiseName");
            movieTitles.add(RadishScraper.getShortName(name,MAX_NAME_LENGTH));
        }

        new DishAnywhereHome()
                .openOnDemand()
                .openBlockbuster()
                .openTVShows()
                .verifyTitlesPresent(movieTitles);
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void kidsMovieCategory(){
        Logger.info("Beginning Test: Kids Movie Category.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getBlockbusterKidsMoviesCategory(RadishScraper.Device.android_phone, 19);
        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);
        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            String name =movies.get(i).get("franchiseName");
            movieTitles.add(RadishScraper.getShortName(name,MAX_NAME_LENGTH));
        }

        new DishAnywhereHome()
                .openOnDemand()
                .openBlockbuster()
                .openKidsMovies()
                .verifyTitlesPresent(movieTitles);
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void kidsTvShowsCategory(){
        Logger.info("Beginning Test: Kids TV Shows Category.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getBlockbusterKidsShowsCategory(RadishScraper.Device.android_phone, 19);
        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);
        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            String name =movies.get(i).get("franchiseName");
            movieTitles.add(RadishScraper.getShortName(name,MAX_NAME_LENGTH));
        }

        new DishAnywhereHome()
                .openOnDemand()
                .openBlockbuster()
                .openKidsTVShows()
                .verifyTitlesPresent(movieTitles);
    }

}
