package com.echostar.dish_anywhere.tests.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5.DeviceHomeScreen;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.SearchRectangle;
import org.testng.annotations.Test;

/**
 *
 */
public class GalaxyS5PlaybackTest extends EggplantTestBase {
    @Test
    public void test1() {
        DeviceHomeScreen homeScreen = new DeviceHomeScreen();
        homeScreen.nav.homeButton.click();
        DeviceMain screen = homeScreen.openApp("eggOn", SearchRectangle.bottomHalf());
        //screen.clickOn("Stop eggOn", TextOption.searchRectangle(SearchRectangle.bottomHalf()));
    }
}
