package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DeviceMain;
import com.prototest.solanum.*;
import org.testng.annotations.AfterMethod;

public class GalaxyNoteTestBase extends EggplantTestBase {

    private void handleAppCrash() {
        Logger.info("ATTEMPTING TO HANDLE ANY APP CRASHES...");
        EggplantElement crashText = new EggplantElement(By.Text("Unfortunately,",TextOption.waitFor(10)));
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
                .killApp()
                .goToDeviceHomeAndEnterApp()
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
        new DeviceMain().goToHomeScreen();
    }

}
