package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;

public class DishAnywhereMovie extends DishAnywhereMain {
    EggplantElement watchButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/MovieDetailsDialog/WatchonMobileButton"));
    EggplantElement closeButton = new EggplantElement("closeButton", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/MovieDetailsDialog/CloseButton"));
    EggplantElement titleField = new EggplantElement("Title field", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/MovieDetailsDialog/MovieTitleHotspot"));

    public MoviePlayer watchMovie() {
        Logger.info("Watching movie...");
        watchButton.click();
        popups.waitForScreenToLoad();
        return new MoviePlayer();
    }

    public DishAnywhereOnDemand closeMovie(){
        Logger.info("Closing movie...");
        closeButton.waitForPresent().click();
        return new DishAnywhereOnDemand();
    }

    public String getTitle() {
        Logger.info("Extracting movie title...");
        String foundTitle = titleField.getText();
        Logger.info(String.format("Found movie title: (%s)", foundTitle));
        return foundTitle;
    }
}
