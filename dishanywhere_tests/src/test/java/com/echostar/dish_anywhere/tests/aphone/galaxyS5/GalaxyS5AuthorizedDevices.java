package com.echostar.dish_anywhere.tests.aphone.galaxyS5;


import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.*;
import org.testng.annotations.Test;

/**
 * Created by Brian on 6/4/2014.
 */
public class GalaxyS5AuthorizedDevices extends GalaxyS5TestBase {
    @Test
    public void movieCategory(){

        new DishAnywhereHome()
                .openDishAnywhereHome()
                .openSettings()
                .openSettingsRoot()
                .openAuthorizedDevices()
                .deAuthorizeThisDevice()
                .openOnDemand()
                .goToOnDemandRoot()
                .openMovies()
                .openMovie("10 Years")
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
                .openMovie("10 Years")
                .watchMovie()
                .verifyMoviePlays();
        Verifications.assertVerifications();

    }
}
