package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DishAnywhereHome;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Brian on 6/4/2014.
 */
public class GalaxyNoteOnDemandCategory extends GalaxyNoteTestBase {

    private final int MOVIES_TO_TEST = 6;

    @Test
    public void movieCategory(){

        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_tablet, 30);

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(i).get("franchiseName"));
        }
        new DishAnywhereHome()
                .openOnDemand()
                .clearSearch()
                .openMovies()
                .openFilter()
                .sortByTitle()
                .done()
                .verifyTitlesPresent(movieTitles);

    }

    @Test
    public void featuredCategory(){


        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getOnDemandFeatured(RadishScraper.Device.android_tablet, 30);

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(i).get("franchiseName"));
        }

        new DishAnywhereHome()
                .openOnDemand()
                .clearSearch()
                .openFeatured()
                .openFilter()
                .sortByTitle()
                .done()
                .verifyTitlesPresent(movieTitles);

    }

    @Test
    public void familyCategory(){


        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getFamilyCategory(RadishScraper.Device.android_tablet, 30);

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(i).get("franchiseName"));
        }

        new DishAnywhereHome()
                .openOnDemand()
                .clearSearch()
                .openFamily()
                .openFilter()
                .sortByTitle()
                .done()
                .verifyTitlesPresent(movieTitles);

    }

    @Test
    public void tvShowsCategory(){


        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getShowsCategory(RadishScraper.Device.android_tablet, 30);

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(i).get("franchiseName"));
        }

        new DishAnywhereHome()
                .openOnDemand()
                .clearSearch()
                .openTVShows()
                .openFilter()
                .sortByTitle()
                .done()
                .verifyTitlesPresent(movieTitles);

    }

    @Test
    public void networksCategory(){

        List<String> movieTitles = Arrays.asList("BabyFirstTV", "Cinemax", "Content Media", "Cookie Jar", "Echo Bridge", "Encore");


        new DishAnywhereHome()
                .openOnDemand()
                .clearSearch()
                .openNetworks()
                .verifyTitlesPresent(movieTitles);

    }
}
