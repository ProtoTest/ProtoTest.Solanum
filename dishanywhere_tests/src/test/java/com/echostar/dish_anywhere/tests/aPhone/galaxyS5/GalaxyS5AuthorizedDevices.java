package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.Logger;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

//
//Tests for proper functionality when devices are de-authorized and then re-authorized
//

public class GalaxyS5AuthorizedDevices extends GalaxyS5TestBase {

    @Test
    public void deauthAndReauth(){
        Logger.info("Beginning Test: Deauthorize and Reauthorize This Device.");
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_phone, 19);
        String movieName = movies.get(0).get("franchiseName");

        new DishAnywhereHome()
                .openDishAnywhereHome()
                .openSettings()
                .openSettingsRoot()
                .openAuthorizedDevices()
                .deAuthorizeThisDevice()
                .openOnDemand()
                .goToOnDemandRoot()
                .openMovies()
                .openMovie(movieName)
                .watchMovie()
                .verifyDeauthorizationMessageDisplays()
                .exitPlayerIfOpen()
                .openSettings()
                .openSettingsRoot()
                .openAuthorizedDevices()
                .authorizeThisDevice()
                .openOnDemand()
                .goToOnDemandRoot()
                .openMovies()
                .openMovie(movieName)
                .watchMovie()
                .verifyMoviePlays();
    }

}
