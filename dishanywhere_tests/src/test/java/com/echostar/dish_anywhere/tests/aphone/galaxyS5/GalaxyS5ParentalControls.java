package com.echostar.dish_anywhere.tests.aphone.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

/**
 * Created by Brian on 6/4/2014.
 */
public class GalaxyS5ParentalControls extends GalaxyS5TestBase{
    @Test
    public void clearAllBlockedContentAndPlayMovie(){
        new DishAnywhereHome()
                .openSettings()
                .openParentalControls("1111")
                .clearMovieBlocks()
                .clearTVBlocks()
                .openOnDemand()
                .openMovies()
                .openMovie("10 Years")
                .watchMovie()
                .verifyMoviePlays();
        Verifications.assertVerifications();

    }

    @Test
    public void setAllContentBlockedAndPlayMovie(){
        new DishAnywhereHome()
                .openSettings()
                .openParentalControls("1111")
                .setMovieGBlocked()
                .setTVYBlocked()
                .openOnDemand()
                .openMovies()
                .openProtectedMovie("10 Years")
                .enterPasscode("1111")
                .watchMovie()
                .verifyMoviePlays();
        Verifications.assertVerifications();

    }
}
