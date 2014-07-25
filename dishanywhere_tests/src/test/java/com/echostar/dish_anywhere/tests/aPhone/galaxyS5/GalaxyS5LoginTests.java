package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.Config;
import com.prototest.solanum.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.annotation.Repeatable;
import java.util.Iterator;

//
//Tests for proper functionality of basic app functionality
//

public class GalaxyS5LoginTests extends GalaxyS5TestBase {

    @Test
    public void testLogin() {
        new DishAnywhereHome();
    }
}
