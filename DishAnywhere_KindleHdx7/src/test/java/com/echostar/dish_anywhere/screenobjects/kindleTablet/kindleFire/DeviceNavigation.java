package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

// Screen Object for Device's navigation options

public class DeviceNavigation {

    public final EggplantElement homeButton = new EggplantElement("HomeButton",By.Image("KindleTablet/KindleFireHDX/System/Device/HomeButton"));
    public final EggplantElement backButton = new EggplantElement("BackButton",By.Image("KindleTablet/KindleFireHDX/System/Device/BackButton"));
    public final EggplantElement settingsButton = new EggplantElement("SettingsButton",By.Image("KindleTablet/KindleFireHDX/System/Menus/SettingsButton"));

}
