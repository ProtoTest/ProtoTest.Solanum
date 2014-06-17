package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

/**
 * Created by Brian on 6/4/2014.
 */
public class DishAnywhereAuthorizedDevices extends DishAnywhereSettings {
    private EggplantElement authorizeDeviceButton = new EggplantElement("authorizeDeviceButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/AuthorizedDevices/AuthorizeThisDeviceButton"));
    private EggplantElement deAuthorizeDeviceButton = new EggplantElement("deAuthorizeDeviceButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/AuthorizedDevices/DeAuthorizeThisDeviceButton"));
    private EggplantElement okButton = new EggplantElement("okButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/OkButton"));
    private EggplantElement cancelButton = new EggplantElement("cancelButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/CancelButton"));


    public DishAnywhereAuthorizedDevices authorizeThisDevice(){
        authorizeDeviceButton.click();
        return this;
    }

    public DishAnywhereAuthorizedDevices deAuthorizeThisDevice(){
        deAuthorizeDeviceButton.waitForPresent().click();
        okButton.click();
        return this;
    }

    public DishAnywhereAuthorizedDevices verifyDeviceIsInList(String name){
        EggplantElement element = new EggplantElement("element", By.Text(name));
        element.waitForNotPresent();
        return this;
    }

}
