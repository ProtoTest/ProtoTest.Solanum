package com.prototest;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.ImageOption;

/**
 * Created by Brian on 5/20/2014.
 */
public class LockScreen extends BasePage {
      EggplantElement lockIcon = new EggplantElement(By.Image("/path"));
      EggplantElement sideOfLockIcon = new EggplantElement(By.Image("/path", ImageOption.hotSpot(new Point(-100,0))))

    public void unlock(){
        lockIcon.dragTo(sideOfLockIcon);
    }
}
