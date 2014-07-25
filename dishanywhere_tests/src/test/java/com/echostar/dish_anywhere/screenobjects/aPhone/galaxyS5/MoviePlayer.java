package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;

import java.awt.*;

public class MoviePlayer extends DishAnywhereHome {
    EggplantElement screenElement = new EggplantElement(By.Point(new Point(200, 200)));
    private EggplantElement skipBackButton = new EggplantElement("Player skip back button", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/MoviePlayer/SkipBackButton"));
    EggplantElement pauseButton = new EggplantElement("Player pause button", By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/MoviePlayer/PauseButton"));
    EggplantElement deauthorizationMessage = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/MoviePlayer/UnauthorizedMessage"));
    EggplantElement okButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/OkButton"));

    public MoviePlayer openControls() {
        Logger.info("Opening controls...");
        while (! skipBackButton.isPresent()) {
            screenElement.doubleClick();
        }
        popups.waitForScreenToLoad();
        return this;
    }

    public MoviePlayer verifyMoviePlays() {
        Logger.info("Verifying Movie plays...");
        openControls();
        skipBackButton.verifyPresent();
        pauseButton.verifyPresent();
        return this;
    }

    public boolean isPresent() {
        if (pauseButton.isPresent() && skipBackButton.isPresent()) {
            return true;
        }
        return false;
    }
    public MoviePlayer verifyDeauthorizationMessageDisplays(){
        deauthorizationMessage.waitForPresent();
        okButton.click();
        return this;
    }


}
