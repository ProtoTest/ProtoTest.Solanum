package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DishAnywhereHome;
import com.prototest.solanum.Config;
import com.prototest.solanum.SolanumRetryAnalyzer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// DishAnywhere UI Tests - Galaxy Note 10.1 (Android Tablet)

@Test(retryAnalyzer = SolanumRetryAnalyzer.class)
public class GalaxyNoteOnDemandFilters extends GalaxyNoteTestBase {

    private final int MOVIES_TO_TEST = 6;

    @DataProvider(name = "filter")
    public Object[][] filter() {
        String[] rawfilters = Config.getTestProp("dishFiltersToTest").trim().split("\\s*,\\s*");
        Object[][] filters = new Object[rawfilters.length][1];
        for (int i = 0; i < rawfilters.length; i++) {
            filters[i][0] = rawfilters[i];
        }
        return filters;
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class, dataProvider = "filter")
    public void onDemandFilters(String filter) {
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getFilteredMovies(filter, RadishScraper.Device.android_tablet, 30);

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(i).get("franchiseName"));
        }
        new DishAnywhereHome()
                .openOnDemand()
                .openMovies()
                .openFilter()
                .selectFilter(filter)
                .sortByTitle()
                .done()
                .verifyTitlesPresent(movieTitles);



    }

}
