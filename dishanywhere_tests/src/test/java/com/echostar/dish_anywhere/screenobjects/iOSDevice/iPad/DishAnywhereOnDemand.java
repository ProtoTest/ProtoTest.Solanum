package com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.SearchRectangle;

public class DishAnywhereOnDemand extends DishAnywhereMain {
    private EggplantElement featuredButton
            = new EggplantElement("Featured", By.Text("Featured", SearchRectangle.Quadrants.TOP_QUARTER));
    private EggplantElement moviesButton
            = new EggplantElement("Movies", By.Text("Movies", SearchRectangle.Quadrants.TOP_QUARTER));
    private EggplantElement showsButton
            = new EggplantElement("Shows", By.Text("TV Shows", SearchRectangle.Quadrants.TOP_QUARTER));
    private EggplantElement familyButton
            = new EggplantElement("Family", By.Text("Family", SearchRectangle.Quadrants.TOP_QUARTER));
    private EggplantElement latinoButton
            = new EggplantElement("Latino", By.Text("Latino", SearchRectangle.Quadrants.TOP_QUARTER));
    private EggplantElement networksButton
            = new EggplantElement("Networks", By.Text("Networks", SearchRectangle.Quadrants.TOP_QUARTER));
    private EggplantElement searchInput
            = new EggplantElement("Search Button", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/OnDemand/Search/SearchButton"));
    private EggplantElement searchInputClearButton
            = new EggplantElement("Search Button", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/OnDemand/Search/ClearSearchInput"));
    private EggplantElement submitSearchButton
            = new EggplantElement("Search Button", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/OnDemand/Search/SubmitSearchButton"));

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

        EggplantElement movieResultElement = new EggplantElement(By.Text(movie, SearchRectangle.Quadrants.TOP_HALF));
        movieResultElement.verifyPresent();

        movieResultElement.click();

        return new DishAnywhereSearchResult();

    }
}
