package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.*;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DishAnywhereScrollView;
import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

/**
 */
public class DishAnywhereSearchResult {
    DeviceNavigation nav = new DeviceNavigation();
    EggplantElement onDemandButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/Search/OnDemandButton"));
    EggplantElement movieArrow  = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/MovieArrow"));
    private EggplantElement submitSearchButton
            = new EggplantElement("Search Button", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/Search/SubmitSearchButton"));

    public DishAnywhereSearchResult openOnDemandResults() {
        onDemandButton.click();
        return this;
    }

    public DishAnywhereMovie openMovie() {
        // Sometimes the keyboard is still open after doing a search. Make sure it's closed.
        if (submitSearchButton.isPresent()) {
            nav.backButton.click();
        }
        movieArrow.click();
        return new DishAnywhereMovie();
    }
}
