package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.*;

import java.awt.*;

/**
 */
public class DishAnywhereSettings extends DishAnywhereHome {
    private EggplantElement logout = new EggplantElement(By.Text("Logout"));
    private EggplantElement parentalControlsButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/ParentalControlsButton"));
    private EggplantElement authorizedDevicesButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/AuthorizedDevicesButton"));
    private EggplantElement okButton = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Settings/OkButton", SearchRectangle.middleHalf().trimTop(25)));

    public DishAnywhereSettings() {
        super();
    }

    public DishAnywhereSettings openSettingsRoot() {

        for (int i = 0; i < 10 && ! logout.isPresent(); i++) {
            nav.backButton.click();
        }
        return this;
    }

    public DishAnywhereLogin logout() {
        Logger.info("Logging out...");
        if (! logout.isPresent()) {
            new EggplantElement(By.Text("On Demand", SearchRectangle.bottomQuarter(),
                        TextOption.hotSpot(new Point(0,-400))))
                .swipeUp();
        }
        logout.click();
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
