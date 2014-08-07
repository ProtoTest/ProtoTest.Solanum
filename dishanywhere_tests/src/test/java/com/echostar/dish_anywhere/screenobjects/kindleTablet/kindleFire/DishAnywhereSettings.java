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

    public DishAnywhereLogin logout() {
        Logger.info("Logging out...");
        for (int i = 0; i<3&&! logoutButton.isPresent();i++) {
            authorizedDevicesButton.swipeUp();
            // Wait for the swipe animation to complete.
            EggplantTestBase.sleep(2000);
        }
        logoutButton.click();
        okButton.click();
        Logger.info("Logout complete.");
        return new DishAnywhereLogin();
    }

    public DishAnywhereParentalControls openParentalControls(String passcode){
        parentalControlsButton.click();
        EnterPasscodePopup popup = new EnterPasscodePopup();
        popup.enterPasscode(passcode);
        return new DishAnywhereParentalControls();
    }

    public DishAnywhereAuthorizedDevices openAuthorizedDevices(){
        authorizedDevicesButton.click();
        return new DishAnywhereAuthorizedDevices();
    }
}
