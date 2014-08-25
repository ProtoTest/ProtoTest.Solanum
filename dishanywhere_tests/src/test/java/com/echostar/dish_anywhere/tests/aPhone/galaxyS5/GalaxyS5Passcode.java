package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.Config;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SolanumRetryAnalyzer;
import org.testng.annotations.Test;

//
//Tests for proper functionality of app "Passcode" popup
//

public class GalaxyS5Passcode extends GalaxyS5TestBase {

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void changePasscode(){
        Logger.info("Beginning Test: Change Passcode.");

        new DishAnywhereHome()
                .openSettings()
                .openParentalControls(Config.getTestProp("dishAnywherePassCode"))
                .changePasscode(Config.getTestProp("dishAnywherePassCodeNew"))
                .openSettingsRoot()
                .openAuthorizedDevices()
                .openSettingsRoot()
                .openParentalControls(Config.getTestProp("dishAnywherePassCodeNew"))
                .changePasscode(Config.getTestProp("dishAnywherePassCode"));
    }

}
