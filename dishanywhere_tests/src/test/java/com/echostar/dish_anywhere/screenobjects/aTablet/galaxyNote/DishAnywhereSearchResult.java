package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.*;

import java.awt.*;

public class DishAnywhereSearchResult {
    DeviceNavigation nav = new DeviceNavigation();
    EggplantElement onDemandButton = new EggplantElement(By.Text("On Demand"));
    private EggplantElement submitSearchButton
            = new EggplantElement("Search Button", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/Search/SubmitSearchButton"));

    NoteMovieFinder movieFinder = new NoteMovieFinder();

    public DishAnywhereSearchResult openOnDemandResults() {
        Logger.info("Opening On Demand results...");
        onDemandButton.click();
        return this;
    }

    public DishAnywhereMovie openMovie(String movieName) {
        Logger.info("Opening Movie...");
        return movieFinder.findMovie(movieName);
    }


}
