package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SearchRectangle;

import java.util.Arrays;
import java.util.List;

public class DishAnywhereOnDemand extends DishAnywhereHome {

    private EggplantElement featuredButton
            = new EggplantElement("featuredButton", By.Text("Featured", SearchRectangle.Quadrants.TOP_QUARTER));
    private EggplantElement moviesButton
            = new EggplantElement("moviesButton", By.Text("Movies", SearchRectangle.Quadrants.TOP_QUARTER));
    private EggplantElement showsButton
            = new EggplantElement("showsButton", By.Text("TV Shows", SearchRectangle.Quadrants.TOP_QUARTER));
    private EggplantElement familyButton
            = new EggplantElement("familyButton", By.Text("Family", SearchRectangle.Quadrants.TOP_QUARTER));
    private EggplantElement latinoButton
            = new EggplantElement("latinoButton", By.Text("Latino", SearchRectangle.Quadrants.TOP_QUARTER));
    private EggplantElement networksButton
            = new EggplantElement("networksButton", By.Text("Networks", SearchRectangle.Quadrants.TOP_QUARTER));
    private EggplantElement searchInput
            = new EggplantElement("Search Button", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/Search/SearchInput"));
    private EggplantElement searchInputClearButton
            = new EggplantElement("Search Button", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/Search/ClearSearchInput"));
    private EggplantElement submitSearchButton
            = new EggplantElement("Search Button", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/Search/SubmitSearchButton"));
    private EggplantElement firstSearchResult =
            new EggplantElement(By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/Search/FirstResult"));

    public DishAnywhereScrollView openMovies() {
        Logger.info("Opening movies category...");
        moviesButton.waitForPresent(30).click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openFeatured() {
        Logger.info("Opening featured category...");
        featuredButton.waitForPresent(30).click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openTVShows() {
        Logger.info("Opening tv shows category...");
        showsButton.waitForPresent(30).click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openFamily() {
        Logger.info("Opening family category...");
        familyButton.waitForPresent(30).click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openNetworks() {
        Logger.info("Opening networks category...");
        networksButton.waitForPresent(30).click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereSearchResult searchFor(String movie) {
        Logger.info("Searching for movie title: (" + movie + ").");
        searchInputClearButton.click();
        searchInput.type(movie);
        submitSearchButton.click();
        return new DishAnywhereSearchResult();
    }

    public DishAnywhereSearchResult verifyPredictiveSearch(String movie) {
        Logger.info("Doing predictive search for movie: (" + movie + ").");
        String searchTerm = movie.substring(0, movie.length() - 1);
        searchInputClearButton.click();
        searchInput.type(searchTerm);
        firstSearchResult.click();
        return new DishAnywhereSearchResult();
    }

    private String truncateTitle(String title, int maxChars) {
        List<String> words = Arrays.asList(title.split(" "));
        StringBuilder newTitle = new StringBuilder(words.get(0));
        for (String word : words.subList(1, words.size())) {
            if (newTitle.length() + 1 + word.length() < maxChars) {
                newTitle.append(" " + word);
            } else {
                break;
            }
        }
        return newTitle.toString();
    }

}
