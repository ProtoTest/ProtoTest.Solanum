package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SearchRectangle;

public class DishAnywhereHome extends DishAnywhereMain {
    private EggplantElement settingsButton = new EggplantElement("settingsButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/AppNav/SettingsOption", SearchRectangle.bottomQuarter()));
    private EggplantElement guideButton = new EggplantElement("guideButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/AppNav/GuideOption", SearchRectangle.bottomQuarter()));

    private EggplantElement onDemandButton = new EggplantElement("onDemandButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/AppNav/OnDemandOption", SearchRectangle.bottomQuarter()));

    private EggplantElement blockbusterButton = new EggplantElement("blockbusterButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/AppNav/BlockBusterOption", SearchRectangle.bottomQuarter()));
    private EggplantElement viewAllButton = new EggplantElement("viewAllButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/ViewAllButton", SearchRectangle.rightQuarter()));

    public DishAnywhereLogin logOutIfLoggedIn() {
        Logger.info("Logging out if logged in.");
        if (loggedIn()) {
            return openSettings().logout();
        }
        return new DishAnywhereLogin();
    }

    private boolean loggedIn() {
        if (settingsButton.isPresent())
            return true;
        return settingsButton.isPresent(30);
    }

    public DishAnywhereSettings openSettings() {
        Logger.info("Opening Settings panel.");
        settingsButton.click();
        return new DishAnywhereSettings();
    }

    public DishAnywhereHome openGuide() {
        guideButton.click();
        return this;
    }

    public DishAnywhereOnDemand openOnDemand() {
        Logger.info("Opening on demand.");
        onDemandButton.click();
        viewAllButton.click();
        return new DishAnywhereOnDemand();
    }

    public Blockbuster openBlockbuster() {
        Logger.info("Opening Blockbuster.");
        blockbusterButton.click();
        return new Blockbuster();
    }

    public DishAnywhereHome verifyLoggedIn() {
        Logger.info("Verifying app is logged in.");
        settingsButton.waitForPresent(20);
        return this;
    }

    public DeviceMain returnToDeviceMain() {
        Logger.info("Return to device home screen.");
        goHome();
        return this;
    }

    public DeviceMain goBackToDeviceScreen() {
        Logger.info("Pressing back button until device is on home.");
        DeviceMain main = new DeviceMain();
        while (!dishAnywhereApp.isPresent()) {
            nav.backButton.click();
        }
        return new DeviceMain();
    }
}
