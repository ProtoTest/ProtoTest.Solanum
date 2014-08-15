//package com.echostar.dish_anywhere.tests.iOSDevice.iPad;
//
//import com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad.DeviceMain;
//import com.prototest.solanum.Config;
//import com.prototest.solanum.EggplantTestBase;
//
///**
// */
//public class iPadTestBase extends EggplantTestBase {
//    @Override
//    public void initializeApp() {
//        new DeviceMain()
//                .goHomeScreen()
//                .killApp()
//                .goHome()
//                .logOutIfLoggedIn()
//                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"));
//    }
//
//    @Override
//    public void uninitializeApp() {
//        new DeviceMain()
//             .nav.homeButton();
//    }
//}
