package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;

public class Blockbuster extends DishAnywhereHome{

    EggplantElement sortFilterButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/BlockBuster/SortFilterOptions/SortFilterButton"));
    EggplantElement moviesButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/BlockBuster/BlockBusterPage/Movies"));
    EggplantElement tvShowsButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/BlockBuster/BlockBusterPage/TVShows"));
    EggplantElement kidsMoviesButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/BlockBuster/BlockBusterPage/KidsMovies"));
    EggplantElement kidsTvShowsButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/BlockBuster/BlockBusterPage/KidsTVShows"));


    public FilterPopup openFilters(){
        sortFilterButton.click();
        return new FilterPopup();
    }

    public DishAnywhereScrollView openMovies(){
        Logger.info("Opening Blockbuster movies...");
        moviesButton.click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openTVShows(){
        Logger.info("Opening Blockbuster TV Shows...");
        tvShowsButton.click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openKidsMovies(){
        Logger.info("Opening Blockbuster Kids Movies...");
        kidsMoviesButton.click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openKidsTVShows(){
        Logger.info("Opening Blockbuster Kids TV Shows...");
        kidsTvShowsButton.click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

}
