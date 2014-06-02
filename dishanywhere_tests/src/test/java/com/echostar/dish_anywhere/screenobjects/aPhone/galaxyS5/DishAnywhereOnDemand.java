package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.SearchRectangle;

/**
 */


public class DishAnywhereOnDemand extends DishAnywhereMain {
    private EggplantElement featuredButton
            = new EggplantElement(By.Text("Featured", SearchRectangle.middleHalf()));
    private EggplantElement moviesButton
            = new EggplantElement(By.Text("Movies", SearchRectangle.middleHalf()));
    private EggplantElement showsButton
            = new EggplantElement(By.Text("TV Shows", SearchRectangle.middleHalf()));
    private EggplantElement familyButton
            = new EggplantElement(By.Text("Family", SearchRectangle.middleHalf()));
    private EggplantElement latinoButton
            = new EggplantElement(By.Text("Latino", SearchRectangle.middleHalf()));
    private EggplantElement networksButton
            = new EggplantElement(By.Text("Networks", SearchRectangle.middleHalf()));

    public DishAnywhereOnDemand() {
        while (! featuredButton.isPresent()) {
            nav.backButton.click();
        }
        featuredButton.verifyPresent();
    }

    public DishAnywhereScrollView openMovies() {
        moviesButton.tap();
        return new DishAnywhereScrollView();
    }
}
