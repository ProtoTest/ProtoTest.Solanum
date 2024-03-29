//package com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad;
//
//import com.prototest.solanum.By;
//import com.prototest.solanum.EggplantElement;
//
///**
// * Created by Brian on 6/4/2014.
// */
//public class FilterPopup extends DeviceMain {
//    public EggplantElement doneButton = new EggplantElement("doneButton", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/BlockBuster/SortFilterOptions/DoneButton"));
//    public EggplantElement dateOption = new EggplantElement("dateOption", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/BlockBuster/SortFilterOptions/DateOption"));
//    public EggplantElement titleOption = new EggplantElement("titleOption", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/BlockBuster/SortFilterOptions/TitleOption"));
//    public EggplantElement mostPopularOption = new EggplantElement("mostPopularOption", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/BlockBuster/SortFilterOptions/MostPopularOption"));
//    public EggplantElement allOption = new EggplantElement("allOption", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/BlockBuster/SortFilterOptions/DoneButton"));
//    public EggplantElement actionAdventureOption = new EggplantElement("actionAdventureOption", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/BlockBuster/SortFilterOptions/DoneButton"));
//    public EggplantElement filterByGenreLabel = new EggplantElement("filterByGenreLabel", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/BlockBuster/SortFilterOptions/FilterByGenre"));
//
//    public FilterPopup sortByTitle() {
//        titleOption.click();
//        return this;
//    }
//
//    public FilterPopup selectFilter(String value){
//        EggplantElement element = new EggplantElement(By.Text(value));
//        element.click();
//        return this;
//    }
//
//    public DishAnywhereScrollView done(){
//        doneButton.click();
//        return new DishAnywhereScrollView();
//
//    }
//
//    public FilterPopup scrollDown(){
//        filterByGenreLabel.swipeUp();
//        return this;
//    }
//
//
//    public FilterPopup scrollUp(){
//        filterByGenreLabel.swipeDown();
//        return this;
//    }
//}
