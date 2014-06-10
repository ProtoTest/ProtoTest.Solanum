package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.SearchRectangle;

/**
 * Created by Brian on 6/4/2014.
 */
public class DishAnywhereAuthorizedDevices extends DishAnywhereSettings {
    private EggplantElement authorizeDeviceButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/AuthorizedDevices/AuthorizeThisDeviceButton"));
    private EggplantElement deAuthorizeDeviceButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/AuthorizedDevices/DeAuthorizeThisDeviceButton"));
    private EggplantElement okButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/OkButton"));
    private EggplantElement cancelButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/CancelButton"));


    public DishAnywhereAuthorizedDevices authorizeThisDevice() {
        authorizeDeviceButton.click();
        return this;
    }

    public DishAnywhereAuthorizedDevices deAuthorizeThisDevice() {
        if (!authorizeDeviceButton.isPresent()) {
            deAuthorizeDeviceButton.click();
            okButton.click();
        }
        return this;
    }

    public DishAnywhereAuthorizedDevices verifyDeviceIsInList(String name) {
        EggplantElement element = new EggplantElement(By.Text(name));
        element.waitForNotPresent();
        return this;
    }

}
