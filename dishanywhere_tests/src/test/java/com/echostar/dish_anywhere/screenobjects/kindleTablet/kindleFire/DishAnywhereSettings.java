package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.*;

import java.awt.*;

/**
 */
public class DishAnywhereSettings extends DishAnywhereHome {
    private EggplantElement logoutButton = new EggplantElement(By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/LogoutButton"));
    private EggplantElement parentalControlsButton = new EggplantElement(By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/ParentalControlsButton"));
    private EggplantElement authorizedDevicesButton = new EggplantElement(By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/AuthorizedDevicesButton"));
    private EggplantElement okButton = new EggplantElement(By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Settings/OkButton"));

    public DishAnywhereSettings() {
        super();
    }

    public DishAnywhereLogin logout() {
        Logger.info("Logging out...");
        if (! logoutButton.isPresent()) {
            authorizedDevicesButton.swipeUp();
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
