package com.echostar.dish_anywhere.tests.iOSDevice.iPad;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad.DishAnywhereHome;
import com.prototest.solanum.Config;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by Brian on 6/4/2014.
 */
public class iPadParentalControls extends iPadTestBase {
    @Test
    public void clearAllBlockedContentAndPlayMovie(){

        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_tablet, 30);

        String movieName = movies.get(1).get("franchiseName");
        new DishAnywhereHome()
                .openSettings()
                .openParentalControls("1111")
                .clearMovieBlocks()
                .clearTVBlocks()
                .openOnDemand()
                .openMovies()
                .openFilter()
                .sortByTitle()
                .done()
                .openMovie(movieName)
                .watchMovie()
                .verifyMoviePlays();
        Verifications.assertVerifications();

    }

    @Test
    public void setAllContentBlockedAndPlayMovie(){

        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_tablet, 30);

        String movieName = movies.get(1).get("franchiseName");
        new DeviceMain()
                .goHome()
                .killApp()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openSettings()
                .openParentalControls("1111")
                .setMovieGBlocked()
                .setTVYBlocked()
                .openOnDemand()
                .openMovies()
                .openFilter()
                .sortByTitle()
                .done()
                .openProtectedMovie(movieName)
                .enterPasscode("1111")
                .watchMovie()
                .verifyMoviePlays();
        Verifications.assertVerifications();

    }
}
