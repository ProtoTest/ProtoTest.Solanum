package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

/**
 * Created by Brian on 6/4/2014.
 */
public class DishAnywhereAuthorizedDevices extends DishAnywhereSettings {
    private EggplantElement authorizeDeviceButton = new EggplantElement(By.Text("Authorize this Device"));
    private EggplantElement deAuthorizeDeviceButton = new EggplantElement(By.Text("De-authorize this Device"));
    private EggplantElement okButton = new EggplantElement(By.Text("OK"));
    private EggplantElement cancelButton = new EggplantElement(By.Text("Cancel"));


    public DishAnywhereAuthorizedDevices authorizeThisDevice(){
        authorizeDeviceButton.click();
        return this;
    }

    public DishAnywhereAuthorizedDevices deAuthorizeThisDevice(){
        if(authorizeDeviceButton.isPresent()) {
            deAuthorizeDeviceButton.click();
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
