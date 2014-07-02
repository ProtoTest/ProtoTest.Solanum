package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

public class Blockbuster extends DishAnywhereHome{
    EggplantElement sortFilterButton = new EggplantElement("sortFilterButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/SortFilterOptions/SortFilterButton"));
    EggplantElement moviesButton = new EggplantElement("moviesButton_des", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/BlockBusterPage/Movies"));
    EggplantElement tvShowsButton = new EggplantElement("tvShowsButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/BlockBusterPage/TVShows"));
    EggplantElement kidsMoviesButton = new EggplantElement("kidsMoviesButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/BlockBusterPage/KidsMovies"));
    EggplantElement kidsTvShowsButton = new EggplantElement("kidsTvShowsButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/BlockBusterPage/KidsTVShows"));



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
