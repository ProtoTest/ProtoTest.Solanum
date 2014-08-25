package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.prototest.solanum.By;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.EggplantTestBase;

//
// Enhanced TestBase class for any Galaxy S5 specific functionality
//

public class GalaxyS5TestBase extends EggplantTestBase {
    private void handleAppCrash() {
        EggplantElement crashText = new EggplantElement(By.Text("Unfortunately,"));
        EggplantElement okButton = new EggplantElement(By.Text("OK"));
        if (crashText.isPresent(1)) {
            okButton.click();
        }
    }


    @Override
    public void initializeApp() {
        handleAppCrash();
        // Runs at startup for any test
        new DeviceMain()
                .goHome()
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
    
//    @BeforeMethod
//    public void goToDishAnywhereHome(){
//        new DeviceMain().goHome();
//    }
}
