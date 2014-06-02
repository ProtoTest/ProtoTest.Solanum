package com.echostar.dish_anywhere.tests.aphone.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereScrollView;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Logger;
import org.testng.annotations.Test;

// DishAnywhere API Tests - GalaxyS5 (Android Phone)

@Test()
public class GalaxyS5OnDemand extends EggplantTestBase {



    @Test
    public void onDemandTest() {
        DishAnywhereScrollView movies =
                new DeviceMain().goHome()
                        .openDishAnywhereHome()
                        .openOnDemand()
                        .openMovies();
        movies.openMovie(0);

    }
}
