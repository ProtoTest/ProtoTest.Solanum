package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;

public class FilterPopup extends DeviceMain{

    public EggplantElement doneButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/BlockBuster/SortFilterOptions/DoneButton"));
    public EggplantElement dateOption = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/BlockBuster/SortFilterOptions/DateOption"));
    public EggplantElement titleOption = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/BlockBuster/SortFilterOptions/TitleOption"));
    public EggplantElement mostPopularOption = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/BlockBuster/SortFilterOptions/MostPopularOption"));
    public EggplantElement allOption = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/BlockBuster/SortFilterOptions/DoneButton"));
    public EggplantElement actionAdventureOption = new EggplantElement(By.Text("Action & Adventure"));
    public EggplantElement comedyGenreOption = new EggplantElement(By.Text("Comedy"));
    public EggplantElement filterByGenreLabel = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/BlockBuster/SortFilterOptions/FilterByGenre"));

    public FilterPopup sortByTitle() {
        Logger.info("Sorting by title...");
        titleOption.click();
        return this;
    }

    public FilterPopup selectFilter(String value){
        EggplantElement element = new EggplantElement("element", By.Text(value));
        EggplantElement scrollFrom = new EggplantElement("Filter scroll from point" , By.Point(comedyGenreOption.getLocation()));
        EggplantElement scrollTo = new EggplantElement("Filter scroll from point" , By.Point(actionAdventureOption.getLocation()));
        for (int attempt = 0; attempt < 5 && !element.isPresent(20); attempt++) {
            scrollFrom.dragTo(scrollTo);
        }
        element.click();
        return this;
    }

    public DishAnywhereScrollView done() {
        Logger.info("Clicking 'done' button...");
        doneButton.click();
        return new DishAnywhereScrollView();

    }

}
