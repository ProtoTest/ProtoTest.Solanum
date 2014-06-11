package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;

import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

/**
 * Created by Brian on 6/4/2014.
 */
public class KindleFireParentalControls extends EggplantTestBase{
    @Test
    public void clearAllBlockedContentAndPlayMovie(){
        new DeviceMain()
                .goHome()
                .openDishAnywhereHome()
                .goBackToDeviceScreen()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openSettings()
                .openParentalControls("1111")
                .clearMovieBlocks()
                .clearTVBlocks()
                .openOnDemand()
                .openMovies()
                .openMovie("Parkland")
                .watchMovie()
                .verifyMoviePlays();
        Verifications.assertVerifications();

    }

    @Test
    public void setAllContentBlockedAndPlayMovie(){
        new DeviceMain()
                .goHome()
                .openDishAnywhereHome()
                .goBackToDeviceScreen()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openSettings()
                .openParentalControls("1111")
                .setMovieGBlocked()
                .setTVYBlocked()
                .openOnDemand()
                .openMovies()
                .openProtectedMovie("Parkland")
                .enterPasscode("1111")
                .watchMovie()
                .verifyMoviePlays();
        Verifications.assertVerifications();

    }
}
