package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.Verifications;

import java.util.ArrayList;
import java.util.List;

public class DishAnywhereScrollView extends DishAnywhereMain {

    EggplantElement leftMovieBorder = new EggplantElement("leftMovieBorder", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/OnDemandPage/LeftMovieBorder"));
    EggplantElement filterDropdownArrow = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/OnDemandPage/CloseArrowIcon"));
    EggplantElement sortFilterButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/OnDemandPage/SortFilterButton"));
    NoteMovieFinder movieFinder = new NoteMovieFinder();

    public FilterPopup openFilter(){
        sortFilterButton.click();
        return new FilterPopup();
    }
    public DishAnywhereMovie openMovie(String name){
        EggplantElement movie  = new EggplantElement(By.Text(name));
        movie.waitForPresent(30).click();
        return new DishAnywhereMovie();
    }
    public EnterPasscodePopup openProtectedMovie(String name){
        EggplantElement movie  = new EggplantElement(By.Text(name));
        movie.waitForPresent(30).click();
        return new EnterPasscodePopup();
    }

    public DishAnywhereScrollView verifyTitlesPresent(List<String> titles){
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
                Verifications.addVerification(String.format("Movie %s should appear in position %d", searchingFor, i), false);
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

            Verifications.addVerification(String.format("Movie %s should be present.", searchingFor), passes);

            //boolean passes = new EggplantElement("Movie title: " + searchingFor, By.Text(searchingFor/*, SearchRectangle.middleHalf()*/)).isPresent();
            //Verifications.addVerification(String.format("Movie %s should be present.", searchingFor), passes);
            movie.closeMovie();
        }
//        for (String foundTitle : foundTitles) {
//            Verifications.addVerification(String.format("Movie %s should be present.", foundTitle), true);
//        }
        for (String notFoundTitle : notFound) {
            Verifications.addVerification(String.format("Movie %s should be present.", notFoundTitle), false);
        }
        return this;
    }




}
