package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.SearchRectangle;

public class DishAnywhereOnDemand extends DishAnywhereMain {
    private EggplantElement featuredButton
            = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/FeaturedButton", SearchRectangle.Quadrants.TOP_QUARTER));
    private EggplantElement moviesButton
            = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/MoviesButton", SearchRectangle.Quadrants.TOP_QUARTER));
    private EggplantElement showsButton
            = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/TVShowsButton", SearchRectangle.Quadrants.TOP_QUARTER));
    private EggplantElement familyButton
            = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/FamilyButton", SearchRectangle.Quadrants.TOP_QUARTER));
    private EggplantElement latinoButton
            = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/LatinoButton", SearchRectangle.Quadrants.TOP_QUARTER));
    private EggplantElement networksButton
            = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/NetworksButton", SearchRectangle.Quadrants.TOP_QUARTER));
    private EggplantElement searchInput
            = new EggplantElement("Search Button", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/Search/SearchButton"));
    private EggplantElement searchInputClearButton
            = new EggplantElement("Search Button", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/Search/ClearSearchInput"));
    private EggplantElement submitSearchButton
            = new EggplantElement("Search Button", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/Search/SubmitSearchButton"));
    private EggplantElement firstSearchResult =
            new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/Search/FirstResult"));

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

    public DishAnywhereOnDemand clearSearch(){
        searchInputClearButton.click();
        return new DishAnywhereOnDemand();
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
        firstSearchResult.click();
        EggplantTestBase.sleep(3000);
        return new DishAnywhereSearchResult();

    }
}
