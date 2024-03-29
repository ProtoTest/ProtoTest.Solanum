package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DishAnywhereHome;
import com.prototest.solanum.Config;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SolanumRetryAnalyzer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class GalaxyNoteOnDemandFilters extends GalaxyNoteTestBase {

    private final int MOVIES_TO_TEST = 6;

    @DataProvider(name = "filter")
    public Object[][] filter() {
        String[] rawfilters = Config.getTestProp("dishFiltersToTest").trim().split("\\s*,\\s*");
        Object[][] filters = new Object[rawfilters.length][];
        for (int i = 0; i < rawfilters.length; i++) {
            String[] filterTuple = rawfilters[i].split(";");
            filters[i] = filterTuple;
        }
        return filters;
    }

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class, dataProvider = "filter")
    public void onDemandFilters(String filter, String urlParam) {
        Logger.info("BEGINNING TEST: ON DEMAND FILTERS CATEGORY.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getFilteredMovies(urlParam, RadishScraper.Device.android_tablet, 30);
        List<String> movieTitles = radishScraper.extractShortTitles(movies, MOVIES_TO_TEST, 40);
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
