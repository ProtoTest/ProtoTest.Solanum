package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.*;

import java.util.Arrays;
import java.util.List;

public class DishAnywhereScrollView extends DishAnywhereMain {

    EggplantElement leftMovieBorder = new EggplantElement("leftMovieBorder", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/OnDemandPage/MovieLeftBorder"));
    EggplantElement sortFilterButton = new EggplantElement("sortFilterButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/OnDemandPage/SortFilterOptions/SortFilterButton"));
    public FilterPopup openFilter(){
        sortFilterButton.click();
        return new FilterPopup();
    }
    public DishAnywhereMovie openMovie(String name){
        EggplantElement movie  = new EggplantElement("movie", By.Text(name));
        movie.waitForPresent(30).click();
        return new DishAnywhereMovie();
    }
    public EnterPasscodePopup openProtectedMovie(String name){
        EggplantElement movie  = new EggplantElement("movie", By.Text(name));
        movie.waitForPresent().click();
        return new EnterPasscodePopup();
    }

    public DishAnywhereScrollView verifyTitlesPresent(List<String> titles){
        String logMessage = "Verifying movies from radish are present: " + titles.get(0);
        for (String title : titles) {
            logMessage += ", " + title;
        }
        Logger.info(logMessage);
        popups.waitForScreenToLoad();


        List<EggplantElement> movieElements = leftMovieBorder.allInstances();

        for (int i = 0; i < movieElements.size(); ++i) {
            movieElements.get(i).click();
            DishAnywhereMovie dishAnywhereMovie = new DishAnywhereMovie();
            String title = titles.get(i);
            new EggplantElement(title, By.Text(title)).verifyPresent();
            dishAnywhereMovie.closeMovie();
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


    public DishAnywhereMovie openMovie(int i) {
        List<EggplantElement> movieElements = leftMovieBorder.allInstances();
        movieElements.get(0).click();
        return new DishAnywhereMovie();
    }
}
