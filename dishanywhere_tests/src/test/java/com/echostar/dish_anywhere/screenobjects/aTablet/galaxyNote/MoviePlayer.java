package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.SearchRectangle;

import java.awt.*;
public class MoviePlayer extends DishAnywhereHome {
    EggplantElement screenElement = new EggplantElement(By.Point(new Point(200, 200)));
    private EggplantElement skipBackButton = new EggplantElement("Player skip back button", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/MoviePlayer/SkipBackButton"));
    EggplantElement pauseButton = new EggplantElement("Player pause button", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/MoviePlayer/PauseButton"));
    EggplantElement currentCursor = new EggplantElement("Current playback cursor", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/MoviePlayer/CurrentCursor"));
    EggplantElement deauthorizationMessage = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/MoviePlayer/UnauthorizedMessage"));
    private EggplantElement okButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/OkButton"));


    public MoviePlayer openControls() {
        while (! skipBackButton.isPresent()) {
            screenElement.tap();
        }
        popups.waitForScreenToLoad();
        return this;
    }

    public MoviePlayer verifyMoviePlays() {
        openControls();
        currentCursor.waitForPresent(60);
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

    public MoviePlayer verifyDeauthorizationMessageDisplays(){
        deauthorizationMessage.waitForPresent();
        okButton.click();
        // close the movie
        nav.backButton.click();
        // close search results
        nav.backButton.click();
        return this;
    }


}
