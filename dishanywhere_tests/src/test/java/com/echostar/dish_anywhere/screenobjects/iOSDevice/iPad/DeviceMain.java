//package com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad;
//
//import com.prototest.solanum.*;
//
//// Screen Object for Device's MainScreen ViewGroup
//
//public class DeviceMain {
//    protected EggplantElement homeScreenIcon = new EggplantElement("homeScreenIcon", By.Image("iosTablet/iPadAir/System/Screens/homeScreenIcon"));
//    protected EggplantElement closeKeyboardButton = new EggplantElement("closeKeyboardButton", By.Image("iosTablet/iPadAir/System/Keyboard/closeKeyboardButton"));
//    protected EggplantElement keyboardDeleteKey = new EggplantElement("keyboardDeleteKey", By.Image("iosTablet/iPadAir/System/Keyboard/DeleteKey"));
//    protected EggplantElement usbConnectedIcon = new EggplantElement("usbConnectedIcon", By.Image("iosTablet/iPadAir/System/Device/usbConnectedIcon"));
//    protected EggplantElement dishAnywhereApp = new EggplantElement("Anywhere App", By.Image("iosTablet/iPadAir/System/Apps/DishAnywhereIcon"));
//    protected EggplantElement dishAnywhereTaskIcon = new EggplantElement("Anywhere Task Icon", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/TaskIcon",SearchRectangle.Quadrants.LEFT_QUARTER));
//    protected EggplantElement removeFromListButton = new EggplantElement("Remove from list button", By.Image("iosTablet/iPadAir/System/Device/RemoveFromList", SearchRectangle.Quadrants.LEFT_QUARTER));
//
//    public final DeviceNavigation nav = new DeviceNavigation();
//
////    public DeviceMain VerifyElements() {
////        Logger.info("Verifying main device screen elements...");
////        homeScreenIcon.waitForPresent();
////        usbConnectedIcon.waitForPresent();
////        return this;
////    }
//
//    public DeviceMain goHomeScreen() {
//        Logger.info("Returning to main device screen...");
////        if (closeKeyboardButton.isPresent()) {
////            closeKeyboardButton.tap();
////        }
//        //nav.homeButton.waitForPresent(20).click();
//        nav.homeButton();
//
//        EggplantTestBase.driver.refreshScreen();
//        return new DeviceMain();
//    }
//
//    public DeviceMain killApp(){
////        if(dishAnywhereTaskIcon.isPresent())
////            dishAnywhereTaskIcon.swipeRight();
//        return goHome();
//    }
//
//    public DishAnywhereHome goHome() {
//        goHomeScreen();
//        dishAnywhereApp.waitForPresent(30).click();
//        EggplantTestBase.driver.refreshScreen();
//
//        return new DishAnywhereHome();
//    }
//
//    public DeviceMain clearField(){
//        Logger.info("Clearing form field...");
//        keyboardDeleteKey.press();
//        EggplantTestBase.sleep(2500);
//        keyboardDeleteKey.release();
//        return new DeviceMain();
//    }
//}
