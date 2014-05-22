package com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

/**
 * Created by Brian on 5/22/2014.
 */
public class LockScreen {
    EggplantElement lockIcon = new EggplantElement("LockIcon", By.Image("/AndroidTablet/Kindle/System/Device/LockButton"));


    public HomeScreen unlock(){
    lockIcon.swipeLeft();
    return new HomeScreen();
    }
}
