package com.echostar.dish_anywhere.tests.aphone.galaxyS5;


import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import org.testng.annotations.Test;

/**
 * Created by Brian on 6/4/2014.
 */
public class GalaxyS5AuthorizedDevices extends EggplantTestBase {
    @Test
    public void movieCategory(){

        new DeviceMain()
                .goHome()
                .openDishAnywhereApp()
                .exitPlayerIfOpen()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
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
    }
}
