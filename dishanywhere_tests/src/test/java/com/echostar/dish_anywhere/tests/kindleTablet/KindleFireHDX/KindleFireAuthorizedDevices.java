package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DishAnywhereOnDemand;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by Brian on 6/4/2014.
 */
public class KindleFireAuthorizedDevices extends EggplantTestBase {
    @Test()
    public void movieCategory() {

        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_phone, 19);

        String movieName = movies.get(0).get("franchiseName");

        DishAnywhereOnDemand dishAnywhereOnDemand = new DeviceMain()
                .goHome()
                .openDishAnywhereHome()
                .goBackToDeviceScreen()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openSettings()
                .openAuthorizedDevices()
                .deAuthorizeThisDevice()

                .openOnDemand()

                .searchFor(movieName)
                .openOnDemandResults()
                .openMovie(movieName)
                .watchMovie()
                .verifyDeauthorizationMessageDisplays()

                .closeMovie();
        dishAnywhereOnDemand.nav.backButton.click();
        dishAnywhereOnDemand
                .openSettings()
                .openAuthorizedDevices()
                .authorizeThisDevice()
                .openOnDemand()
                .searchFor(movieName)
                .openOnDemandResults()
                .openMovie(movieName)
                .watchMovie()
                .verifyMoviePlays()
                .goBackToDeviceScreen();


    }
}
