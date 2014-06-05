package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

/**
 */
public class DishAnywhereMovie extends DishAnywhereMain {
    EggplantElement watchButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/MovieDetailsDialog/WatchonMobileButton"));

    public MoviePlayer watchMovie() {
        watchButton.click();
        popups.waitForScreenToLoad();
        return new MoviePlayer();
    }
}
