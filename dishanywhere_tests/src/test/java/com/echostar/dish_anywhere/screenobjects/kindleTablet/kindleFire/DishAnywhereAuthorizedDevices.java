package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;

/**
 * Created by Brian on 6/4/2014.
 */
public class DishAnywhereAuthorizedDevices extends DishAnywhereSettings {
    private EggplantElement authorizeDeviceButton = new EggplantElement("authorizeDeviceButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/AuthorizedDevices/AuthorizeThisDeviceButton"));
    private EggplantElement deAuthorizeDeviceButton = new EggplantElement("deAuthorizeDeviceButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/AuthorizedDevices/DeAuthorizeThisDeviceButton"));
    private EggplantElement okButton = new EggplantElement("okButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/OkButton"));
    private EggplantElement cancelButton = new EggplantElement("cancelButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/CancelButton"));


    public DishAnywhereAuthorizedDevices authorizeThisDevice(){
        Logger.info("Authorizing device");
        if(deAuthorizeDeviceButton.isPresent()){
            Logger.info("Already authorized");
        } else {
            Logger.info("Authorizing");
            authorizeDeviceButton.click();
        }
        return this;
    }

    public DishAnywhereAuthorizedDevices deAuthorizeThisDevice(){
        Logger.info("De-authorizing device");
        if(deAuthorizeDeviceButton.isPresent()){
            Logger.info("De-authorized button found; de-authorizing.");
            deAuthorizeDeviceButton.waitForPresent().click();
            okButton.click();
        } else {
            Logger.info("De-authorized button not found, not de-authorizing.");
        }
        return this;
    }

    public DishAnywhereAuthorizedDevices verifyDeviceIsInList(String name){
        EggplantElement element = new EggplantElement("element", By.Text(name));
        element.waitForNotPresent();
        return this;
    }

}
