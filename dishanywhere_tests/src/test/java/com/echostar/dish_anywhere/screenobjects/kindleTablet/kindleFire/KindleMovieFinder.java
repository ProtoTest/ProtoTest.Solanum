package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.SearchRectangle;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andar
 * Date: 8/7/14
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class KindleMovieFinder {
    private final String movieLocationTemplate = "C:/Users/andar/Documents/GitHub/ProtoTest.Solanum/EggplantSuites/DishAnywhere.suite/Images/KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/OnDemandPage/MovieHotspot%d";

    private String getMovieLocator(int i) {
        return String.format(movieLocationTemplate, i);
    }

    public DishAnywhereMovie findMovie(String movieTitle) {

        for (int i = 0; i < 10; i++ ) {

            DishAnywhereMovie dishAnywhereMovie = openMovie(i);
            if (new EggplantElement(movieTitle, By.Text(movieTitle, SearchRectangle.middleHalf())).isPresent()) {
                return dishAnywhereMovie;
            } else {
                dishAnywhereMovie.closeMovie();
            }
        }
        throw new RuntimeException("Movie " + movieTitle + " was not found in search results!");
    }

    public DishAnywhereMovie openMovie(int position) {
        EggplantElement movie = new EggplantElement("Movie location " + position+1, By.Image(getMovieLocator(position+1)));
        movie.click();
        DishAnywhereMovie DANYmovie = new DishAnywhereMovie();
        DANYmovie.closeButton.waitForPresent();
        return DANYmovie;
    }

}
