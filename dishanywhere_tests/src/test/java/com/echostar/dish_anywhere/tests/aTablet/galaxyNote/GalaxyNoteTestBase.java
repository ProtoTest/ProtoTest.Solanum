package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DishAnywhereHome;
import com.prototest.solanum.By;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.EggplantTestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

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

    @BeforeMethod
    public void resetSettings() {
        handleAppCrash();
         new DeviceMain()
                 .killApp()
                .goHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                 .openGuide()
                .openSettings()
                .openAuthorizedDevices()
                .authorizeThisDevice()
                .openParentalControls(Config.getTestProp("dishAnywherePassCode"))
                .clearMovieBlocks()
                .clearTVBlocks()
                .save().goToHomeScreen();

    }
}
