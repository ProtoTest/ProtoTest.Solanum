package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.*;

import java.util.List;

/**
 */
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
        popups.waitForScreenToLoad();
        List<EggplantElement> movieArrows = movieArrow.allInstances();
        for (int i = 0; i < movieArrows.size(); i++) {
            movieArrows.get(i).click();
            EggplantElement movie = new EggplantElement(By.Text(titles.get(i)));
            movie.verifyPresent();
            nav.backButton.click();
        }
        return this;
    }


    public FilterPopup openFilters() {
        filterButton.click();
        return new FilterPopup();
    }
}
