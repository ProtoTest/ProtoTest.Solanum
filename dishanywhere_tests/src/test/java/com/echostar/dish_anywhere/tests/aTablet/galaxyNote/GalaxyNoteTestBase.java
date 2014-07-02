package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DishAnywhereHome;
import com.prototest.solanum.By;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Logger;

/**
 */
public class GalaxyNoteTestBase extends EggplantTestBase {

    private void handleAppCrash() {
        EggplantElement crashText = new EggplantElement(By.Text("Unfortunately,"));
        EggplantElement okButton = new EggplantElement(By.Text("OK"));
        if (crashText.isPresent()) {
            okButton.click();
        }
    }

    @Override
    public void initializeApp() {

        handleAppCrash();
        DishAnywhereHome home = new DeviceMain()
                .goHome()
                .killApp()
                .openDishAnywhereHome()
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
        home.verifyLoggedIn();

    }

    @Override
    public void uninitializeApp() {
        handleAppCrash();
        new DeviceMain()
                .nav.backButton.click().click();
    }
}
