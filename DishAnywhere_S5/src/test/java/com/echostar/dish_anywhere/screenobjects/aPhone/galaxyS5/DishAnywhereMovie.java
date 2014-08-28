package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.*;

public class DishAnywhereMovie extends DishAnywhereMain {

    EggplantElement watchButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/MovieDetailsDialog/WatchonMobileButton", ImageOption.tolerance("45")));

    public MoviePlayer watchMovie() {
        Logger.info("Watching movie...");
        EggplantTestBase.sleep(2000);
        watchButton.click();
        popups.waitForScreenToLoad();
        popups.closeLteMessageIfPresent();
        popups.waitForScreenToLoad();
        return new MoviePlayer();
    }

}
