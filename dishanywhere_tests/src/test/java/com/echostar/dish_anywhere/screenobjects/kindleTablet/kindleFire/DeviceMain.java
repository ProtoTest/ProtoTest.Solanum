package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.*;

import java.awt.*;
import java.util.*;
import java.util.List;

// Screen Object for Device's MainScreen ViewGroup

public class DeviceMain {
    protected EggplantElement closeKeyboardButton = new EggplantElement("closeKeyboardButton", By.Image("KindleTablet/KindleFireHDX/System/Device/closeKeyboardButton"));
    protected EggplantElement keyboardDeleteKey = new EggplantElement("keyboardDeleteKey", By.Image("KindleTablet/KindleFireHDX/System/Keyboard/DeleteKey"));
    protected EggplantElement dishAnywhereApp = new EggplantElement("Anywhere App", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/DishAnywhereAppIcon"));
    protected EggplantElement appsTab = new EggplantElement("Kindle Apps Tab", By.Text("Apps", SearchRectangle.topHalf()));

    protected EggplantElement settingsButton = new EggplantElement("System settings button", By.Image("KindleTablet/KindleFireHDX/System/Menus/SettingsButton", SearchRectangle.topHalf()));
    protected EggplantElement applicationsButton = new EggplantElement("System settings device button", By.Image("KindleTablet/KindleFireHDX/System/Menus/Applications"));
    protected EggplantElement manageAllApplicationsButton = new EggplantElement("Manage all applications button", By.Image("KindleTablet/KindleFireHDX/System/Menus/ManageAllApplications"));
    protected EggplantElement dishThumbnail = new EggplantElement("Dish application thumbnail", By.Image("KindleTablet/KindleFireHDX/System/Menus/DishThumbnail"));
    protected EggplantElement forceStopButton = new EggplantElement("Application stop button", By.Image("KindleTablet/KindleFireHDX/System/Menus/ForceStop"));

    public final DeviceNavigation nav = new DeviceNavigation();

    public DishAnywhereHome goHome() {
        nav.homeButton.click();
        killApp();
//        EggplantTestBase.driver.swipeDown(new Point(10, 1));
//        settingsButton.click();
//        applicationsButton.click();
//        manageAllApplicationsButton.click();
//        Point swipePoint = new Point(20, (int) (EggplantTestBase.driver.getScreenSize().y * 0.8));
//        Point swipeEndPoint = new Point(20, (int) (EggplantTestBase.driver.getScreenSize().y * 0.72));
//
//        for (int attempt = 0; attempt < 10 && !dishThumbnail.isPresent(); attempt++) {
//            List<EggplantElement> handles = applicationsSwipeLocation.allInstances();
//            EggplantElement firstHandle = handles.get(0);
//            EggplantElement lastHandle = handles.get(handles.size() - 1);
//            Logger.info("Dragging from " + lastHandle.getBy().getLocator() + " to " +
//                    firstHandle.getBy().getLocator());
//
//            lastHandle.dragTo(firstHandle);
//        }
//        dishThumbnail.click();
//
//
//       forceStopButton.waitForPresent();
//            forceStopButton.click();

        nav.homeButton.click();
//        for (int i=0;i<5&&!appsTab.isPresent();i++) {
//            if (!nav.backButton.isPresent()) {
//                EggplantTestBase.driver.disconnect();
//                EggplantTestBase.driver.connect();
//            }
//            else {
//                nav.backButton.click();
//
//            }
//        }
        appsTab.click();
        dishAnywhereApp.click();
//        for (int i = 0; i < 5 && !dishAnywhereApp.isPresent(); i++) {
//            if (!nav.backButton.isPresent()) {
//                EggplantTestBase.driver.disconnect();
//                EggplantTestBase.driver.connect();
//            } else {
//                nav.backButton.click();
//
//            }
//        }
//        dishAnywhereApp.click();
        return new DishAnywhereHome();
    }

    public DeviceMain killApp() {
        nav.homeButton.click();
        for (int attempt = 0; attempt < 5 && !nav.settingsButton.isPresent(); attempt++) {
            EggplantTestBase.driver.swipeDown(new Point(EggplantTestBase.driver.getScreenSize().x / 2, 0));
        }
        nav.settingsButton.click();
        new KindleSettings().stopApplication("Anywhere");
        nav.homeButton.click();
        return new DeviceMain();
    }

    public DeviceMain clearField() {
        Logger.info("Clearing form field...");
        keyboardDeleteKey.press();
        EggplantTestBase.sleep(2500);
        keyboardDeleteKey.release();
        return new DeviceMain();
    }
}
