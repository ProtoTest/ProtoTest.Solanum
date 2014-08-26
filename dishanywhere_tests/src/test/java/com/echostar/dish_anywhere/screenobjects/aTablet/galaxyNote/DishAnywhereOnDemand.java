package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.*;

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
            = new EggplantElement("Search Input Field", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/Search/SearchButton"));
    private EggplantElement searchInputClearButton
            = new EggplantElement("Search Input Clear Button", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/Search/ClearSearchInput"));
    private EggplantElement submitSearchButton
            = new EggplantElement("Submit Search Button", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/Search/SubmitSearchButton"));
    private EggplantElement firstSearchResult =
            new EggplantElement("First Search Result", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/Search/FirstResult"));

    public DishAnywhereScrollView openMovies() {
        Logger.info("Opening Movies category...");
        moviesButton.waitForPresent(30).click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openFeatured() {
        Logger.info("Opening Featured category...");
        featuredButton.waitForPresent(30).click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openTVShows() {
        Logger.info("Opening TV Shows category...");
        showsButton.waitForPresent(30).click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }
    public DishAnywhereScrollView openFamily() {
        Logger.info("Opening Family category...");
        familyButton.waitForPresent(30).click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }
    public DishAnywhereScrollView openNetworks() {
        Logger.info("Opening Networks category...");
        networksButton.waitForPresent(30).click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereOnDemand clearSearch(){
        Logger.info("Clearing search field...");
        searchInputClearButton.click();
        return new DishAnywhereOnDemand();
    }

    public DishAnywhereSearchResult searchFor(String movie) {
        Logger.info("Searching for movie: (" + movie + ").");
        searchInputClearButton.click();
        searchInput.type(movie);
        submitSearchButton.click();
        return new DishAnywhereSearchResult();
    }

    public DishAnywhereSearchResult verifyPredictiveSearch(String movie) {
        Logger.info("Verifying predictive search...");
        String searchTerm = movie.substring(0, movie.length()-1);
        searchInputClearButton.click();
        searchInput.type(searchTerm);
        EggplantTestBase.sleep(5000);
        firstSearchResult.click();
        EggplantTestBase.sleep(5000);
        return new DishAnywhereSearchResult();

    }
}
