package com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.TextOption;

/**
 */
public class AndroidScreen {
    public final Navigation nav = new Navigation();

    public AndroidScreen() {
        Logger.message("Loading main device screen.");
//        EggplantElement lockSlider = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/System/Device/LockButton"));
//        if (lockSlider.isPresent()) {
//            EggplantElement unlockSlider = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/System/Device/unlockButton"));
//            lockSlider.dragTo(unlockSlider);
//        }
    }

    public HomeScreen goHome() {
        Logger.message("Returning to device home screen.");
        nav.homeButton.click();
        return new HomeScreen();
    }

    public AndroidScreen clickOn(String text, TextOption... options) {
        new EggplantElement(By.Text(text, options)).click();
        return this;
    }
}
