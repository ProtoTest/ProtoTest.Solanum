package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;

import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DeviceMain;
import com.prototest.solanum.*;
import org.testng.annotations.AfterMethod;

public class KindleTestBase extends EggplantTestBase {

    private void handleAppCrash() {
        Logger.info("Handling any app crashes...");
        EggplantElement crashText = new EggplantElement(By.Text("Anywhere has stopped.", TextOption.waitFor(10)));
        EggplantElement okButton = new EggplantElement(By.Text("OK"));
        if (crashText.isPresent()) {
            okButton.click();
        }
    }

    @Override
    public void initializeApp() {
        handleAppCrash();
        Logger.info("TEST SETUP: INITIALIZING THE APP...");
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
        Logger.info("TEST SETUP: APP INITIALIZED.");
    }

    @AfterMethod
    public void uninitializeApp() {
        Logger.info("TEST TEARDOWN: RESETTING APP STATE...");
        new DeviceMain().goHome();
    }

}
