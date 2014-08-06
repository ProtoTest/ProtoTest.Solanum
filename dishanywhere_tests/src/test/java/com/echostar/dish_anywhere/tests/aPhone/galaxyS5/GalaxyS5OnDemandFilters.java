package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.Logger;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//
//Tests for proper functionality of "On Demand" content, "Filters" sub-section
//

public class GalaxyS5OnDemandFilters extends GalaxyS5TestBase {

    private final int MOVIES_TO_TEST = 6;

    @Test
    public void onDemandFilters() {
        Logger.info("Beginning Test: On Demand Filters.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getFilteredMovies("comedy", RadishScraper.Device.android_phone, 19);

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(RadishScraper.getShortName(movies.get(i).get("franchiseName"),25));
        }
        new DishAnywhereHome()
                .goHome()
                .openOnDemand()
                .openBlockbuster()
                .openMovies()
                .openFilters()
                .selectFilter("comedy")
                .done()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();
    }

}
