package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DishAnywhereHome;
import org.testng.annotations.Test;

public class GalaxyNotePasscode extends GalaxyNoteTestBase{

    @Test
    public void changePasscode(){
        new DishAnywhereHome()
                .openSettings()
                .openParentalControls("1111")
                .changePasscode("0000")
                .openAuthorizedDevices()
                .openParentalControls("0000")
                .changePasscode("1111");
    }
}
