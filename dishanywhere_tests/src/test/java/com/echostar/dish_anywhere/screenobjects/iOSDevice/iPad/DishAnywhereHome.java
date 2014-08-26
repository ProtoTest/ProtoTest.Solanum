//package com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad;
//
//import com.prototest.solanum.By;
//import com.prototest.solanum.EggplantElement;
//import com.prototest.solanum.Logger;
//import com.prototest.solanum.SearchRectangle;
//
//public class DishAnywhereHome extends DishAnywhereMain {
//    private EggplantElement settingsButton = new EggplantElement("Settings", By.Text("Settings", SearchRectangle.Quadrants.BOTTOM_QUARTER));
//    private EggplantElement guideButton = new EggplantElement("Guide", By.Text("Guide", SearchRectangle.Quadrants.BOTTOM_QUARTER));
//
//    private EggplantElement onDemandButton = new EggplantElement("On Demand", By.Text("On Demand", SearchRectangle.Quadrants.BOTTOM_QUARTER));
//
//    private EggplantElement blockbusterButton = new EggplantElement("Blockbuster", By.Text("BlockBuster", SearchRectangle.Quadrants.BOTTOM_QUARTER));
//    private EggplantElement viewAllButton = new EggplantElement("View All Button", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/OnDemand/ViewAllButton", SearchRectangle.Quadrants.BOTTOM_HALF));
//
//
//    public DishAnywhereHome() {
//
//    }
//
//    public DishAnywhereLogin logOutIfLoggedIn(){
//        if(loggedIn()){
//           return openSettings().logout();
//        }
//        return new DishAnywhereLogin();
//    }
//
//    private boolean loggedIn() {
//        if(settingsButton.isPresent())
//            return true;
//        return settingsButton.isPresent(15);
//    }
//
//    public DishAnywhereSettings openSettings() {
//        Logger.info("Opening Settings panel.");
//        settingsButton.click();
//        return new DishAnywhereSettings();
//    }
//
//    public DishAnywhereHome openGuide() {
//        guideButton.click();
//        return this;
//    }
//
//    public DishAnywhereOnDemand openOnDemand(){
//        onDemandButton.click();
//        viewAllButton.waitForPresent(20);
//        viewAllButton.click();
//        return new DishAnywhereOnDemand();
//    }
//    public Blockbuster openBlockbuster(){
//        blockbusterButton.click();
//        return new Blockbuster();
//    }
//    public DishAnywhereHome verifyLoggedIn() {
//        settingsButton.waitForPresent(20);
//        return this;
//    }
//
//    public DeviceMain returnToDeviceMain(){
//        goHome();
//        return this;
//    }
//}
