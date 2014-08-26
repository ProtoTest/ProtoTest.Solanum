package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.*;

import java.awt.*;

public class DishAnywhereSettings extends DishAnywhereHome {

    private EggplantElement logout = new EggplantElement(By.Text("Logout"));
    private EggplantElement parentalControlsButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControlsButton"));
    private EggplantElement authorizedDevicesButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/AuthorizedDevicesButton"));
    private EggplantElement okButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/OkButton", SearchRectangle.Quadrants.MIDDLE_HALF));


    public DishAnywhereSettings() {
        super();
    }

    public DishAnywhereSettings openSettingsRoot() {
        Logger.info("Opening Settings root...");
        for (int i = 0; i < 10 && ! logout.isPresent(); i++) {
            if (okButton.isPresent()) {
                okButton.click();
            }
            EggplantTestBase.driver.PressBackButton();
        }
        return this;
    }

    public DishAnywhereLogin logout() {
        Logger.info("Logging out...");
        if (! logout.isPresent()) {
            new EggplantElement(By.Text("On Demand", SearchRectangle.Quadrants.BOTTOM_QUARTER,
                        TextOption.hotSpot(new Point(0,-400))))
                .swipeUp();
        }
        logout.click();
        okButton.click();
        Logger.info("Logout complete.");
        return new DishAnywhereLogin();
    }

    public DishAnywhereParentalControls openParentalControls(String passcode){
        Logger.info("Opening Parental Controls with passcode:(" + passcode + ").");
        parentalControlsButton.click();
        EnterPasscodePopup popup = new EnterPasscodePopup();
        popup.enterPasscode(passcode);
        return new DishAnywhereParentalControls();
    }

    public DishAnywhereAuthorizedDevices openAuthorizedDevices(){
        Logger.info("Opening Authorized Devices list...");
        authorizedDevicesButton.click();
        return new DishAnywhereAuthorizedDevices();
    }

}
