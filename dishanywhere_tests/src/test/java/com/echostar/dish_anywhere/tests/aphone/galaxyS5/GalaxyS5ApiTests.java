package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Logger;
import org.testng.annotations.Test;

// DishAnywhere API Tests - GalaxyS5 (Android Phone)

@Test()
public class GalaxyS5ApiTests extends EggplantTestBase {

    @Test
    public void apiOne() {
        Logger.info("Beginning Test: .");
        new DeviceMain().goHome()
                .openDishAnywhereHome();

    }
}
