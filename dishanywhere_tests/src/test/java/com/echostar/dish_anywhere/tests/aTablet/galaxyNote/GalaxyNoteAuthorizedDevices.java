package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote.DishAnywhereHome;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;

public class GalaxyNoteAuthorizedDevices extends GalaxyNoteTestBase {

    @Test
    public void movieCategory(){
        RadishScraper radishScraper = new RadishScraper();
        List<Map<String, String>> movies = radishScraper.getMoviesCategory(RadishScraper.Device.android_tablet, 30);
        String movieName = RadishScraper.getShortName(movies.get(1).get("franchiseName"),25);
        new DishAnywhereHome()
                .openSettings()
                .openAuthorizedDevices()
                .deAuthorizeThisDevice()
                .openOnDemand()
                .searchFor(movieName)
                .openOnDemandResults()
                .openMovie(movieName)
                .watchMovie()
                .verifyDeauthorizationMessageDisplays()
                .goBackHome()
                .openSettings()
                .openAuthorizedDevices()
                .authorizeThisDevice()
                .openOnDemand()
                .searchFor(movieName)
                .openOnDemandResults()
                .openMovie(movieName)
                .watchMovie()
                .verifyMoviePlays()
                .goBackHome();
    }
}
