//package com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad;
//
//import com.prototest.solanum.By;
//import com.prototest.solanum.EggplantElement;
//
///**
// * Created by Brian on 6/4/2014.
// */
//public class DishAnywhereAuthorizedDevices extends DishAnywhereSettings {
//    private EggplantElement authorizeDeviceButton = new EggplantElement("Authorize Device Button", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/AuthorizedDevices/AuthorizeThisDeviceButton"));
//    private EggplantElement deAuthorizeDeviceButton = new EggplantElement("DeAuthorize Device Button", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/AuthorizedDevices/DeAuthorizeThisDeviceButton"));
//    private EggplantElement okButton = new EggplantElement(By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/OkButton"));
//    private EggplantElement cancelButton = new EggplantElement(By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/CancelButton"));
//
//    public DishAnywhereAuthorizedDevices authorizeThisDevice(){
//        authorizeDeviceButton.click();
//        return this;
//    }
//
//    public DishAnywhereAuthorizedDevices deAuthorizeThisDevice(){
//        if(authorizeDeviceButton.isPresent())
//            deAuthorizeDeviceButton.click();
//        return this;
//    }
//
//    public DishAnywhereAuthorizedDevices verifyDeviceIsInList(String name){
//        EggplantElement element = new EggplantElement(By.Text(name));
//        element.waitForNotPresent();
//        return this;
//    }
//
//}
