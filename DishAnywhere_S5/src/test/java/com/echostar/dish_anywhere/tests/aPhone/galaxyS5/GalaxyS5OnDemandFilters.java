package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.Config;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SolanumRetryAnalyzer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class GalaxyS5OnDemandFilters extends GalaxyS5TestBase {

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
        Logger.info("BEGINNING TEST: ON DEMAND FILTERS.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getFilteredMovies(urlParam, RadishScraper.Device.android_phone, 19);
        List<String> movieTitles = radishScraper.extractShortTitles(movies, MOVIES_TO_TEST, 40);
        new DishAnywhereHome()
                .openOnDemand()
                .openMovies()
                .openFilters()
                .selectFilter(filter)
                .done()
                .verifyTitlesPresent(movieTitles);
    }

}
