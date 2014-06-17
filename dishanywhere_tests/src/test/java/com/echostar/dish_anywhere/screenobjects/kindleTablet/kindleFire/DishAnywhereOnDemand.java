package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.SearchRectangle;

public class DishAnywhereOnDemand extends DishAnywhereHome {
    private EggplantElement featuredButton
            = new EggplantElement("featuredButton", By.Text("Featured", SearchRectangle.topQuarter()));
    private EggplantElement moviesButton
            = new EggplantElement("moviesButton", By.Text("Movies", SearchRectangle.topQuarter()));
    private EggplantElement showsButton
            = new EggplantElement("showsButton", By.Text("TV Shows", SearchRectangle.topQuarter()));
    private EggplantElement familyButton
            = new EggplantElement("familyButton", By.Text("Family", SearchRectangle.topQuarter()));
    private EggplantElement latinoButton
            = new EggplantElement("latinoButton", By.Text("Latino", SearchRectangle.topQuarter()));
    private EggplantElement networksButton
            = new EggplantElement("networksButton", By.Text("Networks", SearchRectangle.topQuarter()));

    public DishAnywhereScrollView openMovies() {
        moviesButton.waitForPresent(30).click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openFeatured() {
        featuredButton.waitForPresent(30).click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openTVShows() {
        showsButton.waitForPresent(30).click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }
    public DishAnywhereScrollView openFamily() {
        familyButton.waitForPresent(30).click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }
    public DishAnywhereScrollView openNetworks() {
        networksButton.waitForPresent(30).click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

}
