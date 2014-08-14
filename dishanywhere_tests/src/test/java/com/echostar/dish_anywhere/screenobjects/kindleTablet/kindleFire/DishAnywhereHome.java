package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.*;

public class DishAnywhereHome extends DishAnywhereMain {
    public EggplantElement settingsButton = new EggplantElement("settingsButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/AppNav/SettingsOption", SearchRectangle.Quadrants.BOTTOM_QUARTER));
    public EggplantElement guideButton = new EggplantElement("guideButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/AppNav/GuideOption", SearchRectangle.Quadrants.BOTTOM_QUARTER));

    protected EggplantElement onDemandButton = new EggplantElement("onDemandButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/AppNav/OnDemandOption", SearchRectangle.Quadrants.BOTTOM_QUARTER));

    public EggplantElement blockbusterButton = new EggplantElement("blockbusterButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/AppNav/BlockBusterOption", SearchRectangle.Quadrants.BOTTOM_QUARTER));
    public EggplantElement viewAllButton = new EggplantElement("viewAllButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/OnDemand/ViewAllButton", SearchRectangle.Quadrants.RIGHT_QUARTER));

    public DishAnywhereLogin logOutIfLoggedIn() {
        Logger.info("Logging out if logged in.");
        if (loggedIn()) {
            Logger.info("Logging out");
            return openSettings().logout();
        }
        return new DishAnywhereLogin();
    }
    public void waitForScreenToLoad() {
        settingsButton.waitForPresent(30);
    }

    private boolean loggedIn() {
        Logger.info("Checking if logged in");
        // Make sure there's no transition animations still running by waiting a second...
        EggplantTestBase.sleep(1000);
//        for (int attempt = 0; attempt < 3; attempt++) {
//            Logger.debug("Attempt " + (attempt + 1) + " to detect guide button");
            EggplantTestBase.driver.refreshScreen();
            if (guideButton.isPresent()) {
                Logger.info("Logged in");
                return true;
            }
//        }
        Logger.info("Logged out");
        return false;
    }

    public DishAnywhereSettings openSettings() {
        Logger.info("Opening Settings panel.");
        DishAnywhereSettings settings = new DishAnywhereSettings();
        settingsButton.click(ActionCondition.isPresent(settings.authorizedDevicesButton));
        return settings ;
    }

    public DishAnywhereHome openGuide() {
        Logger.info("Opening guide");
        guideButton.click();
        return this;
    }

    public DishAnywhereOnDemand openOnDemand() {
        Logger.info("Opening on demand.");
        onDemandButton.click();
        Logger.debug("Opening all movies");
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
