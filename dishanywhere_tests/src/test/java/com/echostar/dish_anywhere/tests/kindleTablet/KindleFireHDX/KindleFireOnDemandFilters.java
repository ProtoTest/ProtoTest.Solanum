package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DishAnywhereHome;
import com.prototest.solanum.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// DishAnywhere UI Tests - Galaxy Note 10.1 (Android Tablet)

public class KindleFireOnDemandFilters extends EggplantTestBase {


    private static final int MOVIES_TO_TEST = 2;

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
        Logger.info("Beginning test for filter " + filter);
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getFilteredMovies(urlParam, RadishScraper.Device.android_tablet, 30);

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(i).get("franchiseName"));
        }
        new DishAnywhereHome()
                .openOnDemand()
                .openMovies()
                .openFilter()
                .sortByTitle()
                .selectFilter(filter)
                .done()
                .verifyTitlesPresent(movieTitles);
        //Verifications.assertVerifications();



    }

}
