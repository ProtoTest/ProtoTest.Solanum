package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.*;

public class DeviceHomeScreen extends DeviceMain {

    public DeviceHomeScreen() {
        super();
    }

    public <C> C openApp(String name, Class<C> screenType, SearchRectangle.Quadrants quadrant, TextOption... options) {
        Logger.info(String.format("Opening app: (%s).", name));
        EggplantElement element = new EggplantElement(By.Text(name, quadrant, options));
        element.click();
        try {
            return screenType.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public DeviceMain openApp(String name, SearchRectangle.Quadrants quadrant, TextOption... options) {
        Logger.info(String.format("Opening app: (%s).", name));
        return openApp(name, DeviceMain.class, quadrant, options);
    }

    public DeviceMain openApp(String name, TextOption... options) {
        Logger.info(String.format("Opening app: (%s).", name));
        return openApp(name, DeviceMain.class, null, options);
    }

}
