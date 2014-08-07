package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.SearchRectangle;

import java.awt.*;

/**
 */
public class DishAnywhereSearchResult {
    DeviceNavigation nav = new DeviceNavigation();
    EggplantElement onDemandButton = new EggplantElement(By.Text("On Demand"));
    private EggplantElement submitSearchButton
            = new EggplantElement("Search Button", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/Search/SubmitSearchButton"));

    public DishAnywhereSearchResult openOnDemandResults() {
        onDemandButton.click();
        return this;
    }

    public DishAnywhereMovie openMovie(String movieName) {
        // Sometimes the keyboard is still open after doing a search. Make sure it's closed.
        if (submitSearchButton.isPresent()) {
            EggplantTestBase.driver.PressBackButton();
        }
        // TODO: workaround for bug: anywhere app cuts off characters below the baseline (e.g. y, g, etc.)
        // Therefore, click by point rather than movie name.
        // Click first result.
        new EggplantElement(By.Text(movieName, SearchRectangle.Quadrants.TOP_HALF)).click();
        // Verify the movie info popup contains the movie name.
        new EggplantElement(By.Text(movieName)).verifyPresent();

        return new DishAnywhereMovie();
    }
}
