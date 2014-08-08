package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DishAnywhereHome;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// DishAnywhere UI Tests - Galaxy Note 10.1 (Android Tablet)

@Test()
public class KindleFireOnDemandFilters extends KindleTestBase {


    private static final int MOVIES_TO_TEST = 10;

    @Test
    public void onDemandTest() {
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getFilteredMovies("comedy", RadishScraper.Device.android_tablet, 30);

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(i).get("franchiseName"));
        }
        new DishAnywhereHome()
                .openBlockbuster()
                .openFilters()
                .selectFilter("comedy")
                .done()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();



    }

}
