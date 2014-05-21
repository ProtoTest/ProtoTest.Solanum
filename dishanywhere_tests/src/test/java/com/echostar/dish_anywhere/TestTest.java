package com.echostar.dish_anywhere;

import com.echostar.dish_anywhere.eggplant_suite.androidphone.AndroidScreen;
import com.echostar.dish_anywhere.eggplant_suite.androidphone.HomeScreen;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.SearchRectangle;
import com.prototest.solanum.TextOption;
import org.testng.annotations.Test;

/**
 *
 */
public class TestTest extends EggplantTestBase {
    @Test
    public void test1() {
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.nav.homeButton.click();
        AndroidScreen screen = homeScreen.openApp("eggOn", TextOption.searchRectangle(SearchRectangle.bottomHalf()));
        //screen.clickOn("Stop eggOn", TextOption.searchRectangle(SearchRectangle.bottomHalf()));
    }
}
