package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantElement;

import java.util.List;

/**
 */
public class DishAnywhereScrollView extends DishAnywhereMain {
    EggplantElement movieArrow
            = new EggplantElement(
            By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/MovieArrow"));
    EggplantElement contentLock =
            new EggplantElement(By.Text("Enter Passcode"));
    public void scroll() {
        List<EggplantElement> arrows = movieArrow.allInstances();
        arrows.get(arrows.size()-1).dragTo(arrows.get(0));
    }

    public DishAnywhereMovie openMovie(int i) {
        List<EggplantElement> arrows = movieArrow.allInstances();
        arrows.get(0).click();
        popups.enterPasscodeIfNeeded();
        return new DishAnywhereMovie();
    }


}
