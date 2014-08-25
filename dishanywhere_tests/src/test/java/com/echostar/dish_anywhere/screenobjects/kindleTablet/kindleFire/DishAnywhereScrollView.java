package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.Verifications;

import java.util.ArrayList;
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
            if (new EggplantElement(movieName, By.Text(movieName)).isPresent()) {
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
            if (new EggplantElement(movieName, By.Text(movieName)).isPresent()) {
                return new EnterPasscodePopup();
            } else {
                dishAnywhereMovie.closeMovie();
            }
        }
        throw new RuntimeException("Movie " + movieName + " was not found in search results!");
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
//            for (int j = 0; j < titles.size(); j++) {
            boolean passes = false;
            // Search directly for the title we seek.
            if (new EggplantElement("Movie title: " + searchingFor, By.Text(searchingFor/*, SearchRectangle.middleHalf()*/)).isPresent()) {
                Logger.info("Found movie title " + searchingFor + " on screen");
                passes = true;
                notFound.remove(searchingFor);
            } else {
                Logger.error(String.format("Expected movie %s to appear in position %d", searchingFor, i));
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

            //boolean passes = new EggplantElement("Movie title: " + searchingFor, By.Text(searchingFor/*, SearchRectangle.middleHalf()*/)).isPresent();
            //Verifications.addVerification(String.format("Movie %s should be present.", searchingFor), passes);
            movie.closeMovie();
        }
//        for (String foundTitle : foundTitles) {
//            Verifications.addVerification(String.format("Movie %s should be present.", foundTitle), true);
//        }
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
