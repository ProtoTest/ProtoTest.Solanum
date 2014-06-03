package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFireHDX;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;

// Screen Object for Device's locked state screen

public class DeviceLockScreen {
    EggplantElement lockIcon = new EggplantElement("LockIcon", By.Image("KindleTablet/KindleFireHDX/System/Device/LockButton"));


    public DeviceHomeScreen unlock(){
        Logger.info("Unlocking device, if required.");
        if (lockIcon.isPresent()) {
            EggplantElement unlockSlider = new EggplantElement(By.Image("KindleTablet/KindleFireHDX/System/Device/unlockButton"));
            //lockIcon.dragTo(unlockSlider);
            lockIcon.swipeLeft();
            Logger.info("Device unlocked.");
        }

    return new DeviceHomeScreen();
    }
}
