package com.echostar.dish_anywhere.tests.aphone.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

/**
 * Created by Brian on 6/4/2014.
 */
public class GalaxyS5Passcode extends EggplantTestBase{
    @Test
    public void movieCategory(){

        new DeviceMain()
                .goHome()
                .openDishAnywhereApp()
                .exitPlayerIfOpen()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))

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
