package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.*;

import java.util.Arrays;
import java.util.List;

public class DishAnywhereScrollView extends DishAnywhereMain {

    EggplantElement leftMovieBorder = new EggplantElement("leftMovieBorder", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/OnDemandPage/MovieLeftBorder"));
    EggplantElement sortFilterButton = new EggplantElement("sortFilterButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/OnDemandPage/SortFilterOptions/SortFilterButton"));
    KindleMovieFinder movieFinder = new KindleMovieFinder();

    public FilterPopup openFilter() {
        sortFilterButton.click();
        return new FilterPopup();
    }

    public DishAnywhereMovie openMovie(String movieName) {
        List<EggplantElement> movies = leftMovieBorder.allInstances();
        for (EggplantElement movie : movies) {
            movie.click();
            DishAnywhereMovie dishAnywhereMovie = new DishAnywhereMovie();
            if (new EggplantElement(movieName, By.Text(movieName, SearchRectangle.middleHalf())).isPresent()) {
                return dishAnywhereMovie;
            } else {
                dishAnywhereMovie.closeMovie();
            }
        }
        throw new RuntimeException("Movie " + movieName + " was not found in search results!");
    }

    public EnterPasscodePopup openProtectedMovie(String movieName) {
        List<EggplantElement> movies = leftMovieBorder.allInstances();
        for (EggplantElement movie : movies) {
            movie.click();
            DishAnywhereMovie dishAnywhereMovie = new DishAnywhereMovie();
            if (new EggplantElement(movieName, By.Text(movieName, SearchRectangle.middleHalf())).isPresent()) {
                return new EnterPasscodePopup();
            } else {
                dishAnywhereMovie.closeMovie();
            }
        }
        throw new RuntimeException("Movie " + movieName + " was not found in search results!");
    }

    public DishAnywhereScrollView verifyTitlesPresent(List<String> titles) {
        String logMessage = "Verifying movies from radish are present: " + titles.get(0);
        for (String title : titles) {
            logMessage += ", " + title;
        }
        Logger.info(logMessage);
        popups.waitForScreenToLoad();


        for (int i = 0; i < titles.size(); i++) {
            DishAnywhereMovie movie = movieFinder.openMovie(i);
            String searchingFor = titles.get(0);
            Verifications.addVerification(String.format("Movie %s is present.", searchingFor),
                    new EggplantElement("Movie title: " + searchingFor, By.Text(searchingFor, SearchRectangle.middleHalf())).isPresent());
            movie.closeMovie();
        }
        return this;
    }

    private String truncateTitle(String title, int maxChars) {
        List<String> words = Arrays.asList(title.split(" "));
        StringBuilder newTitle = new StringBuilder(words.get(0));
        for (String word : words.subList(1, words.size())) {
            if (newTitle.length() + 1 + word.length() < maxChars) {
                newTitle.append(" " + word);
            } else {
                break;
            }
        }
        return newTitle.toString();
    }


}
