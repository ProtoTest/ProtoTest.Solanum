package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andar
 * Date: 8/7/14
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class KindleMovieFinder {
    private final String movieLocationTemplate = "KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/OnDemandPage/MovieHotspot%d";

    private final EnterPasscodePopup popups = new EnterPasscodePopup();
    private String getMovieLocator(int i) {
        return String.format(movieLocationTemplate, i);
    }

    public DishAnywhereMovie findMovie(String movieTitle) {

        for (int i = 0; i < 10; i++ ) {

            DishAnywhereMovie dishAnywhereMovie = openMovie(i);
            if (new EggplantElement(movieTitle, By.Text(movieTitle)).isPresent()) {
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
            Verifications.addVerification("Passcode prompt should not appear", !passcodePopupIsPresent);
            if (passcodePopupIsPresent) {
                Logger.warning("Passcode prompt should not be on screen, but it is. Guessing passcode from config values: " + Config.getTestProp("dishAnywherePassCode"));
                popups.enterPasscode(Config.getTestProp("dishAnywherePassCode"));
            }
        }

        return DANYmovie;
    }

}
