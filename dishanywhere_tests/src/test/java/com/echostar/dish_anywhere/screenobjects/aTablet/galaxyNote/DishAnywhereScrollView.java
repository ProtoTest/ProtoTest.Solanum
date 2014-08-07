package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import junit.framework.Assert;

import java.util.List;

public class DishAnywhereScrollView extends DishAnywhereMain {

    EggplantElement leftMovieBorder = new EggplantElement("leftMovieBorder", By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/OnDemandPage/LeftMovieBorder"));

    EggplantElement filterDropdownArrow = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/OnDemandPage/CloseArrowIcon"));
    EggplantElement sortFilterButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/OnDemand/OnDemandPage/SortFilterButton"));
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
        for (String title : titles) {
            logMessage += ", " + title;
        }
        Logger.info(logMessage);
        popups.waitForScreenToLoad();


        List<EggplantElement> movieElements = leftMovieBorder.allInstances();

        for (int i = 0; i < titles.size() && i < movieElements.size(); i++) {
            movieElements.get(i).click();
            EnterPasscodePopup popup = new EnterPasscodePopup();
            if(popup.isPresent()){
                Assert.fail("THe passcode popup was present for '" + titles.get(i) + "' and it should not be.  This is a known defect with te DishAnywhere app.");
            }
            DishAnywhereMovie dishAnywhereMovie = new DishAnywhereMovie();
            String title = titles.get(i);
            new EggplantElement(title, By.Text(title)).verifyPresent();
            dishAnywhereMovie.closeMovie();
        }
        return this;
    }




}
