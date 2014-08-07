package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.*;

import java.awt.*;

// Screen Object for Device's MainScreen ViewGroup

public class DeviceMain {
    protected EggplantElement closeKeyboardButton = new EggplantElement("closeKeyboardButton", By.Image("KindleTablet/KindleFireHDX/System/Device/closeKeyboardButton"));
    protected EggplantElement keyboardDeleteKey = new EggplantElement("keyboardDeleteKey", By.Image("KindleTablet/KindleFireHDX/System/Keyboard/DeleteKey"));
    protected EggplantElement dishAnywhereApp = new EggplantElement("Anywhere App", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/DishAnywhereAppIcon"));
    protected EggplantElement appsTab = new EggplantElement("Kindle Apps Tab", By.Text("Apps", SearchRectangle.Quadrants.TOP_HALF));

    public final DeviceNavigation nav = new DeviceNavigation();

    public DishAnywhereHome goHome() {
        EggplantTestBase.driver.PressHomeButton();
        if(dishAnywhereApp.isPresent()){
            dishAnywhereApp.click();
        }
        else{
            appsTab.click();
            dishAnywhereApp.click();
        }
        for (int i=0;i<5&&!dishAnywhereApp.isPresent();i++) {
            EggplantTestBase.driver.PressBackButton();
        }
        dishAnywhereApp.click();
        return new DishAnywhereHome();
    }

    public DeviceMain killApp(){
        EggplantTestBase.driver.PressHomeButton();
        EggplantTestBase.driver.swipeDown(new Point(EggplantTestBase.driver.getScreenSize().x/2,0));
        nav.settingsButton.waitForPresent(30).click();
        new KindleSettings().stopApplication("Anywhere");
        EggplantTestBase.driver.PressHomeButton();
        return new DeviceMain();
    }

      public DeviceMain clearField(){
        Logger.info("Clearing form field...");
        keyboardDeleteKey.press();
        EggplantTestBase.sleep(2500);
        keyboardDeleteKey.release();
        return new DeviceMain();
    }
}
