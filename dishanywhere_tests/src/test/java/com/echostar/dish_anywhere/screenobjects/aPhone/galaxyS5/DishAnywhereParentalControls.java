package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.*;

/**
 * Created by Brian on 6/4/2014.
 */
public class DishAnywhereParentalControls extends DishAnywhereSettings {
    public EggplantElement tvyCheckbox = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVYOption"));
    public EggplantElement tvy7Checkbox = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVY7FVOption"));
    public EggplantElement tvy7fvCheckbox = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVGOption"));
    public EggplantElement tvgCheckbox = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVPGOption"));
    public EggplantElement tvpgCheckbox = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVGOption"));
    public EggplantElement tv14Checkbox = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TV14Option"));
    public EggplantElement tvmaCheckbox = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVMAOption"));
    public EggplantElement unratedTvCheckbox = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/UnratedOption",SearchRectangle.leftHalf()));
    public EggplantElement tvyChecked = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVYChecked"));
    public EggplantElement tvmaChecked = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVMAChecked"));


    public EggplantElement gCheckbox = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/GOption"));
    public EggplantElement pgCheckbox = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/PGOption"));
    public EggplantElement pg13Checkbox = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/PG13Option"));
    public EggplantElement rCheckbox = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/ROption"));
    public EggplantElement nc17Checkbox = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/NC17Option"));
    public EggplantElement nraoCheckbox = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/NRAOOption"));
    public EggplantElement unratedMovieCheckbox = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/Unrated", SearchRectangle.rightHalf()));

    public EggplantElement gChecked = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/GChecked"));
    public EggplantElement nraoChecked = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/NRAOChecked"));

    public EggplantElement tvRatingsButton = new EggplantElement(By.Text("TV Ratings"));
    public EggplantElement movieRatingsButton = new EggplantElement(By.Text("Movie Ratings"));

    public EggplantElement saveButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/SaveButton"));
    public EggplantElement changePasscodeButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/ChangePasscode"));
    public EggplantElement chooseSecurityQuestionButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControls/ChooseSecurityQuestionButton"));

    EggplantElement okButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/OkButton"));
    public DishAnywhereParentalControls clickRating(String value){
        EggplantElement rating = new EggplantElement(By.Text(value));
        rating.click();
        return this;
    }

    public DishAnywhereParentalControls clearTVBlocks(){
        tvRatingsButton.click();
        if(tvmaChecked.isPresent())
            tvmaCheckbox.click();
        nav.backButton.click();
        if (okButton.isPresent())
            okButton.click();
        return this;
    }


    public DishAnywhereParentalControls setTVYBlocked(){
        tvRatingsButton.click();
        if(!tvyChecked.isPresent())
            tvyCheckbox.click();
        nav.backButton.click();
        if (okButton.isPresent())
            okButton.click();
        return this;
    }

    public DishAnywhereParentalControls clearMovieBlocks(){
        movieRatingsButton.click();
        if(nraoChecked.isPresent())
            nraoCheckbox.click();
        nav.backButton.click();
        if (okButton.isPresent())
            okButton.click();
        return this;
    }


    public DishAnywhereParentalControls setMovieGBlocked(){
        movieRatingsButton.click();
        if(!gChecked.isPresent())
            gCheckbox.click();
        nav.backButton.click();
        if (okButton.isPresent())
            okButton.click();
        return this;
    }

    public DishAnywhereParentalControls save(){
        saveButton.click();
        okButton.click();
        return this;
    }

    public DishAnywhereParentalControls changePasscode(String passcode){
        Logger.info("Changing passcode to:(" + passcode + ").");
        changePasscodeButton.click();
        EnterPasscodePopup popup = new EnterPasscodePopup();
        popup.enterPasscode(passcode);
        popup.enterPasscode(passcode);
        EggplantTestBase.sleep(2000);
        okButton.click();
        return this;
    }


}
