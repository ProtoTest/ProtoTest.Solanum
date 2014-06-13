package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFireHDX;

import com.prototest.solanum.*;

// Screen Object for Device's primary View object (Home) on the MainScreen ViewGroup

public class DeviceHomeScreen extends DeviceMain {
    public DeviceHomeScreen() {
        super();
    }

    public <C> C openApp(String name, Class<C> screenType, SearchRectangle rect, TextOption... options) {
        Logger.info(String.format("Opening app: (%s).", name));
        EggplantElement element = new EggplantElement(By.Text(name, rect, options));
        element.click();
        try {
            return screenType.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public DeviceMain openApp(String name, SearchRectangle rect, TextOption... options) {
        Logger.info(String.format("Opening app: (%s).", name));
        return openApp(name, DeviceMain.class, rect, options);
    }

    public DeviceMain openApp(String name, TextOption... options) {
        Logger.info(String.format("Opening app: (%s).", name));
        return openApp(name, DeviceMain.class, null, options);
    }
}
