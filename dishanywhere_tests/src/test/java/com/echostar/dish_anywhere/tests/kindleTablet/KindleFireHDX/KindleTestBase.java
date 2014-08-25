package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;

import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DeviceMain;
import com.prototest.solanum.*;
import org.testng.annotations.AfterMethod;

/**
 */
public class KindleTestBase extends EggplantTestBase {
    EggplantElement crashText = new EggplantElement(By.Text("Anywhere has stopped.", TextOption.waitFor(10)));
    EggplantElement okButton = new EggplantElement(By.Text("OK"));

    private void handleAppCrash() {
        if (crashText.isPresent()) {
            okButton.click();
        }
    }

    @Override
    public void initializeApp() {
        handleAppCrash();
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
    }

    @AfterMethod
    public void uninitializeApp() {
        new DeviceMain().goHome();
    }
}
