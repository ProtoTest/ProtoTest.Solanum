package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;

public class DishAnywhereParentalControls extends DishAnywhereSettings {

    public EggplantElement tvyCheckbox = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVYOption"));
    public EggplantElement tvy7Checkbox = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVY7FVOption"));
    public EggplantElement tvy7fvCheckbox = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVGOption"));
    public EggplantElement tvgCheckbox = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVPGOption"));
    public EggplantElement tvpgCheckbox = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVGOption"));
    public EggplantElement tv14Checkbox = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TV14Option"));
    public EggplantElement tvmaCheckbox = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVMAOption"));
    public EggplantElement tvyChecked = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVYChecked"));
    public EggplantElement tvmaChecked = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVMAChecked"));


    public EggplantElement gCheckbox = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/GOption"));
    public EggplantElement pgCheckbox = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/PGOption"));
    public EggplantElement pg13Checkbox = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/PG13Option"));
    public EggplantElement rCheckbox = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/ROption"));
    public EggplantElement nc17Checkbox = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/NC17Option"));
    public EggplantElement nraoCheckbox = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/NRAOOption"));

    public EggplantElement gChecked = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/GChecked"));
    public EggplantElement nraoChecked = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/NRAOChecked"));

    public EggplantElement saveButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/SaveButton"));
    public EggplantElement changePasscodeButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/ChangePasscode"));
    public EggplantElement chooseSecurityQuestionButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControls/ChooseSecurityQuestionButton"));

    private EggplantElement okButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/OkButton"));


    public DishAnywhereParentalControls clickRating(String value){
        EggplantElement rating = new EggplantElement(By.Text(value));
        rating.click();
        return this;
    }

    public DishAnywhereParentalControls clearTVBlocks(){
        Logger.info("Clearing TV blocks...");
        if(tvmaChecked.isPresent())
            tvmaChecked.click();
        return this;
    }

    public DishAnywhereParentalControls setTVYBlocked(){
        Logger.info("Blocking TV 'TV-Y' rating...");
        if(!tvyChecked.isPresent())
            tvyCheckbox.click();
        return this;
    }

    public DishAnywhereParentalControls clearMovieBlocks(){
        Logger.info("Clearing movie blocks...");
        if(nraoChecked.isPresent())
            nraoChecked.click();
        return this;
    }

    public DishAnywhereParentalControls setMovieGBlocked(){
        Logger.info("Blocking movie 'G' rating...");
        if(!gChecked.isPresent())
            gCheckbox.click();
        return this;
    }

    public DishAnywhereParentalControls save(){
        Logger.info("Saving parental controls settings...");
        saveButton.click();
        popups.waitForScreenToLoad();
        okButton.waitForPresent().click();
        return this;
    }

    public DishAnywhereParentalControls changePasscode(String passcode){
        Logger.info("Changing passcode to: (" + passcode + ").");
        changePasscodeButton.click();
        EnterPasscodePopup popup = new EnterPasscodePopup();
        popup.enterPasscode(passcode);
        popup.enterPasscode(passcode);
        okButton.click();
        return this;
    }

}
