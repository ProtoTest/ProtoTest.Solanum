package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereMain;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereScrollView;
import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.SearchRectangle;

public class DishAnywhereOnDemand extends DishAnywhereMain {
    private EggplantElement featuredButton
            = new EggplantElement(By.Text("Featured", SearchRectangle.topQuarter()));
    private EggplantElement moviesButton
            = new EggplantElement(By.Text("Movies", SearchRectangle.topQuarter()));
    private EggplantElement showsButton
            = new EggplantElement(By.Text("TV Shows", SearchRectangle.topQuarter()));
    private EggplantElement familyButton
            = new EggplantElement(By.Text("Family", SearchRectangle.topQuarter()));
    private EggplantElement latinoButton
            = new EggplantElement(By.Text("Latino", SearchRectangle.topQuarter()));
    private EggplantElement networksButton
            = new EggplantElement(By.Text("Networks", SearchRectangle.topQuarter()));

    public DishAnywhereScrollView openMovies() {
        moviesButton.waitForPresent(30).click();
        return new DishAnywhereScrollView();
    }


}