package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

public class FilterPopup extends DishAnywhereHome {

    public EggplantElement doneButton = new EggplantElement("doneButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/SortFilterOptions/DoneButton"));
    public EggplantElement dateOption = new EggplantElement("dateOption", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/SortFilterOptions/DateOption"));
    public EggplantElement titleOption = new EggplantElement("titleOption", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/SortFilterOptions/TitleOption"));
    public EggplantElement mostPopularOption = new EggplantElement("mostPopularOption", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/SortFilterOptions/MostPopularOption"));
    public EggplantElement allOption = new EggplantElement("allOption", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/SortFilterOptions/DoneButton"));
    public EggplantElement actionAdventureOption = new EggplantElement("actionAdventureOption", By.Text("Action & Adventure"));
    public EggplantElement filterByGenreLabel = new EggplantElement("filterByGenreLabel", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/BlockBuster/SortFilterOptions/FilterByGenre"));
    public EggplantElement documentaryGenre = new EggplantElement(By.Text("Documentary"));
    public EggplantElement comedyGenre = new EggplantElement(By.Text("Comedy"));
    public EggplantElement animationGenre = new EggplantElement(By.Text("Animation"));


    public FilterPopup sortByTitle() {
        titleOption.click();
        return this;
    }

    public FilterPopup selectFilter(String value){
        EggplantElement element = new EggplantElement("element", By.Text(value));
        EggplantElement scrollFrom = new EggplantElement("Filter scroll from point" , By.Point(comedyGenre.getLocation()));
        EggplantElement scrollTo = new EggplantElement("Filter scroll from point" , By.Point(actionAdventureOption.getLocation()));
        for (int attempt = 0; attempt < 5 && !element.isPresent(20); attempt++) {
            scrollFrom.dragTo(scrollTo);
        }
        element.click();
        return this;
    }

    public DishAnywhereScrollView done(){
        doneButton.click();
        return new DishAnywhereScrollView();

    }

    public DishAnywhereScrollView doneNewSkin(){
        onDemandButton.click();
        return new DishAnywhereScrollView();

    }


}
