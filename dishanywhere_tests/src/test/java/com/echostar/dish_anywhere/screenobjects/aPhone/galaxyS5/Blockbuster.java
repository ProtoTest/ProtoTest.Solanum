package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SearchRectangle;

public class Blockbuster extends DishAnywhereHome {
    EggplantElement sortFilterButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/BlockBuster/SortFilterOptions/SortFilterButton"));
    private EggplantElement moviesButton
            = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/BlockBuster/BlockBusterPage/Movies"));
    private EggplantElement showsButton
            = new EggplantElement(By.Text("TV Shows", SearchRectangle.leftHalf()));
    EggplantElement kidsMoviesButton
            = new EggplantElement(By.Text("Kids Movies", SearchRectangle.leftHalf()));
    EggplantElement kidsTvShowsButton
            = new EggplantElement(By.Text("Kids TV Shows", SearchRectangle.middleHalf()));




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
        kidsMoviesButton.click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openKidsTVShows(){
        kidsTvShowsButton.click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }


}
