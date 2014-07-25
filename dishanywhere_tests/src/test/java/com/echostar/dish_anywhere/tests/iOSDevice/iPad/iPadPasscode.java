package com.echostar.dish_anywhere.tests.iOSDevice.iPad;

import com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

/**
 * Created by Brian on 6/4/2014.
 */
public class iPadPasscode extends EggplantTestBase{
    @Test
    public void movieCategory(){

        new DeviceMain()
                .goHome()
                .killApp()
                .goHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openSettings()
                .openParentalControls("1111")
                .changePasscode("0000")
                .openAuthorizedDevices()
                .openParentalControls("0000")
                .changePasscode("1111");


        Verifications.assertVerifications();


    }
}
