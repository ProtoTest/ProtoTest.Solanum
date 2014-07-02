package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

/**
 * Created by Brian on 6/4/2014.
 */
public class DishAnywhereAuthorizedDevices extends DishAnywhereSettings {
    private EggplantElement authorizeDeviceButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/AuthorizedDevices/AuthorizeThisDeviceButton"));
    private EggplantElement deAuthorizeDeviceButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/AuthorizedDevices/DeAuthorizeThisDeviceButton"));
    private EggplantElement okButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/OkButton"));
    private EggplantElement cancelButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/CancelButton"));

    public DishAnywhereAuthorizedDevices authorizeThisDevice(){
        if(authorizeDeviceButton.isPresent()){
            authorizeDeviceButton.click();
        }
        return this;
    }

    public DishAnywhereAuthorizedDevices deAuthorizeThisDevice(){
        if(deAuthorizeDeviceButton.isPresent()){
            deAuthorizeDeviceButton.waitForPresent().click();
            okButton.click();
        }
        return this;
    }

    public DishAnywhereAuthorizedDevices verifyDeviceIsInList(String name){
        EggplantElement element = new EggplantElement(By.Text(name));
        element.waitForNotPresent();
        return this;
    }

}
