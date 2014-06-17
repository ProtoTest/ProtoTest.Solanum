package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

import java.util.List;

public class DishAnywhereScrollView extends DishAnywhereMain {

    EggplantElement sortFilterButton = new EggplantElement("sortFilterButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/OnDemandPage/SortFilterOptions/SortFilterButton"));
    public FilterPopup openFilter(){
        sortFilterButton.click();
        return new FilterPopup();
    }
    public DishAnywhereMovie openMovie(String name){
        EggplantElement movie  = new EggplantElement("movie", By.Text(name));
        movie.waitForPresent(30).click();
        return new DishAnywhereMovie();
    }
    public EnterPasscodePopup openProtectedMovie(String name){
        EggplantElement movie  = new EggplantElement("movie", By.Text(name));
        movie.waitForPresent().click();
        return new EnterPasscodePopup();
    }

    public DishAnywhereScrollView verifyTitlesPresent(List<String> titles){
        popups.waitForScreenToLoad();
        for(String title : titles){
            EggplantElement movie = new EggplantElement("movie", By.Text(title));
            movie.verifyPresent();
        }
        return this;
    }


}
