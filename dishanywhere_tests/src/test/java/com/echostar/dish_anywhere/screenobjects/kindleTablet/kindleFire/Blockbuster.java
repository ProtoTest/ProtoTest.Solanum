package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

public class Blockbuster extends DishAnywhereHome{
    EggplantElement sortFilterButton = new EggplantElement(By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/SortFilterOptions/SortFilterButton"));
    EggplantElement moviesButton = new EggplantElement(By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/BlockBusterPage/Movies_DeSelected"));
    EggplantElement tvShowsButton = new EggplantElement(By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/BlockBusterPage/TVShows_DeSelected"));
    EggplantElement kidsMoviesButton = new EggplantElement(By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/BlockBusterPage/KidsMovies_DeSelected"));
    EggplantElement kidsTvShowsButton = new EggplantElement(By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/BlockBusterPage/KidsTVShows_DeSelected"));



    public FilterPopup openFilters(){
        sortFilterButton.click();
        return new FilterPopup();
    }

    public DishAnywhereScrollView openMovies(){
        moviesButton.click();
        popups.waitForScreenToLoad();
        return new DishAnywhereScrollView();
    }

    public DishAnywhereScrollView openTVShows(){
        tvShowsButton.click();
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
