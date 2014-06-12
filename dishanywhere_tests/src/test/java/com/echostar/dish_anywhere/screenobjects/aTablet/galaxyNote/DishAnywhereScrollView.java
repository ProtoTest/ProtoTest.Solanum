package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

import java.util.List;

public class DishAnywhereScrollView extends DishAnywhereMain {

    EggplantElement filterDropdownArrow = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/OnDemandPage/CloseArrowIcon"));
    EggplantElement sortFilterButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/OnDemandPage/SortFilterButton"));
    public FilterPopup openFilter(){
        sortFilterButton.click();
        return new FilterPopup();
    }
    public DishAnywhereMovie openMovie(String name){
        EggplantElement movie  = new EggplantElement(By.Text(name));
        movie.waitForPresent(30).click();
        return new DishAnywhereMovie();
    }
    public EnterPasscodePopup openProtectedMovie(String name){
        EggplantElement movie  = new EggplantElement(By.Text(name));
        movie.waitForPresent(30).click();
        return new EnterPasscodePopup();
    }

    public DishAnywhereScrollView verifyTitlesPresent(List<String> titles){
        popups.waitForScreenToLoad();
        for(String title : titles){
            EggplantElement movie = new EggplantElement(By.Text(title));
            movie.verifyPresent();
        }
        return this;
    }


}
