package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;

import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

/**
 * Created by Brian on 6/4/2014.
 */
public class KindleFirePasscode extends EggplantTestBase{
    @Test
    public void movieCategory(){

        new DeviceMain()
                .goHome()
                .openDishAnywhereHome()
                .goBackToDeviceScreen()
                .openDishAnywhereHome()
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
