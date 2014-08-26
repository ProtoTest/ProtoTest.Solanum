//package com.echostar.dish_anywhere.tests.iOSDevice.iPad;
//
//import com.echostar.dish_anywhere.radish.RadishScraper;
//import com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad.DeviceMain;
//import com.prototest.solanum.Config;
//import com.prototest.solanum.EggplantTestBase;
//import com.prototest.solanum.SolanumRetryAnalyzer;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//// DishAnywhere UI Tests - Galaxy Note 10.1 (Android Tablet)
//
//@Test
//public class iPadOnDemandFilters extends EggplantTestBase {
//
//    private final int MOVIES_TO_TEST = 6;
//
//    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
//    public void onDemandTest() {
//        RadishScraper radishScraper = new RadishScraper();
//        List<Map<String, String>> movies = radishScraper.getFilteredMovies("comedy", RadishScraper.Device.android_tablet, 30);
//
//        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);
//
//        for (int i = 0; i < MOVIES_TO_TEST; i++) {
//            movieTitles.add(movies.get(i).get("franchiseName"));
//        }
//        new DeviceMain()
//                .goHome()
//                .killApp()
//                .goHome()
//                .logOutIfLoggedIn()
//                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
//                .openOnDemand()
//                .openMovies()
//                .openFilter()
//                .selectFilter("comedy")
//                .sortByTitle()
//                .done()
//                .verifyTitlesPresent(movieTitles);
//
//
//
//    }
//
//}
