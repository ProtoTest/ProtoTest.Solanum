package com.echostar.dish_anywhere.tests.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5.AndroidScreen;
import com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5.DishAnywhereHome;
import com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5.DishAnywhereLogin;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.SearchRectangle;
import com.prototest.solanum.TextOption;
import org.testng.annotations.Test;

/**
 *
 */
@Test()
public class GalaxyS5UiTest extends EggplantTestBase {


    @Test
    public void loginTest() {
        DishAnywhereHome home = new AndroidScreen()
                .goHome().openApp("Anywhere", DishAnywhereHome.class, TextOption.searchRectangle(SearchRectangle.bottomHalf()));
        DishAnywhereLogin login = home.openSettings().logout();
        login.login("guest1full", "guest4321");

    }
}