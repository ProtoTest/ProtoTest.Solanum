package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

import java.util.List;

/**
 */
public class DishAnywhereScrollView extends DeviceMain {
    EggplantElement movieArrow
            = new EggplantElement(
                By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/MovieArrow"));
    public void scroll() {
        List<EggplantElement> arrows = movieArrow.allInstances();
        arrows.get(arrows.size()-1).dragTo(arrows.get(0));
    }
}
