package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.*;

import java.awt.*;

public class DishAnywhereSettings extends DishAnywhereHome {
    private EggplantElement logoutButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/LogoutButton"));
    private EggplantElement parentalControlsButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/ParentalControlsButton"));
    private EggplantElement authorizedDevicesButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/AuthorizedDevicesButton"));
    private EggplantElement okButton = new EggplantElement(By.Image("AndroidTablet/GalaxyNote/Apps/DishAnywhere/Settings/OkButton"));
    public EggplantElement loggingOutNotice = new EggplantElement(By.Text("Logging out..."));
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

        try {
            loggingOutNotice.waitForNotPresent(30);
        }
        catch(RuntimeException e) {
            killApp();
            goToDeviceHomeAndEnterApp();
            settingsButton.waitForPresent();
            logOutIfLoggedIn();
        }
        return new DishAnywhereLogin().verifyLoggedOut();
    }

    public DishAnywhereParentalControls openParentalControls(String passcode){
        Logger.info("Opening parental controls menu...");
        parentalControlsButton.click();
        EnterPasscodePopup popup = new EnterPasscodePopup();
        Logger.info("Entering passcode (" + passcode + ").");
        popup.enterPasscode(passcode);
        return new DishAnywhereParentalControls();
    }

    public DishAnywhereAuthorizedDevices openAuthorizedDevices(){
        Logger.info("Opening authorized devices list...");
        authorizedDevicesButton.click();
        return new DishAnywhereAuthorizedDevices();
    }
}
