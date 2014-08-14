package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Logger;

/**
 */
public class DishAnywhereSettings extends DishAnywhereHome {
    public EggplantElement logoutButton = new EggplantElement("logoutButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/LogoutButton"));
    public EggplantElement parentalControlsButton = new EggplantElement("parentalControlsButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControlsButton"));
    public EggplantElement authorizedDevicesButton = new EggplantElement("authorizedDevicesButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/AuthorizedDevicesButton"));
    public EggplantElement okButton = new EggplantElement("okButton", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/OkButton"));

    public DishAnywhereSettings() {
        super();
    }

    public boolean isOnSettings() {
        return parentalControlsButton.isPresent();
    }

    public DishAnywhereLogin logout() {
        Logger.info("Logging out...");
        // Log out button appears below the screen view; scroll through the list of options to find it.
        authorizedDevicesButton.swipeUp();
        // Wait for the swipe animation to complete.
        EggplantTestBase.sleep(4000);

        logoutButton.click();
        okButton.click();
        Logger.info("Logout complete.");
        return new DishAnywhereLogin();
    }

    public DishAnywhereParentalControls openParentalControls(String passcode) {
        Logger.info("Opening parental controls");
        parentalControlsButton.click();
        EnterPasscodePopup popup = new EnterPasscodePopup();
        popup.enterPasscode(passcode);
        return new DishAnywhereParentalControls();
    }

    public DishAnywhereAuthorizedDevices openAuthorizedDevices() {
        Logger.info("Opening authorized devices");
        authorizedDevicesButton.click();
        return new DishAnywhereAuthorizedDevices();
    }
}
