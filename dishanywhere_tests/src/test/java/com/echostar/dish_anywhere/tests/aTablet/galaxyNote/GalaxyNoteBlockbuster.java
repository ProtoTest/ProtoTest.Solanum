package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DishAnywhereHome;
import com.prototest.solanum.SolanumRetryAnalyzer;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GalaxyNoteBlockbuster extends GalaxyNoteTestBase {

    private final int MOVIES_TO_TEST = 6;

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void movieCategory(){
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getBlockbusterMoviesCategory(RadishScraper.Device.android_tablet, 30);
        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);
        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(RadishScraper.getShortName(movies.get(i).get("franchiseName"),25));
        }
        new DishAnywhereHome()
                .goToDeviceHomeAndEnterApp()
                .openBlockbuster()
                .openMovies()
                .openFilter()
                .sortByTitle()
                .done()
                .verifyTitlesPresent(movieTitles);
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void tvShowsCategory(){
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getBlockbusterShowsCategory(RadishScraper.Device.android_tablet, 30);
        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);
        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(RadishScraper.getShortName(movies.get(i).get("franchiseName"),25));
        }
        new DishAnywhereHome()
                .goToDeviceHomeAndEnterApp()
                .openBlockbuster()
                .openTVShows()
                .openFilter()
                .sortByTitle()
                .done()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void kidsMovieCategory(){
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getBlockbusterKidsMoviesCategory(RadishScraper.Device.android_tablet, 30);
        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);
        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(RadishScraper.getShortName(movies.get(i).get("franchiseName"),25));
        }
        new DishAnywhereHome()
                .openBlockbuster()
                .openKidsMovies()
                .openFilter()
                .sortByTitle()
                .done()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void kidsTvShowsCategory(){
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getBlockbusterKidsShowsCategory(RadishScraper.Device.android_tablet, 30);
        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);
        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(RadishScraper.getShortName(movies.get(i).get("franchiseName"),25));
        }
        new DishAnywhereHome()
                .goToDeviceHomeAndEnterApp()
                .openBlockbuster()
                .openKidsTVShows()
                .openFilter()
                .sortByTitle()
                .done()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();
    }
}
