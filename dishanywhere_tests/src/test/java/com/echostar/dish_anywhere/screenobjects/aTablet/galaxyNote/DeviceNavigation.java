package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

// Screen Object for Device's navigation options

public class DeviceNavigation {
    public final EggplantElement homeButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/System/Device/HomeButton"));
    public final EggplantElement backButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/System/Device/BackButton"));
    public final EggplantElement settingsButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/System/Device/BackButton"));
    public final EggplantElement taskManagerButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/System/Device/TaskManagerButton"));
}
