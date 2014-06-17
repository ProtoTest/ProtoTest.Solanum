package com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

/**
 */
public class DishAnywhereMovie extends DishAnywhereMain {
    EggplantElement watchButton = new EggplantElement("Watch Button", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/OnDemand/MovieDetailsDialog/WatchonMobileButton"));

    public MoviePlayer watchMovie() {
        watchButton.click();
        popups.waitForScreenToLoad();
        return new MoviePlayer();
    }


}
