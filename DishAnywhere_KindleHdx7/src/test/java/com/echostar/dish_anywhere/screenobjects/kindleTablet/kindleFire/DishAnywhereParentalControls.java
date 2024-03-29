package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.*;

public class DishAnywhereParentalControls extends DishAnywhereSettings {

    public EggplantElement tvyCheckbox = new EggplantElement("tvyCheckbox", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVYOption"));
    public EggplantElement tvy7Checkbox = new EggplantElement("tvy7Checkbox", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVY7FVOption"));
    public EggplantElement tvy7fvCheckbox = new EggplantElement("tvy7fvCheckbox", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVGOption"));
    public EggplantElement tvgCheckbox = new EggplantElement("tvgCheckbox", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVGOption"));
    public EggplantElement tvpgCheckbox = new EggplantElement("tvpgCheckbox", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVGOption"));
    public EggplantElement tv14Checkbox = new EggplantElement("tv14Checkbox", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TV14Option"));
    public EggplantElement tvmaCheckbox = new EggplantElement("tvmaCheckbox", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVMAOption"));
    public EggplantElement unratedTvCheckbox = new EggplantElement("unratedTvCheckbox", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/UnratedOption",SearchRectangle.Quadrants.LEFT_QUARTER));
    public EggplantElement tvyChecked = new EggplantElement("tvyChecked", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVYChecked"));
    public EggplantElement tvmaChecked = new EggplantElement("tvmaChecked", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVMAChecked"));
    public EggplantElement tv14checked = new EggplantElement("tvmaChecked", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TV14Checked"));

    public EggplantElement gCheckbox = new EggplantElement("gCheckbox", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/GOption"));
    public EggplantElement pgCheckbox = new EggplantElement("pgCheckbox", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/PGOption"));
    public EggplantElement pg13Checkbox = new EggplantElement("pg13Checkbox", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/PG13Option"));
    public EggplantElement rCheckbox = new EggplantElement("rCheckbox", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/ROption"));
    public EggplantElement nc17Checkbox = new EggplantElement("nc17Checkbox", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/NC17Option"));
    public EggplantElement nraoCheckbox = new EggplantElement("nraoCheckbox", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/NRAOOption"));
    //public EggplantElement unratedMovieCheckbox = new EggplantElement("unratedMovieCheckbox", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/Unrated", SearchRectangle.rightHalf()));

    public EggplantElement gChecked = new EggplantElement("gChecked", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/GChecked"));
    public EggplantElement nraoChecked = new EggplantElement("nraoChecked", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/NRAOChecked"));

    public EggplantElement saveButton = new EggplantElement("saveButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/SaveButton"));
    public EggplantElement changePasscodeButton = new EggplantElement("changePasscodeButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/ChangePasscode"));
    public EggplantElement chooseSecurityQuestionButton = new EggplantElement("chooseSecurityQuestionButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControls/ChooseSecurityQuestionButton"));

    public EggplantElement okButton = new EggplantElement("okButton", By.Text("OK"));


    public DishAnywhereParentalControls clickRating(String value){
        EggplantElement rating = new EggplantElement("rating", By.Text(value));
        rating.click();
        return this;
    }

    public DishAnywhereParentalControls clearTVBlocks() {
        Logger.info("Clearing tv blocks...");
        tvgCheckbox.swipeUp(ActionCondition.isPresent(tvmaCheckbox));
        if (tvmaChecked.isPresent())
            tvmaCheckbox.click();
        return this;
    }

    public DishAnywhereParentalControls setTVYBlocked() {
        Logger.info("Setting TV blocks...");
        tvgCheckbox.swipeDown(ActionCondition.isPresent(tvyCheckbox));
        if (!tvyChecked.isPresent())
            tvyCheckbox.click();
        return this;
    }

    public DishAnywhereParentalControls clearMovieBlocks() {
        Logger.info("Clearing movie blocks...");
        rCheckbox.swipeUp(ActionCondition.isPresent(nraoCheckbox));
        if (nraoChecked.isPresent())
            nraoChecked.click();
        return this;
    }

    public DishAnywhereParentalControls setMovieGBlocked() {
        Logger.info("Setting movie blocks...");
        rCheckbox.swipeDown(ActionCondition.isPresent(gCheckbox));
        if (!gChecked.isPresent())
            gCheckbox.click();
        return this;
    }

    public DishAnywhereParentalControls save(){
        Logger.info("Saving parental controls...");
        saveButton.click();
        okButton.click();
        return this;
    }

    public DishAnywhereParentalControls changePasscode(String passcode){
        Logger.info("Changing parental password to " + passcode);
        changePasscodeButton.click();
        EnterPasscodePopup popup = new EnterPasscodePopup();
        popup.enterPasscode(passcode);
        popup.enterPasscode(passcode);
        okButton.click();
        return this;
    }

}
