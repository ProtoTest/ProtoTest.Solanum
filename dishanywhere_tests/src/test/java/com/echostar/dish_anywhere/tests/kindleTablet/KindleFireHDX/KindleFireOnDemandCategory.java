package com.echostar.dish_anywhere.tests.kindleTablet.KindleFireHDX;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DishAnywhereScrollView;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Brian on 6/4/2014.
 */
public class KindleFireOnDemandCategory extends EggplantTestBase{

    private final int MOVIES_TO_TEST = 6;

    @Test
    public void movieCategory(){

        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory();

        List<String> movieTitles = new ArrayList<String>(MOVIES_TO_TEST);

        for (int i = 0; i < MOVIES_TO_TEST; i++) {
            movieTitles.add(movies.get(i).get("franchiseName"));
        }
        new DishAnywhereScrollView()
                .openFilter()
                .sortByTitle()
                .done()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();

    }

    @Test
    public void featuredCategory(){

        List<String> movieTitles = Arrays.asList("Edge of Tomorrow","Captain Phillips","Parkland","Prisoners","Battle of the Year","Getaway","One Direction: This is Us");

        new DeviceMain()
                .goHome()
                .openDishAnywhereHome()
                .goBackToDeviceScreen()
                .openDishAnywhereHome()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openOnDemand()
                .openFeatured()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();

    }

    @Test
    public void familyCategory(){

        List<String> movieTitles = Arrays.asList("El Chavo Animado", "Color Crew", "Joey's Toy Box", "Sweet Dreams", "Baby Class", "Bloop & Loop");

        new DeviceMain()
                .goHome()
                .openDishAnywhereHome()
                .goBackToDeviceScreen()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openOnDemand()
                .openFamily()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();

    }

    @Test
    public void tvShowsCategory(){

        List<String> movieTitles = Arrays.asList("Power", "What to Watch", "Pat & Stu", "Glenn Beck Program");

        new DeviceMain()
                .goHome()
                .openDishAnywhereHome()
                .goBackToDeviceScreen()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openOnDemand()
                .openTVShows()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();

    }

    @Test
    public void networksCategory(){

        List<String> movieTitles = Arrays.asList("BabyFirstTV", "Cinemax", "Content Media", "Cookie Jar", "Echo Bridge", "Encore");

        new DeviceMain()
                .goHome()
                .openDishAnywhereHome()
                .goBackToDeviceScreen()
                .openDishAnywhereHome()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .openOnDemand()
                .openNetworks()
                .verifyTitlesPresent(movieTitles);
        Verifications.assertVerifications();

    }
}