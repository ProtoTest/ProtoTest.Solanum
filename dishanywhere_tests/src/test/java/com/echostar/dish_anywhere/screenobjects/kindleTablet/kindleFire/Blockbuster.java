package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

public class Blockbuster extends DishAnywhereHome{
    EggplantElement sortFilterButton = new EggplantElement("sortFilterButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/SortFilterOptions/SortFilterButton"));
    EggplantElement moviesButton_des = new EggplantElement("moviesButton_des", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/BlockBusterPage/Movies_DeSelected"));
    EggplantElement moviesButton_sel = new EggplantElement("moviesButton_sel", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/BlockBusterPage/Movies_Selected"));
    EggplantElement tvShowsButton = new EggplantElement("tvShowsButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/BlockBusterPage/TVShows_DeSelected"));
    EggplantElement kidsMoviesButton = new EggplantElement("kidsMoviesButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/BlockBusterPage/KidsMovies_DeSelected"));
    EggplantElement kidsTvShowsButton = new EggplantElement("kidsTvShowsButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/BlockBusterPage/KidsTVShows_DeSelected"));



    public FilterPopup openFilters(){
        sortFilterButton.click();
        return new FilterPopup();
    }

    public DishAnywhereScrollView openMovies(){
        if(!moviesButton_sel.isPresent())
            moviesButton_des.click();
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
