package com.echostar.dish_anywhere.tests.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.EggplantTestBase;

/**
 * Created by Brian on 8/10/2014.
 */
public class Test extends EggplantTestBase {
    EggplantElement home = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/DishAnywhereAppIcon"));
    EggplantElement onDemand = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/AppNav/OnDemand"));
    EggplantElement settings = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/AppNav/Settings"));


    @org.testng.annotations.Test
    public void tests(){
        for(int i=0;i<100;i++){
            driver.PressHomeButton();
            home.click();
            while(!home.isPresent()){
                driver.PressBackButton();
            }
            home.click();
            onDemand.click();
            settings.click();
        }
    }
}
