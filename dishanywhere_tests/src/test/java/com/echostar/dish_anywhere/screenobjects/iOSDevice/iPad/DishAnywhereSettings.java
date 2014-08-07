package com.echostar.dish_anywhere.screenobjects.iOSDevice.iPad;

import com.prototest.solanum.*;

import java.awt.*;

/**
 */
public class DishAnywhereSettings extends DishAnywhereHome {
    private EggplantElement logoutButton = new EggplantElement("logoutButton", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/LogoutButton"));
    private EggplantElement parentalControlsButton = new EggplantElement("parentalControlsButton", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/ParentalControlsButton"));
    private EggplantElement authorizedDevicesButton = new EggplantElement("authorizedDevicesButton", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/AuthorizedDevicesButton"));
    private EggplantElement okButton = new EggplantElement("okButton", By.Image("iosTablet/iPadAir/Apps/DishAnywhere/Settings/OkButton"));

    public DishAnywhereSettings() {
        super();
    }

    public DishAnywhereLogin logout() {
        Logger.info("Logging out...");
        if (! logoutButton.isPresent()) {
            new EggplantElement(By.Text("On Demand", SearchRectangle.Quadrants.BOTTOM_QUARTER,
                        TextOption.hotSpot(new Point(0,-400))))
                .swipeUp();
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
