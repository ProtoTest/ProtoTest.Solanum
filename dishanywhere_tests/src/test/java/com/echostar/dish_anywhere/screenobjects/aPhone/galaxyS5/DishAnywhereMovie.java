package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.ImageOption;
import com.prototest.solanum.Logger;

public class DishAnywhereMovie extends DishAnywhereMain {
    EggplantElement watchButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/MovieDetailsDialog/WatchonMobileButton", ImageOption.tolerance("45")));

    public MoviePlayer watchMovie() {
        Logger.info("Watching movie...");
        watchButton.click();
        popups.waitForScreenToLoad();
        return new MoviePlayer();
    }
}
