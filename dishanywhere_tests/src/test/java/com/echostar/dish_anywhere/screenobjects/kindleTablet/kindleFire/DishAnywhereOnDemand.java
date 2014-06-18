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
    private EggplantElement searchInput
            = new EggplantElement("Search Button", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/Search/SearchInput"));
    private EggplantElement searchInputClearButton
            = new EggplantElement("Search Button", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/Search/ClearSearchInput"));
    private EggplantElement submitSearchButton
            = new EggplantElement("Search Button", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/Search/SubmitSearchButton"));

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

    public DishAnywhereSearchResult searchFor(String movie) {

        searchInputClearButton.click();
        searchInput.type(movie);
        submitSearchButton.click();

        return new DishAnywhereSearchResult();
    }

    public DishAnywhereSearchResult verifyPredictiveSearch(String movie) {
        String searchTerm = movie.substring(0, movie.length()-1);
        searchInputClearButton.click();
        searchInput.type(searchTerm);

        EggplantElement movieResultElement = new EggplantElement(By.Text(movie, SearchRectangle.topHalf().trimLeft(50)));
        movieResultElement.verifyPresent();

        movieResultElement.click();

        return new DishAnywhereSearchResult();

    }
}
