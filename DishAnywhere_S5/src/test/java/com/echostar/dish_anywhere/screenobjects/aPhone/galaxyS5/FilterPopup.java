package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import org.testng.Assert;

public class FilterPopup extends DeviceMain {

    private EggplantElement okButton = new EggplantElement(By.Text("OK"));
    public EggplantElement dateOption = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/BlockBuster/SortFilterOptions/DateOption"));
    public EggplantElement titleOption = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/BlockBuster/SortFilterOptions/TitleOption"));
    public EggplantElement mostPopularOption = new EggplantElement(By.Text("Most Popular"));
    public EggplantElement allOption = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/BlockBuster/SortFilterOptions/DoneButton"));
    public EggplantElement actionAdventureOption = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/BlockBuster/SortFilterOptions/DoneButton"));
    public EggplantElement filterByGenreLabel = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/BlockBuster/SortFilterOptions/FilterByGenre"));


    public FilterPopup selectFilter(String value){
        Logger.info("Selecting filter: (" + value + ") ...");
        EggplantElement element = new EggplantElement("element", By.Text(value));
        EggplantElement scrollFrom = new EggplantElement("Filter scroll from point" , By.Point(mostPopularOption.getLocation()));
        EggplantElement scrollTo = new EggplantElement("Filter scroll to point" , By.Point(dateOption.getLocation()));
        for (int attempt = 0; attempt < 5 && !element.isPresent(20); attempt++) {
            scrollFrom.dragTo(scrollTo);
        }
        element.click();
        return this;
    }

    public DishAnywhereScrollView done(){
        okButton.click();
        return new DishAnywhereScrollView();
    }

    public FilterPopup scrollDown(){
        filterByGenreLabel.dragTo(dateOption);
        return this;
    }

}
