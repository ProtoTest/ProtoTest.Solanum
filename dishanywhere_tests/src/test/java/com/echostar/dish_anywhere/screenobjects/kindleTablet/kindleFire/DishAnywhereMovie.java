package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

/**
 */
public class DishAnywhereMovie extends DishAnywhereMain {
    EggplantElement watchButton = new EggplantElement("watchButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/MovieDetailsDialog/WatchonMobileButton"));
    EggplantElement closeButton = new EggplantElement("closeButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/MovieDetailsDialog/CloseButton"));
    EggplantElement titleField = new EggplantElement("Title field", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/MovieDetailsDialog/MovieTitleHotspot"));

    public MoviePlayer watchMovie() {
        watchButton.click();
        popups.waitForScreenToLoad();
        return new MoviePlayer();
    }

    public DishAnywhereOnDemand closeMovie(){
        closeButton.waitForPresent().click();
        return new DishAnywhereOnDemand();
    }


    public String getTitle() {
        return titleField.getText();
    }
}
