package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;

// Screen Object for Device's locked state screen

public class DeviceLockScreen {
    EggplantElement lockIcon = new EggplantElement("LockIcon", By.Image("AndroidTablet/GalaxyNote/System/Device/LockButton"));


    public DeviceHomeScreen unlock(){
        Logger.info("Unlocking device, if required.");
        if (lockIcon.isPresent()) {
            EggplantElement unlockSlider = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/System/Device/unlockButton"));
            //lockIcon.dragTo(unlockSlider);
            lockIcon.swipeLeft();
            Logger.info("Device unlocked.");
        }

    return new DeviceHomeScreen();
    }
}
