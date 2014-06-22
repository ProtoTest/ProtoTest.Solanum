package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.prototest.solanum.Config;
import com.prototest.solanum.CukePlantTestBase;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 */

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "html:target/cucumber"})
public class login extends CukePlantTestBase {
    @Override
    public void initializeApp() {
        // Runs at startup for any test
        new DeviceMain()
                .goHome()
                .openDishAnywhereApp()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .closePopups();
    }

    @Override
    public void uninitializeApp() {
        // Try to prevent the video player from being open before any future tests.
        DeviceMain deviceMain = new DeviceMain();
        for (int i = 0; i < 2 && !deviceMain.isOnHome(); i++) {
            deviceMain.nav.backButton.click();
        }
    }
}
