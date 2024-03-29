package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;

import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SolanumRetryAnalyzer;
import org.testng.annotations.Test;

public class KindleFireHdxUiTests extends EggplantTestBase {

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void testLogoutAndLogin() {
        Logger.info("Beginning Test: Logout and Login.");
        new DeviceMain()
                .goHome()
                .openSettings()
                .logout()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .verifyLoggedIn();
    }

}
