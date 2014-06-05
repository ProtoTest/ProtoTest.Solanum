package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.*;

/**
 */


public class DishAnywhereOnDemand extends DishAnywhereMain {
    private EggplantElement featuredButton
            = new EggplantElement(By.Text("Featured", SearchRectangle.middleHalf()));
    private EggplantElement moviesButton
            = new EggplantElement(By.Text("Movies", SearchRectangle.middleHalf()));
    private EggplantElement showsButton
            = new EggplantElement(By.Text("TV Shows", SearchRectangle.middleHalf()));
    private EggplantElement familyButton
            = new EggplantElement(By.Text("Family", SearchRectangle.middleHalf()));
    private EggplantElement latinoButton
            = new EggplantElement(By.Text("Latino", SearchRectangle.middleHalf()));
    private EggplantElement networksButton
            = new EggplantElement(By.Text("Networks", SearchRectangle.middleHalf()));
    private EggplantElement searchButton
            = new EggplantElement("Search Button", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/SearchButton"));
    private EggplantElement searchInput
            = new EggplantElement("Search Button", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/Search/SearchInput"));
    private EggplantElement searchInputClearButton
            = new EggplantElement("Search Button", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/Search/ClearSearchInput"));
    private EggplantElement submitSearchButton
            = new EggplantElement("Search Button", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/Search/SubmitSearchButton"));


    public DishAnywhereOnDemand() {
        while (! featuredButton.isPresent()) {
            nav.backButton.click();
        }
        featuredButton.verifyPresent();
    }

    public DishAnywhereScrollView openMovies() {
        moviesButton.tap();
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
}
