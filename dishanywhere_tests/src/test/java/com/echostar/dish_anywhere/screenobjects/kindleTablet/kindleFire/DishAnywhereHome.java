package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;
import com.prototest.solanum.SearchRectangle;

public class DishAnywhereHome extends DishAnywhereMain {
    public EggplantElement settingsButton = new EggplantElement("settingsButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/AppNav/SettingsOption", SearchRectangle.Quadrants.BOTTOM_QUARTER));
    public EggplantElement guideButton = new EggplantElement("guideButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/AppNav/GuideOption", SearchRectangle.Quadrants.BOTTOM_QUARTER));

    protected EggplantElement onDemandButton = new EggplantElement("onDemandButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/AppNav/OnDemandOption", SearchRectangle.Quadrants.BOTTOM_QUARTER));

    public EggplantElement blockbusterButton = new EggplantElement("blockbusterButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/AppNav/BlockBusterOption", SearchRectangle.Quadrants.BOTTOM_QUARTER));
    public EggplantElement viewAllButton = new EggplantElement("viewAllButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/ViewAllButton", SearchRectangle.Quadrants.RIGHT_QUARTER));

    public DishAnywhereLogin logOutIfLoggedIn() {
        Logger.info("Logging out if logged in.");
        if (loggedIn()) {
            return openSettings().logout();
        }
        return new DishAnywhereLogin();
    }
    public void waitForScreenToLoad() {
        settingsButton.waitForPresent(30);
    }

    private boolean loggedIn() {
        if (settingsButton.isPresent())
            return true;
        return settingsButton.isPresent(10);
    }

    public DishAnywhereSettings openSettings() {
        Logger.info("Opening Settings panel.");
        settingsButton.click();
        DishAnywhereSettings settings = new DishAnywhereSettings();
        if(!settings.authorizedDevicesButton.isPresent(5)){
            Logger.info("Clicking settings again");
            new EggplantElement(By.Text("Settings", SearchRectangle.Quadrants.BOTTOM_QUARTER)).click();
        }
        return settings ;
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



}
