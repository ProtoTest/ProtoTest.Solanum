package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.SearchRectangle;

/**
 * Created by Brian on 6/4/2014.
 */
public class Blockbuster extends DishAnywhereHome {
    EggplantElement sortFilterButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/BlockBuster/SortFilterOptions/SortFilterButton"));
    private EggplantElement moviesButton
            = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/BlockBuster/BlockBusterPage/Movies_DeSelected"));
    private EggplantElement showsButton
            = new EggplantElement(By.Text("TV Shows", SearchRectangle.middleHalf()));
    EggplantElement kidsMoviesButton
            = new EggplantElement(By.Text("TV Shows", SearchRectangle.middleHalf()));
    EggplantElement kidsTvShowsButton
            = new EggplantElement(By.Text("TV Shows", SearchRectangle.middleHalf()));




    public DishAnywhereScrollView openMovies(){
        moviesButton.click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openTVShows(){
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
