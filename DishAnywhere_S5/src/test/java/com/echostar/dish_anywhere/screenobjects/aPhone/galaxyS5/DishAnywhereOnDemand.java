package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.*;

public class DishAnywhereOnDemand extends DishAnywhereMain {

    private EggplantElement allTitles
            = new EggplantElement(By.Text("All Titles", SearchRectangle.Quadrants.TOP_HALF));
    private EggplantElement blockbusterButton
            = new EggplantElement(By.Text("Blockbuster", SearchRectangle.Quadrants.TOP_HALF));
    private EggplantElement featuredButton
            = new EggplantElement(By.Text("Featured", SearchRectangle.Quadrants.MIDDLE_HALF));
    private EggplantElement moviesButton
            = new EggplantElement(By.Text("Movies", SearchRectangle.Quadrants.MIDDLE_HALF));
    private EggplantElement showsButton
            = new EggplantElement(By.Text("TV Shows", SearchRectangle.Quadrants.MIDDLE_HALF));
    private EggplantElement familyButton
            = new EggplantElement(By.Text("Family", SearchRectangle.Quadrants.MIDDLE_HALF));
    private EggplantElement latinoButton
            = new EggplantElement(By.Text("Latino", SearchRectangle.Quadrants.MIDDLE_HALF));
    private EggplantElement networksButton
            = new EggplantElement(By.Text("Networks"));
    private EggplantElement searchButton
            = new EggplantElement("Search Button", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/SearchButton"));
    private EggplantElement searchInput
            = new EggplantElement("Search Button", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/Search/SearchInput"));
    private EggplantElement searchInputClearButton
            = new EggplantElement("Search Button", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/Search/ClearSearchInput"));
    private EggplantElement submitSearchButton
            = new EggplantElement("Search Button", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/Search/SubmitSearchButton"));

    public DishAnywhereOnDemand() {

    }

    public DishAnywhereOnDemand goToOnDemandRoot() {
        Logger.info("Entering On Demand root...");
        for (int i = 0; i < 10 && !searchButton.isPresent(); i++) {
            EggplantTestBase.driver.PressBackButton();
        }
        searchButton.verifyPresent();
        return this;
    }

    public DishAnywhereScrollView openMovies() {
        Logger.info("Opening On Demand Movies...");
        moviesButton.tap();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openFeatured() {
        Logger.info("Opening On Demand Featured...");
        featuredButton.tap();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openTvShows() {
        Logger.info("Opening On Demand TV Shows...");
        showsButton.tap();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openFamily() {
        Logger.info("Opening On Demand Family...");
        familyButton.tap();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openLatino() {
        latinoButton.tap();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openNetworks() {
        Logger.info("Opening On Demand Networks...");
        networksButton.tap();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereSearchResult searchFor(String movie) {
        Logger.info(String.format("Searching for movie: (%s)...", movie));
        searchInputClearButton.click();
        searchInput.type(movie);
        searchInput.sendKeys(EggplantKeys.enter);
        return new DishAnywhereSearchResult();
    }

    public DishAnywhereOnDemand clickSearchButton() {
        Logger.info("Clicking Search button...");
        searchButton.click();
        return this;
    }

    public Blockbuster openBlockbuster() {
        Logger.info("Opening Blockbuster...");
        blockbusterButton.click();
        return new Blockbuster();
    }

    public DishAnywhereSearchResult verifyPredictiveSearch(String movie) {
        Logger.info(String.format("Verifying predictive search for movie: (%s)...", movie));
        String searchTerm = movie.substring(0, movie.length()-1);
        searchInputClearButton.click();
        searchInput.type(searchTerm);

        EggplantElement movieResultElement = new EggplantElement(By.Text(movie, SearchRectangle.Quadrants.TOP_HALF));
        movieResultElement.waitForPresent(60);

        movieResultElement.click();

        return new DishAnywhereSearchResult();
    }

}
