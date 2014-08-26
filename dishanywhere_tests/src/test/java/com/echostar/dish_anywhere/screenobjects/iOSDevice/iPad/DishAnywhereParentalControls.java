//package com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad;
//
//import com.prototest.solanum.By;
//import com.prototest.solanum.EggplantElement;
//import com.prototest.solanum.SearchRectangle;
//
///**
// * Created by Brian on 6/4/2014.
// */
//public class DishAnywhereParentalControls extends DishAnywhereSettings {
//    public EggplantElement tvyCheckbox = new EggplantElement("tvyCheckbox", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVYOption"));
//    public EggplantElement tvy7Checkbox = new EggplantElement("tvy7Checkbox", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVY7FVOption"));
//    public EggplantElement tvy7fvCheckbox = new EggplantElement("tvy7fvCheckbox", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVGOption"));
//    public EggplantElement tvgCheckbox = new EggplantElement("tvgCheckbox", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVPGOption"));
//    public EggplantElement tvpgCheckbox = new EggplantElement("tvpgCheckbox", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVGOption"));
//    public EggplantElement tv14Checkbox = new EggplantElement("tv14Checkbox", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TV14Option"));
//    public EggplantElement tvmaCheckbox = new EggplantElement("tvmaCheckbox", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVMAOption"));
//    public EggplantElement unratedTvCheckbox = new EggplantElement("unratedTvCheckbox", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/UnratedOption", SearchRectangle.Quadrants.LEFT_QUARTER));
//    public EggplantElement tvyChecked = new EggplantElement("tvyChecked", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVYChecked"));
//    public EggplantElement tvmaChecked = new EggplantElement("tvmaChecked", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/ShowRatingsOptions/TVMAChecked"));
//
//
//    public EggplantElement gCheckbox = new EggplantElement("gCheckbox", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/GOption"));
//    public EggplantElement pgCheckbox = new EggplantElement("pgCheckbox", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/PGOption"));
//    public EggplantElement pg13Checkbox = new EggplantElement("pg13Checkbox", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/PG13Option"));
//    public EggplantElement rCheckbox = new EggplantElement("rCheckbox", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/ROption"));
//    public EggplantElement nc17Checkbox = new EggplantElement("nc17Checkbox", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/NC17Option"));
//    public EggplantElement nraoCheckbox = new EggplantElement("nraoCheckbox", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/NRAOOption"));
//    public EggplantElement unratedMovieCheckbox = new EggplantElement("unratedMovieCheckbox", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/Unrated", SearchRectangle.Quadrants.RIGHT_HALF));
//
//    public EggplantElement gChecked = new EggplantElement("gChecked", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/GChecked"));
//    public EggplantElement nraoChecked = new EggplantElement("nraoChecked", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/MovieRatingsOptions/NRAOChecked"));
//
//    public EggplantElement saveButton = new EggplantElement("saveButton", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/SaveButton"));
//    public EggplantElement changePasscodeButton = new EggplantElement("changePasscodeButton", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/ChangePasscode"));
//    public EggplantElement chooseSecurityQuestionButton = new EggplantElement("chooseSecurityQuestionButton", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControls/ChooseSecurityQuestionButton"));
//
//    public EggplantElement okButton = new EggplantElement(By.Text("OK"));
//
//    public DishAnywhereParentalControls clickRating(String value) {
//        EggplantElement rating = new EggplantElement(By.Text(value));
//        rating.click();
//        return this;
//    }
//
//    public DishAnywhereParentalControls clearTVBlocks() {
//        if (tvmaChecked.isPresent())
//            tvmaCheckbox.click();
//        return this;
//    }
//
//
//    public DishAnywhereParentalControls setTVYBlocked() {
//        if (!tvyChecked.isPresent())
//            tvyCheckbox.click();
//        return this;
//    }
//
//    public DishAnywhereParentalControls clearMovieBlocks() {
//        if (nraoChecked.isPresent())
//            nraoCheckbox.click();
//        return this;
//    }
//
//
//    public DishAnywhereParentalControls setMovieGBlocked() {
//        if (!gChecked.isPresent())
//            gCheckbox.click();
//        return this;
//    }
//
//    public DishAnywhereParentalControls save() {
//        saveButton.click();
//        okButton.click();
//        return this;
//    }
//
//    public DishAnywhereParentalControls changePasscode(String passcode) {
//        changePasscodeButton.click();
//        EnterPasscodePopup popup = new EnterPasscodePopup();
//        popup.enterPasscode(passcode);
//        popup.enterPasscode(passcode);
//        okButton.click();
//        return this;
//    }
//
//
//}
