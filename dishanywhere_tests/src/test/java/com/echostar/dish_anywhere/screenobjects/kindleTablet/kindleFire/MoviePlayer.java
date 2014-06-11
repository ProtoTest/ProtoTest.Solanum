package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

import java.awt.*;

public class MoviePlayer extends DishAnywhereHome {
    EggplantElement screenElement = new EggplantElement(By.Point(new Point(200, 200)));
    private EggplantElement skipBackButton = new EggplantElement("Player skip back button", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/MoviePlayer/SkipBackButton"));
    EggplantElement pauseButton = new EggplantElement("Player pause button", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/MoviePlayer/PauseButton"));
    EggplantElement currentCursor = new EggplantElement("Current playback cursor", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/MoviePlayer/CurrentCursor"));
    EggplantElement deauthorizationMessage = new EggplantElement(By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/MoviePlayer/UnauthorizedMessage"));
    EggplantElement okButton = new EggplantElement(By.Text("OK"));


    public MoviePlayer openControls() {
        while (! skipBackButton.isPresent()) {
            screenElement.doubleClick();
        }
        popups.waitForScreenToLoad();
        return this;
    }

    public MoviePlayer verifyMoviePlays() {

        screenElement.click();
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

    public DishAnywhereMovie verifyDeauthorizationMessageDisplays(){
        deauthorizationMessage.waitForPresent();
        okButton.click();
        return new DishAnywhereMovie();
    }


}
