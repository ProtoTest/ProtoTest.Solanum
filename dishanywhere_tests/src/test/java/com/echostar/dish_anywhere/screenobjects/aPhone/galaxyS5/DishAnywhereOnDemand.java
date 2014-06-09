package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.*;

/**
 */


public class DishAnywhereOnDemand extends DishAnywhereMain {
    private EggplantElement allTitles = new EggplantElement(By.Text("All Titles", SearchRectangle.topHalf()));
    private EggplantElement blockbusterButton = new EggplantElement(By.Text("Blockbuster", SearchRectangle.topHalf()));
    private EggplantElement featuredButton = new EggplantElement(By.Text("Featured", SearchRectangle.middleHalf()));
    private EggplantElement moviesButton = new EggplantElement(By.Text("Movies", SearchRectangle.middleHalf()));
    private EggplantElement showsButton = new EggplantElement(By.Text("TV Shows", SearchRectangle.middleHalf()));
    private EggplantElement familyButton = new EggplantElement(By.Text("Family", SearchRectangle.middleHalf()));
    private EggplantElement latinoButton = new EggplantElement(By.Text("Latino", SearchRectangle.middleHalf()));
    private EggplantElement networksButton = new EggplantElement(By.Text("Networks", SearchRectangle.middleHalf()));
    private EggplantElement searchButton = new EggplantElement("Search Button", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/SearchButton"));
    private EggplantElement searchInput = new EggplantElement("Search Button", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/Search/SearchInput"));

    private EggplantElement searchInputClearButton = new EggplantElement("Search Button",
            By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/Search/ClearSearchInput",
                    SearchRectangle.topQuarter(),
                    ImageOption.searchType("Tolerant")));


    private EggplantElement submitSearchButton = new EggplantElement("Search Button", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/Search/SubmitSearchButton"));


    public DishAnywhereOnDemand() {

    }

    public DishAnywhereOnDemand goToOnDemandRoot() {
        for (int i = 0; i < 10 && !searchButton.isPresent(); i++) {
            nav.backButton.click();
        }
        searchButton.verifyPresent();
        return this;
    }

    public DishAnywhereScrollView openMovies() {
        moviesButton.tap();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openFeatured() {
        featuredButton.tap();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openTvShows() {
        showsButton.tap();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openFamily() {
        familyButton.tap();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openLatino() {
        latinoButton.tap();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openNetworks() {
        networksButton.tap();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereSearchResult searchFor(String movie) {

        searchInputClearButton.click();
        searchInput.type(movie);
        submitSearchButton.click();

        return new DishAnywhereSearchResult();
    }

    public DishAnywhereOnDemand clickSearchButton() {
        searchButton.click();
        return this;
    }

    public Blockbuster openBlockbuster() {
        blockbusterButton.click();
        return new Blockbuster();
    }
}
