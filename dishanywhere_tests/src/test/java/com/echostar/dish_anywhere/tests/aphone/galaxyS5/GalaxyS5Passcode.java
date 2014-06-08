package com.echostar.dish_anywhere.tests.aphone.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import org.testng.annotations.Test;

/**
 * Created by Brian on 6/4/2014.
 */
public class GalaxyS5Passcode extends EggplantTestBase{
    @Test
    public void movieCategory(){

        new DeviceMain()
                .goHome()
                .killApp()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openSettings()
                .openParentalControls("1111")
                .changePasscode("0000")
                .openAuthorizedDevices()
                .openParentalControls("0000")
                .changePasscode("1111");




    }
}
