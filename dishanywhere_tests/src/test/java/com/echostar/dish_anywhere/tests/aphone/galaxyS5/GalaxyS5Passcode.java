package com.echostar.dish_anywhere.tests.aphone.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

/**
 * Created by Brian on 6/4/2014.
 */
public class GalaxyS5Passcode extends GalaxyS5TestBase{
    @Test
    public void movieCategory(){

        new DishAnywhereHome()
                .openSettings()
                .openParentalControls("1111")
                .changePasscode("0000")
                .openSettingsRoot()
                .openAuthorizedDevices()
                .openSettingsRoot()
                .openParentalControls("0000")
                .changePasscode("1111");

        Verifications.assertVerifications();



    }
}
