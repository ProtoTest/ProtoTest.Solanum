package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;

public class Blockbuster extends DishAnywhereHome {

    EggplantElement sortFilterButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/BlockBuster/SortFilterOptions/SortFilterButton"));
    private EggplantElement moviesButton
            = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/BlockBuster/BlockBusterPage/Movies"));
    private EggplantElement showsButton
            = new EggplantElement(By.Text("TV Shows"));
    EggplantElement kidsMoviesButton
            = new EggplantElement(By.Text("Kids Movies"));
    EggplantElement kidsTvShowsButton
            = new EggplantElement(By.Text("Kids TV Shows"));


    public DishAnywhereScrollView openMovies(){
        Logger.info("Opening Movies category...");
        moviesButton.click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openTVShows(){
        Logger.info("Opening TV Shows category...");
        showsButton.click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openKidsMovies(){
        Logger.info("Opening Kids Movies category...");
        kidsMoviesButton.click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openKidsTVShows(){
        Logger.info("Opening Kids TV Shows category...");
        kidsTvShowsButton.click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

}
