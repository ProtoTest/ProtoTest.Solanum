package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DishAnywhereHome;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SolanumRetryAnalyzer;
import org.testng.annotations.Test;

public class GalaxyNotePasscode extends GalaxyNoteTestBase{

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void changePasscode(){
        Logger.info("Beginning Test: Change Passcode.");
        new DishAnywhereHome()
                .openSettings()
                .openParentalControls("1111")
                .changePasscode("0000")
                .openAuthorizedDevices()
                .openParentalControls("0000")
                .changePasscode("1111");
    }
}
