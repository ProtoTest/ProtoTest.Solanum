package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereMain;
import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

import java.awt.*;
public class MoviePlayer extends DishAnywhereMain {
    EggplantElement screenElement = new EggplantElement(By.Point(new Point(200, 200)));
    private EggplantElement skipBackButton = new EggplantElement("Player skip back button", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/MoviePlayer/SkipBackButton"));
    EggplantElement pauseButton = new EggplantElement("Player pause button", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/MoviePlayer/PauseButton"));
    public MoviePlayer openControls() {
        while (! skipBackButton.isPresent()) {
            screenElement.doubleClick();
        }
        popups.waitForScreenToLoad();
        return this;
    }

    public MoviePlayer waitForControls() {
        skipBackButton.waitForPresent(60);
        pauseButton.waitForPresent(60);
        return this;
    }

    public boolean isPresent() {
        if (pauseButton.isPresent() && skipBackButton.isPresent()) {
            return true;
        }
        return false;
    }


}
