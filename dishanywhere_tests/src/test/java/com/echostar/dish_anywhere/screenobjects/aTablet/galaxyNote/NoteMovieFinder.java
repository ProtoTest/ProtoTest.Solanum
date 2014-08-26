package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.*;

import java.awt.*;

public class NoteMovieFinder {

    private final String movieLocationTemplate = "AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/OnDemandPage/MovieHotspot%d";
    private final EnterPasscodePopup popups = new EnterPasscodePopup();
    private final SearchRectangle titleSearchAreaRect = new SearchRectangle(new Point(250,50), new Point(1030,290));

    private String getMovieLocator(int i) {
        return String.format(movieLocationTemplate, i);
    }

    public DishAnywhereMovie findMovie(String movieTitle) {
        return findMovie(movieTitle, null);
    }

    public DishAnywhereMovie findMovie(String movieTitle, String passcode) {
        for (int i = 0; i < 10; i++ ) {
            DishAnywhereMovie dishAnywhereMovie = openMovie(i, passcode);
            Logger.info(String.format("Clicking on position (%s) and scanning screen for movie title: (%s)...", i + 1, movieTitle));
            if (new EggplantElement(movieTitle, By.Text(movieTitle, TextOption.searchRectangle(titleSearchAreaRect))).isPresent()) { /*new SearchRectangle(new Point(0, (int) (EggplantTestBase.driver.getScreenSize().y*0.2)), new Point(EggplantTestBase.driver.getScreenSize().x, EggplantTestBase.driver.getScreenSize().y*.5)*//*))).isPresent()) {*/
                Logger.info(String.format("Found movie (%s) in position (%d)", movieTitle, i+1));
                return dishAnywhereMovie;
            } else if (dishAnywhereMovie.getTitle().equals(movieTitle)) {
                Logger.info(String.format("Titles match. Found movie (%s) in position (%d)", movieTitle, i+1));
                return dishAnywhereMovie;
            } else {
                Logger.info(String.format("Could not find movie (%s) in position (%d).", movieTitle, i+1));
                dishAnywhereMovie.closeMovie();
            }
        }
        throw new RuntimeException("Movie " + movieTitle + " was not found in search results!");
    }

    public DishAnywhereMovie openMovie(int position) {
        return openMovie(position, null);
    }

    public DishAnywhereMovie openMovie(int position, String passcode) {
        EggplantElement movie = new EggplantElement("Movie location " + (position+1), By.Image(getMovieLocator(position+1)));
        DishAnywhereMovie DANYmovie = new DishAnywhereMovie();
        movie.click();
        boolean passcodePopupIsPresent = popups.isPresent();
        if (passcode != null) {
            Verifications.addVerification("Passcode prompt should appear", passcodePopupIsPresent);
            if (passcodePopupIsPresent) {
                popups.enterPasscode(passcode);
            }
        } else {
            if (passcodePopupIsPresent) {
                Logger.error("Passcode prompt should not be on screen, but it is. Guessing passcode from config values: " + Config.getTestProp("dishAnywherePassCode"));
                popups.enterPasscode(Config.getTestProp("dishAnywherePassCode"));
            }
        }
        DANYmovie.closeButton.waitForPresent();
        return DANYmovie;
    }

}
