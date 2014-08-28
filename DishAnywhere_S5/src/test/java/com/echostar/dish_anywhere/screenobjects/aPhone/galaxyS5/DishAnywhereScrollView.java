package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.*;

import java.util.ArrayList;
import java.util.List;

public class DishAnywhereScrollView extends DishAnywhereMain {

    EggplantElement movieArrow  = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/OnDemand/MovieArrow"));
    EggplantElement contentLock = new EggplantElement(By.Text("Enter Passcode"));
    EggplantElement filterButton = new EggplantElement(By.Text("Filter"));


    public void scroll() {
        List<EggplantElement> arrows = movieArrow.allInstances();
        arrows.get(arrows.size()-1).dragTo(arrows.get(0));
    }

    public DishAnywhereMovie openMovie(int i) {
        List<EggplantElement> arrows = movieArrow.allInstances();
        arrows.get(0).click();
        popups.enterPasscodeIfNeeded();
        return new DishAnywhereMovie();
    }
    public DishAnywhereMovie openMovie(String name){
        EggplantElement movie  = new EggplantElement(By.Text(name));
        movie.click();
        return new DishAnywhereMovie();
    }
    public EnterPasscodePopup openProtectedMovie(String name){
        EggplantElement movie  = new EggplantElement(By.Text(name));
        movie.click();
        return new EnterPasscodePopup();
    }

    public DishAnywhereScrollView verifyTitlesPresent(List<String> titles){
        String logMessage = "Verifying movies from radish are present: [" + titles.get(0) + "].";
        for (String title : titles.subList(1, titles.size() - 1)) {
            logMessage += ", (" + title + ")";
        }
        Logger.info(logMessage);
        popups.waitForScreenToLoad();
        List<EggplantElement> movieArrows = movieArrow.allInstances();

        List<String> notFound = new ArrayList<String>(titles);
        for (int i = 0; i < titles.size(); i++) {
            Logger.info("Looking for movie title (" + titles.get(i) + ") in position ("+ (i+1) + ").");
            boolean passes = false;
            movieArrows.get(i).click();
            String searchingFor = titles.get(i);
            EggplantElement movieTitle = new EggplantElement(By.Text(searchingFor));
            EnterPasscodePopup passcode = new EnterPasscodePopup();
            if(passcode.isPasscodePresent()){
                Logger.error("Passcode present for movie: (" + titles.get(i).toString() + ") when it should not be.");
                passcode.enterPasscode(Config.getTestProp("dishAnywherePassCode"));
            }
            if (movieTitle.isPresent()) {
                Logger.info("Found movie title (" + searchingFor + ") on screen.");
                passes = true;
                notFound.remove(searchingFor);
            } else {
                Logger.error(String.format("Expected movie (%s) to appear in position (%d)", searchingFor, i));
                Verifications.addVerification(String.format("Movie (%s) should appear in position (%d).", searchingFor, i), false, false);
                Logger.info("Trying to match any other movie in the movies list.");
                for (String title : notFound) {
                    if (new EggplantElement(By.Text(title, TextOption.waitFor(5))).isPresent()) {
                        Logger.info("Matched out of order movie: (" + title + ").");
                        passes = true;
                        notFound.remove(title);
                        break;
                    }
                }

            }
            Verifications.addVerification(String.format("Movie (%s) should be present.", searchingFor), passes, false);
            nav.backButton.click();
        }
        for (String notFoundTitle : notFound) {
            Verifications.addVerification(String.format("Movie (%s) should be present.", notFoundTitle), false, false);
        }
        return this;
    }

    public FilterPopup openFilters() {
        filterButton.click();
        return new FilterPopup();
    }

}