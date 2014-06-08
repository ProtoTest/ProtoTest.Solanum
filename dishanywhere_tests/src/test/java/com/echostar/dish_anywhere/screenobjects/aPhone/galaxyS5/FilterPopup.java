package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SearchRectangle;
import org.testng.Assert;

/**
 * Created by Brian on 6/4/2014.
 */
public class FilterPopup extends DeviceMain {
    private EggplantElement okButton = new EggplantElement(By.Text("OK"));
    public EggplantElement dateOption = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/BlockBuster/SortFilterOptions/DateOption"));
    public EggplantElement titleOption = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/BlockBuster/SortFilterOptions/TitleOption"));
    public EggplantElement mostPopularOption = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/BlockBuster/SortFilterOptions/MostPopularOption"));
    public EggplantElement allOption = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/BlockBuster/SortFilterOptions/DoneButton"));
    public EggplantElement actionAdventureOption = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/BlockBuster/SortFilterOptions/DoneButton"));
    public EggplantElement filterByGenreLabel = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/BlockBuster/SortFilterOptions/FilterByGenre"));

    public FilterPopup selectFilter(String value){
        EggplantElement element = new EggplantElement(By.Text(value));
        for (int i = 0; i < 4; i++) {
            if (!element.isPresent()) {
                scrollDown();
            }
        }
        if (!element.isPresent()) {
            Logger.screenshot();
            Assert.fail("Filter (" + value + ") is not present.");
        }
        element.click();
        return this;
    }

    public DishAnywhereScrollView done(){
        okButton.click();
        return new DishAnywhereScrollView();

    }

    public FilterPopup scrollDown(){
        filterByGenreLabel.swipeUp();
        return this;
    }


    public FilterPopup scrollUp(){
        filterByGenreLabel.swipeDown();
        return this;
    }
}
