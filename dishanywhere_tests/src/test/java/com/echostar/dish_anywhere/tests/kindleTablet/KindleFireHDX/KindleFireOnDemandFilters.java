package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DishAnywhereHome;
import com.prototest.solanum.Config;
import com.prototest.solanum.Logger;
import com.prototest.solanum.Verifications;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// DishAnywhere UI Tests - Galaxy Note 10.1 (Android Tablet)

@Test()
public class KindleFireOnDemandFilters extends KindleTestBase {


    private static final int MOVIES_TO_TEST = 10;

    @DataProvider(name = "filter")
    public Object[][] filter() {
        String[] rawfilters = Config.getTestProp("dishFiltersToTest").trim().split("\\s*,\\s*");
        Object[][] filters = new Object[rawfilters.length][1];
        for (int i = 0; i < rawfilters.length; i++) {
                filters[i][0] = rawfilters[i];
        }
        return filters;
    }

    @Test(dataProvider = "filter")
    public void onDemandTest(String filter) {
        Logger.info("Beginning test for filter " + filter);
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getFilteredMovies(filter, RadishScraper.Device.android_tablet, 30);

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(i).get("franchiseName"));
        }
        new DishAnywhereHome()
                .openBlockbuster()
                .openFilters()
                .sortByTitle()
                .selectFilter(filter)
                .done()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();



    }

}
