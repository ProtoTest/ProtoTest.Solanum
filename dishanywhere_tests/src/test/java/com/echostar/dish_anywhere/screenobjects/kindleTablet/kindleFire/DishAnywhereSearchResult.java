package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

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
        // Sometimes the keyboard is still open after doing a search. Make sure it's closed.
//        if (submitSearchButton.isPresent()) {
//            closeKeyboardButton.click();
//        }
        return movieFinder.findMovie(movieName);
//        EggplantElement movie = new EggplantElement("Movie " + movieName, By.Text(movieName));
//        movie.waitForPresent();
//        movie.click();
//        return new DishAnywhereMovie();
//        List<EggplantElement> movies = leftMovieBorder.allInstances();
//        for (EggplantElement movie : movies) {
//            movie.click();
//            DishAnywhereMovie dishAnywhereMovie = new DishAnywhereMovie();
//            if (new EggplantElement(movieName, By.Text(movieName, SearchRectangle.middleHalf())).isPresent()) {
//                return dishAnywhereMovie;
//            } else {
//                dishAnywhereMovie.closeMovie();
//            }
//        }
       // throw new RuntimeException("Movie " + movieName + " was not found in search results!");
    }
    public DishAnywhereMovie openProtectedMovie(String movieName, String passcode){
        return movieFinder.findMovie(movieName, passcode);
    }
}
