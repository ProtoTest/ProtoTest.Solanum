package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;
import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.echostar.dish_anywhere.tests.aPhone.galaxyS5.GalaxyS5TestBase;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// DishAnywhere UI Tests - Galaxy Note 10.1 (Android Tablet)

@Test()
public class GalaxyS5OnDemandFilters extends GalaxyS5TestBase {

    private final int MOVIES_TO_TEST = 6;

    @Test
    public void onDemandTest() {
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory();

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(i).get("franchiseName"));
        }
        new DishAnywhereHome()
                .openDishAnywhereHome()
                .openOnDemand()
                .openBlockbuster()
                .openMovies()
                .openFilters()
                .selectFilter("Comedy")
                .done()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();



    }

}