package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;

import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Logger;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

/**
 */
public class KindleTestBase extends EggplantTestBase {

    // Only initialize if this alreadyInitialized is false.
    // This isn't thread safe, but the expected use case is single threaded execution on one Kindle device.

//    static boolean alreadyInitialized = false;

    @BeforeMethod
    public void clearAppState() {
        // If the app ever crashes, the app should be initialized even if alreadyInitialized is true.
//        Reporter.setCurrentTestResult(null);
//        if (!alreadyInitialized /* || isCrashed() */) {
            /*
            if (isCrashed()) {
                clearCrash();
            }
             */
            Logger.info("Setting up app state");
            new DeviceMain()
                    .resetApp()
                    .logOutIfLoggedIn()
                    .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                    .openSettings()
                    .openAuthorizedDevices()
                    .authorizeThisDevice()
                    .openParentalControls(Config.getTestProp("dishAnywherePassCode"))
                    .clearMovieBlocks()
                    .clearTVBlocks()
                    .save()
                    .openGuide();
//            alreadyInitialized = true;
//        } else {
//            Logger.info("KindleTestBase already initialized; not re-running setup");
//            new DeviceMain()
//                    .goHome()
//                    .openSettings()
//                    .openParentalControls(Config.getTestProp("dishAnywherePassCode"))
//                    .clearMovieBlocks()
//                    .clearTVBlocks()
//                    .save();
//        }
    }

    @AfterMethod
    public void uninitializeApp() {
        // Clear out the screen stack
//        new DeviceMain().resetApp();
        //new DeviceMain().goHome().goHome();
    }
}
