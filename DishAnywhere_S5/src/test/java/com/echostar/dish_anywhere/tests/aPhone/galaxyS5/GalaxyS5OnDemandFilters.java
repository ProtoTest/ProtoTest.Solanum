package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.Config;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SolanumRetryAnalyzer;
import com.prototest.solanum.Verifications;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//
//Tests for proper functionality of "On Demand" content, "Filters" sub-section
//

public class GalaxyS5OnDemandFilters extends GalaxyS5TestBase {

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
        Logger.info("BEGINNING TEST: ON DEMAND FILTERS.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getFilteredMovies(filter, RadishScraper.Device.android_phone, 19);

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(RadishScraper.getShortName(movies.get(i).get("franchiseName"),25));
        }
        new DishAnywhereHome()
                .openOnDemand()
                .openBlockbuster()
                .openMovies()
                .openFilters()
                .selectFilter(filter)
                .done()
                .verifyTitlesPresent(movieTitles);
    }

}