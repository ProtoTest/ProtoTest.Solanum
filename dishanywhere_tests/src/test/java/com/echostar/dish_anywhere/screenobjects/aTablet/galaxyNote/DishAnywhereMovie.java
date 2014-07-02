package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.*;
import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

/**
 */
public class DishAnywhereMovie extends DishAnywhereMain {
    EggplantElement watchButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/MovieDetailsDialog/WatchonMobileButton"));
    EggplantElement closeButton = new EggplantElement("closeButton", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/MovieDetailsDialog/CloseButton"));

    public MoviePlayer watchMovie() {
        watchButton.click();
        popups.waitForScreenToLoad();
        return new MoviePlayer();
    }

    public DishAnywhereOnDemand closeMovie(){
        nav.backButton.click();
        return new DishAnywhereOnDemand();
    }


}
