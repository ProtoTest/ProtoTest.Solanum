package com.echostar.dish_anywhere.tests.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5.AndroidScreen;
import com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5.HomeScreen;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.SearchRectangle;
import com.prototest.solanum.TextOption;
import org.testng.annotations.Test;

/**
 *
 */
public class GalaxyS5PlaybackTest extends EggplantTestBase {
    @Test
    public void test1() {
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.nav.homeButton.click();
        AndroidScreen screen = homeScreen.openApp("eggOn", TextOption.searchRectangle(SearchRectangle.bottomHalf()));
        //screen.clickOn("Stop eggOn", TextOption.searchRectangle(SearchRectangle.bottomHalf()));
    }
}
