package com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad;

import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereMain;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereMovie;
import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

/**
 */
public class OnDemandMovies extends DishAnywhereMain {
    EggplantElement movieArrow  = new EggplantElement("movieArrow", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/MovieArrow"));
    EggplantElement contentLock = new EggplantElement("contentLock", By.Text("Enter Passcode"));

    public DishAnywhereMovie openMovie(String name){
        EggplantElement movie  = new EggplantElement("movie", By.Text(name));
        movie.click();
        return new DishAnywhereMovie();
    }
    public DishAnywhereMovie openProtectedMovie(String name){
        EggplantElement movie  = new EggplantElement("movie", By.Text(name));
        movie.click();
        return new DishAnywhereMovie();
    }


}
