package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DeviceMain;
import com.prototest.solanum.*;
import org.testng.annotations.AfterMethod;

public class GalaxyNoteTestBase extends EggplantTestBase {

    @Override
    public void initializeApp() {
        handleAppCrash();
        Logger.info("Test Setup: Initializing the app...");
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
        Logger.info("Test Setup: App Initialized.");
    }

    @AfterMethod
    public void uninitializeApp() {
        Logger.info("Test Teardown: Confirming device is on the home screen...");
        //new DeviceMain().goHome();
        new DeviceMain().goToHomeScreen().confirmHomeScreen();
    }

    private void handleAppCrash() {
        Logger.info("Attempting to handle any app crashes...");
        EggplantElement crashText = new EggplantElement(By.Text("Unfortunately,",TextOption.waitFor(10)));
        EggplantElement okButton = new EggplantElement(By.Text("OK"));
        if (crashText.isPresent()) {
            okButton.click();
        }
    }

}
