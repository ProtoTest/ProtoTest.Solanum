package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DishAnywhereHome;
import com.prototest.solanum.SolanumRetryAnalyzer;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Brian on 6/4/2014.
 */
public class KindleFireOnDemandCategory extends KindleTestBase {

    private final int MOVIES_TO_TEST = 10;

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void movieCategory(){

        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_tablet, 30);

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(i).get("franchiseName"));
        }
        new DishAnywhereHome()
                .openOnDemand()
                .openMovies()
                .openFilter()
                .sortByTitle()
                .done()
                .verifyTitlesPresent(movieTitles);

    }

    // Disable this test because there is no option to sort the movies present by title.
    // Need to rework.
    @Test(retryAnalyzer = SolanumRetryAnalyzer.class, enabled = false)
    public void featuredCategory(){


        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getOnDemandFeatured(RadishScraper.Device.android_tablet, 30);

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(i).get("franchiseName"));
        }
        new DishAnywhereHome()
                .openOnDemand()
                .openFeatured()
                .openFilter()
                .sortByTitle()
                .done()
                .verifyTitlesPresent(movieTitles);

    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void familyCategory(){


        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getFamilyCategory(RadishScraper.Device.android_tablet, 30);

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(i).get("franchiseName"));
        }
        new DishAnywhereHome()
                .openOnDemand()
                .openFamily()
                .openFilter()
                .sortByTitle()
                .done()
                .verifyTitlesPresent(movieTitles);

    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void tvShowsCategory(){


        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getShowsCategory(RadishScraper.Device.android_tablet, 30);

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(i).get("franchiseName"));
        }
        new DishAnywhereHome()
                .openOnDemand()
                .openTVShows()
                .openFilter()
                .sortByTitle()
                .done()
                .verifyTitlesPresent(movieTitles);

    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void networksCategory(){

        List<String> movieTitles = Arrays.asList("BabyFirstTV", "Cinemax", "Content Media", "Cookie Jar", "Echo Bridge", "Encore");

        new DishAnywhereHome()
                .openOnDemand()
                .openNetworks()
                .verifyTitlesPresent(movieTitles);

    }
}
