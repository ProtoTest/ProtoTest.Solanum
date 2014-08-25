package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.*;

/**
 *
 */
public class KindleMovieFinder {
    private final String movieLocationTemplate = "KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/OnDemandPage/MovieHotspot%d";

    private final EnterPasscodePopup popups = new EnterPasscodePopup();
    private String getMovieLocator(int i) {
        return String.format(movieLocationTemplate, i);
    }

    public DishAnywhereMovie findMovie(String movieTitle) {
        return findMovie(movieTitle, null);
    }

    public DishAnywhereMovie findMovie(String movieTitle, String passcode) {
        for (int i = 0; i < 10; i++ ) {

            DishAnywhereMovie dishAnywhereMovie = openMovie(i, passcode);
            if (new EggplantElement(movieTitle, By.Text(movieTitle, SearchRectangle.Quadrants.MIDDLE_HALF)).isPresent()) { /*new SearchRectangle(new Point(0, (int) (EggplantTestBase.driver.getScreenSize().y*0.2)), new Point(EggplantTestBase.driver.getScreenSize().x, EggplantTestBase.driver.getScreenSize().y*.5)*//*))).isPresent()) {*/
                return dishAnywhereMovie;
            } else {
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
        movie.click();
        DishAnywhereMovie DANYmovie = new DishAnywhereMovie();
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

        return DANYmovie;
    }

}
