package com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.TextOption;

/**
 */
public class HomeScreen extends AndroidScreen {
    public HomeScreen() {
        super();
    }

    public <C> C openApp(String name, Class<C> screenType, TextOption... options) {
        Logger.message(String.format("Opening app: (%s).",name));
        EggplantElement element = new EggplantElement(By.Text(name, options));
        element.click();
        try {
            return screenType.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public AndroidScreen openApp(String name, TextOption... options) {
        Logger.message(String.format("Opening app: (%s).",name));
        return openApp(name, AndroidScreen.class, options);
    }
}
