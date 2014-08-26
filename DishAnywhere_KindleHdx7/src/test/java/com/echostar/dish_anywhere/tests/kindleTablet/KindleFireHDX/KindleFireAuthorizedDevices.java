package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DishAnywhereHome;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SolanumRetryAnalyzer;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 */
public class KindleFireAuthorizedDevices extends  KindleTestBase {
    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void movieCategory() {
        Logger.info("Starting Kindle Authorized Device test");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_phone, 19);

        String movieName = movies.get(0).get("franchiseName");

        new DishAnywhereHome()
                .openSettings()
                .openAuthorizedDevices()
                .deAuthorizeThisDevice()
                .openOnDemand()
                .searchFor(movieName)
                .openOnDemandResults()
                .openMovie(movieName)
                .watchMovie()
                .verifyDeauthorizationMessageDisplays()

                .resetApp()
                .openSettings()
                .openAuthorizedDevices()
                .authorizeThisDevice()
                .openOnDemand()
                .searchFor(movieName)
                .openOnDemandResults()
                .openMovie(movieName)
                .watchMovie()
                .verifyMoviePlays()
                .goHome();


    }
}
