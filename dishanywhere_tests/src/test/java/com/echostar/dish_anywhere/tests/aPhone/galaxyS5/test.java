package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.radish.RadishScraper;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Logger;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

//
//Tests for proper functionality when devices are de-authorized and then re-authorized
//

public class test extends EggplantTestBase {
    @Test
    public void test(){
        EggplantElement element = new EggplantElement(By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Login/LoginButton"));
        element.click();
    }

}
