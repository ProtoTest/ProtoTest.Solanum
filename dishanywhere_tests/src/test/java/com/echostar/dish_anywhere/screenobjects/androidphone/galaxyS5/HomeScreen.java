package com.echostar.dish_anywhere.screenobjects.androidphone.galaxyS5;

import com.prototest.solanum.*;

/**
 */
public class HomeScreen extends AndroidScreen {
    public HomeScreen() {
        super();
    }

    public <C> C openApp(String name, Class<C> screenType, SearchRectangle rect, TextOption... options) {
        Logger.message(String.format("Opening app: (%s).", name));
        EggplantElement element = new EggplantElement(By.Text(name, rect, options));
        element.click();
        try {
            return screenType.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public AndroidScreen openApp(String name, SearchRectangle rect, TextOption... options) {
        Logger.message(String.format("Opening app: (%s).", name));
        return openApp(name, AndroidScreen.class, rect, options);
    }

    public AndroidScreen openApp(String name, TextOption... options) {
        Logger.message(String.format("Opening app: (%s).", name));
        return openApp(name, AndroidScreen.class, null, options);
    }
}
