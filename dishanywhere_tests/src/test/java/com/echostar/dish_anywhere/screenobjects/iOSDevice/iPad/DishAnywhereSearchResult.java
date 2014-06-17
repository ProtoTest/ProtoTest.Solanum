package com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.SearchRectangle;

import java.awt.*;

/**
 */
public class DishAnywhereSearchResult {
    DeviceNavigation nav = new DeviceNavigation();
    EggplantElement onDemandButton = new EggplantElement("onDemandButton", By.Text("On Demand"));
    private EggplantElement submitSearchButton
            = new EggplantElement("Search Button", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/OnDemand/Search/SubmitSearchButton"));

    public DishAnywhereSearchResult openOnDemandResults() {
        onDemandButton.click();
        return this;
    }

    public DishAnywhereMovie openMovie(String movieName) {
        // Sometimes the keyboard is still open after doing a search. Make sure it's closed.
//        if (submitSearchButton.isPresent()) {
//            nav.backButton.click();
//        }
        // TODO: workaround for bug: anywhere app cuts off characters below the baseline (e.g. y, g, etc.)
        // Therefore, click by point rather than movie name.
        // Click first result.
        new EggplantElement(By.Point(new Point(103, 192))).click();
        // Verify the movie info popup contains the movie name.
        new EggplantElement(By.Text(movieName, SearchRectangle.middleHalf())).verifyPresent();

        return new DishAnywhereMovie();
    }
}
