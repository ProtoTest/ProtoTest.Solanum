package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;


import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.*;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by Brian on 6/4/2014.
 */
public class GalaxyS5AuthorizedDevices extends GalaxyS5TestBase {
    @Test
    public void movieCategory(){

        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory();

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
