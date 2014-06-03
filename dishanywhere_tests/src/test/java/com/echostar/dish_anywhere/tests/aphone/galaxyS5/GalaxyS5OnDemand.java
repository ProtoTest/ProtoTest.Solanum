package com.echostar.dish_anywhere.tests.aphone.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.MoviePlayer;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Logger;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

// DishAnywhere API Tests - GalaxyS5 (Android Phone)

@Test()
public class GalaxyS5OnDemand extends EggplantTestBase {



    @Test
    public void onDemandTest() {
        MoviePlayer movies =
                new DeviceMain().goHome()
                        .openDishAnywhereHome()
                        .openOnDemand()
                        .openMovies()
                        .openMovie(0)
                        .watch()
                        .openControls()
                        .assertControls();
        Verifications.addVerification("Opened OnDemand movie.", true);
        Logger.screenshot("OnDemandMovie");


    }
}
