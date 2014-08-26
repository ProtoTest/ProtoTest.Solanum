package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;

public class DishAnywhereSearchResult extends DeviceMain {

    DeviceNavigation nav = new DeviceNavigation();
    EggplantElement onDemandButton = new EggplantElement("On Demand Button", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/Search/OnDemandButton"));
    private EggplantElement submitSearchButton
            = new EggplantElement("Search Button", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/Search/SubmitSearchButton"));
    EggplantElement leftMovieBorder = new EggplantElement("leftMovieBorder", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/OnDemandPage/MovieLeftBorder"));

    KindleMovieFinder movieFinder = new KindleMovieFinder();


    public DishAnywhereSearchResult openOnDemandResults() {
        onDemandButton.click();
        return this;
    }

    public DishAnywhereMovie openMovie(String movieName) {
        Logger.info("Opening movie with title: " + movieName);
        return movieFinder.findMovie(movieName);
    }

    public DishAnywhereMovie openProtectedMovie(String movieName, String passcode){
        Logger.info("Opening movie title with expected passcode popup: " + movieName);
        return movieFinder.findMovie(movieName, passcode);
    }

}
