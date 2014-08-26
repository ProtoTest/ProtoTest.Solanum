package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DishAnywhereScrollView extends DishAnywhereMain {

    EggplantElement leftMovieBorder = new EggplantElement("leftMovieBorder", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/OnDemandPage/MovieLeftBorder"));
    EggplantElement sortFilterButton = new EggplantElement("sortFilterButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/OnDemandPage/SortFilterOptions/SortFilterButton"));
    KindleMovieFinder movieFinder = new KindleMovieFinder();


    public FilterPopup openFilter() {
        Logger.info("Opening filter popup");
        sortFilterButton.click();
        return new FilterPopup();
    }

    public DishAnywhereMovie openMovie(String movieName) {
        Logger.info("Opening movie with title: " + movieName);
        List<EggplantElement> movies = leftMovieBorder.allInstances();
        for (EggplantElement movie : movies) {
            movie.click();
            DishAnywhereMovie dishAnywhereMovie = new DishAnywhereMovie();
            if (new EggplantElement(movieName, By.Text(movieName)).isPresent()) {
                return dishAnywhereMovie;
            } else {
                dishAnywhereMovie.closeMovie();
            }
        }
        throw new RuntimeException("Movie " + movieName + " was not found in search results!");
    }

    public DishAnywhereMovie openProtectedMovie(String movieName, String passcode){
        Logger.info("Opening movie title with expected passcode popup: " + movieName);
        return movieFinder.findMovie(movieName, passcode);
    }

    public DishAnywhereScrollView verifyTitlesPresent(List<String> titles) {
        String logMessage = "Verifying movies from radish are present: " + titles.get(0);
        for (String title : titles.subList(1, titles.size() - 1)) {
            logMessage += ", " + title;
        }
        Logger.info(logMessage);
        popups.waitForScreenToLoad();

        List<String> notFound = new ArrayList<String>(titles);
        for (int i = 0; i < titles.size(); i++) {
            DishAnywhereMovie movie = movieFinder.openMovie(i);
            String searchingFor = titles.get(i);
            boolean passes = false;
            // Search directly for the title we seek.
            if (new EggplantElement("Movie title" + searchingFor, By.Text(searchingFor, SearchRectangle.Quadrants.TOP_HALF)).isPresent()) {
                Logger.info("Found movie title: (" + searchingFor + ") on screen");
                passes = true;
                notFound.remove(searchingFor);
            } else {
                Logger.error(String.format("Expected movie (%s) to appear in position (%d)", searchingFor, i));
                Verifications.addVerification(String.format("Movie %s should appear in position %d", searchingFor, i), false, false);
                // If a direct search fails, get the text in the title position and see if it matches anything in the titles list.
                String foundTitle = movie.getTitle();
                Logger.info("Read movie title " + foundTitle + " from movie details dialog");
                if (foundTitle.length() > 5) {
                    for (int j = 0; j < titles.size(); j++) {
                        // If the
                        if (titles.get(j).toLowerCase().contains(foundTitle.toLowerCase())) {
                            Logger.info("Matched movie " + titles.get(j) + " to found partial title " + foundTitle);
                            passes = true;
                            notFound.remove(titles.get(j));
                            break;
                        }
                    }
                }
            }

            Verifications.addVerification(String.format("Movie %s should be present.", searchingFor), passes, false);
            movie.closeMovie();
        }
        for (String notFoundTitle : notFound) {
            Verifications.addVerification(String.format("Movie %s should be present.", notFoundTitle), false, false);
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
