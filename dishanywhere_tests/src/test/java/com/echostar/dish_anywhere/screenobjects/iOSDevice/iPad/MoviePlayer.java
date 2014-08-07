package com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

import java.awt.*;

public class MoviePlayer extends DishAnywhereHome {
    EggplantElement screenElement = new EggplantElement(By.Point(new Point(200, 200)));
    private EggplantElement skipBackButton = new EggplantElement("Player skip back button", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/MoviePlayer/SkipBackButton"));
    EggplantElement pauseButton = new EggplantElement("Player pause button", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/MoviePlayer/PauseButton"));
    EggplantElement currentCursor = new EggplantElement("Current playback cursor", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/MoviePlayer/CurrentCursor"));
    EggplantElement deauthorizationMessage = new EggplantElement(By.Image("iosTablet/iPadAir/Apps/DishAnywhere/MoviePlayer/UnauthorizedMessage"));
    EggplantElement okButton = new EggplantElement(By.Text("OK"));


    public MoviePlayer openControls() {
        for (int i=0;i<10&&! skipBackButton.isPresent();i++) {
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
        return this;
    }


}
