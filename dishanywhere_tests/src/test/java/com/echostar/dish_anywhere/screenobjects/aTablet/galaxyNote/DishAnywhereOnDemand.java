package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.SearchRectangle;

public class DishAnywhereOnDemand extends DishAnywhereMain {
    private EggplantElement featuredButton
            = new EggplantElement(By.Text("Featured", SearchRectangle.topQuarter()));
    private EggplantElement moviesButton
            = new EggplantElement(By.Text("Movies", SearchRectangle.topQuarter()));
    private EggplantElement showsButton
            = new EggplantElement(By.Text("TV Shows", SearchRectangle.topQuarter()));
    private EggplantElement familyButton
            = new EggplantElement(By.Text("Family", SearchRectangle.topQuarter()));
    private EggplantElement latinoButton
            = new EggplantElement(By.Text("Latino", SearchRectangle.topQuarter()));
    private EggplantElement networksButton
            = new EggplantElement(By.Text("Networks", SearchRectangle.topQuarter()));
    private EggplantElement searchInput
            = new EggplantElement("Search Button", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/Search/SearchButton"));
    private EggplantElement searchInputClearButton
            = new EggplantElement("Search Button", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/Search/ClearSearchInput"));
    private EggplantElement submitSearchButton
            = new EggplantElement("Search Button", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/Search/SubmitSearchButton"));

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
