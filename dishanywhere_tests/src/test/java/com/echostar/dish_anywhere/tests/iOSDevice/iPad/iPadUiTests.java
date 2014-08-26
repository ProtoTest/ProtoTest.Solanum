//package com.echostar.dish_anywhere.tests.iOSDevice.iPad;
//import com.echostar.dish_anywhere.radish.RadishScraper;
//import com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad.DeviceMain;
//import com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad.DishAnywhereHome;
//import com.prototest.solanum.*;
//import org.testng.annotations.Test;
//
//// DishAnywhere UI Tests - Galaxy Note 10.1 (Android Tablet)
//
//public class iPadUiTests extends EggplantTestBase {
//
//    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
//    public void testLogoutAndLogin() {
//        Logger.info("Beginning Test: Logout and Login.");
//        new DeviceMain()
//                .goHome()
//                .killApp()
//                .goHome()
//                .logOutIfLoggedIn()
//                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
//                .verifyLoggedIn()
//                .logOutIfLoggedIn()
//                .verifyLoggedOut();
//        Verifications.assertVerifications();
//
//    }
//    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
//    public void testPredictiveSearch() {
//        RadishScraper radishScraper = new RadishScraper();
//        radishScraper.getMovies();
//        String movie = radishScraper.findMovieWithDrm("nagra");
//
//        new DishAnywhereHome()
//                .openOnDemand()
//                .verifyPredictiveSearch(movie)
//                .openMovie(movie)
//                .watchMovie()
//                .verifyMoviePlays();
//    }
//}
