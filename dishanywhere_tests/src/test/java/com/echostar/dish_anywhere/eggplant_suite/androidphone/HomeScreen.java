package com.echostar.dish_anywhere.eggplant_suite.androidphone;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.TextOption;

import java.lang.reflect.InvocationTargetException;

/**
 */
public class HomeScreen extends AndroidScreen {
    public AndroidScreen openApp(String name, Class<AndroidScreen> screenType, TextOption... options) {
        EggplantElement element = new EggplantElement(By.Text(name, options));
        element.click();
        try {
            return screenType.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public AndroidScreen openApp(String name, TextOption... options) {
        return openApp(name, AndroidScreen.class, options);
    }
}
