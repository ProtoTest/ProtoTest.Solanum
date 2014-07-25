package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;

import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

/**
 */
public class KindleTestBase extends EggplantTestBase {

    @BeforeTest
    public void initializeApp() {
        new DeviceMain()
                .goHome()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openSettings()
                .openAuthorizedDevices()
                .authorizeThisDevice()
                .openParentalControls(Config.getTestProp("dishAnywherePassCode"))
                .clearMovieBlocks()
                .clearTVBlocks()
                .openGuide();
    }

    @AfterMethod
    public void uninitializeApp() {
        new DeviceMain().goHome().openDishAnywhereHome();
    }
}
