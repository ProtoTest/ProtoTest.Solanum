package com.echostar.dish_anywhere;

import com.echostar.dish_anywhere.eggplant_suite.androidphone.AndroidScreen;
import com.echostar.dish_anywhere.eggplant_suite.androidphone.DishAnywhereHome;
import com.echostar.dish_anywhere.eggplant_suite.androidphone.DishAnywhereLogin;
import com.echostar.dish_anywhere.eggplant_suite.androidphone.HomeScreen;
import com.prototest.solanum.By;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.SearchRectangle;
import com.prototest.solanum.TextOption;
import org.testng.annotations.Test;

/**
 *
 */
public class GalaxyS5Test extends EggplantTestBase {
    @Test
    public void test1() {
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.nav.homeButton.click();
        AndroidScreen screen = homeScreen.openApp("eggOn", TextOption.searchRectangle(SearchRectangle.bottomHalf()));
        //screen.clickOn("Stop eggOn", TextOption.searchRectangle(SearchRectangle.bottomHalf()));
    }

    @Test
    public void loginTest() {
        DishAnywhereHome home = new AndroidScreen()
                .goHome().openApp("Anywhere", DishAnywhereHome.class, TextOption.searchRectangle(SearchRectangle.bottomHalf()));
        DishAnywhereLogin login = home.openSettings().logout();
        login.login("guest1full", "guest4321");

    }
}
