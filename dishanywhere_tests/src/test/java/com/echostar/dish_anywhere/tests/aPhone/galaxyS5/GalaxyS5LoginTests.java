package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.SolanumRetryAnalyzer;
import org.testng.annotations.Test;

//
//Tests for proper functionality of basic app functionality
//

public class GalaxyS5LoginTests extends GalaxyS5TestBase {

    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void testLogin() {
        new DishAnywhereHome();
    }
}
