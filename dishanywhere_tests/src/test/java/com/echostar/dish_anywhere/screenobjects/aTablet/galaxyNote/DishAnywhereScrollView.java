package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereMain;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereMovie;
import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

import java.util.List;

public class DishAnywhereScrollView extends DishAnywhereMain {

    EggplantElement filterDropdownArrow = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/OnDemandPage/CloseArrowIcon"));


    public DishAnywhereMovie openMovie(String name){
        EggplantElement movie  = new EggplantElement(By.Text(name));
        movie.click();
        return new DishAnywhereMovie();
    }
    public EnterPasscodePopup openProtectedMovie(String name){
        EggplantElement movie  = new EggplantElement(By.Text(name));
        movie.click();
        return new EnterPasscodePopup();
    }

    public DishAnywhereScrollView verifyTitlesPresent(List<String> titles){
        for(String title : titles){
            EggplantElement movie = new EggplantElement(By.Text(title));
            movie.verifyPresent();
        }
        return this;
    }


}
