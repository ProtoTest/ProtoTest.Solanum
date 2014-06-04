package com.echostar.dish_anywhere.screenobjects.aTablet.galaxyNote;

import com.prototest.solanum.*;

import java.awt.*;

/**
 */
public class DishAnywhereSettings extends DishAnywhereHome {
    private EggplantElement logoutButton = new EggplantElement(By.Text("Logout"));
    private EggplantElement parentalControlsButton = new EggplantElement(By.Text("Parental Controls"));
    private EggplantElement authorizedDevicesButton = new EggplantElement(By.Text("Authorized Devices"));


    public DishAnywhereSettings() {
        super();
    }

    public DishAnywhereLogin logout() {
        Logger.info("Logging out...");
        if (! logoutButton.isPresent()) {
            new EggplantElement(By.Text("On Demand", SearchRectangle.bottomQuarter(),
                        TextOption.hotSpot(new Point(0,-400))))
                .swipeUp();
        }
        logoutButton.click();
        new EggplantElement(By.Text("OK", SearchRectangle.middleHalf().trimTop(25))).click();
        Logger.info("Logout complete.");
        return new DishAnywhereLogin();
    }

    public DishAnywhereParentalControls openParentalControls(String passcode){
        parentalControlsButton.click();
        EnterPasscodePopup popup = new EnterPasscodePopup();
        popup.enterPasscode(passcode);
        return new DishAnywhereParentalControls();
    }

    public DishAnywhereParentalControls openAuthorizedDevices(){
        authorizedDevicesButton.click();
        return new DishAnywhereParentalControls();
    }
}
