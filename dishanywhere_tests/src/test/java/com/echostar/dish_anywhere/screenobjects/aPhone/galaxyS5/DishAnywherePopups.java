package com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5;

import com.prototest.solanum.By;
import com.prototest.solanum.Config;
import com.prototest.solanum.EggplantElement;
import com.prototest.solanum.Logger;

// Screen object for DishAnywhere app - Popups

public class DishAnywherePopups extends DeviceMain {
    private EggplantElement LoadingMessage = new EggplantElement(By.Text("Loading"));

    private EggplantElement enterPasscodeHeader = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Popups/Passcode/EnterPasscodeHeader"));
    private EggplantElement button1 = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Popups/Passcode/PasscodeButton1"));
    private EggplantElement button2 = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Popups/Passcode/PasscodeButton2"));
    private EggplantElement button3 = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Popups/Passcode/PasscodeButton3"));
    private EggplantElement button4 = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Popups/Passcode/PasscodeButton4"));
    private EggplantElement button5 = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Popups/Passcode/PasscodeButton5"));
    private EggplantElement button6 = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Popups/Passcode/PasscodeButton6"));
    private EggplantElement button7 = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Popups/Passcode/PasscodeButton7"));
    private EggplantElement button8 = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Popups/Passcode/PasscodeButton8"));
    private EggplantElement button9 = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Popups/Passcode/PasscodeButton9"));
    private EggplantElement button0 = new EggplantElement(By.Image("AndroidPhone/GalaxyS5/Apps/DishAnywhere/Popups/Passcode/PasscodeButton0"));

    public DishAnywherePopups() {
        super();
    }


    public DishAnywherePopups waitForScreenToLoad() {
        Logger.info("Waiting for screen to load...");
        LoadingMessage.waitForNotPresent(30);
        return this;
    }



    public DishAnywherePopups enterPasscodeIfNeeded() {
        if (enterPasscodeHeader.isPresent()) {
            String unlockCode = Config.getTestProp("dishAnywhereParentalCode");
            for (char c : unlockCode.toCharArray()) {
                switch (c) {
                    case '1':
                        button1.click();
                        break;
                    case '2':
                        button2.click();
                        break;
                    case '3':
                        button3.click();
                        break;
                    case '4':
                        button4.click();
                        break;
                    case '5':
                        button5.click();
                        break;
                    case '6':
                        button6.click();
                        break;
                    case '7':
                        button7.click();
                        break;
                    case '8':
                        button8.click();
                        break;
                    case '9':
                        button9.click();
                        break;
                    case '0':
                        button0.click();
                        break;

                }
            }
        }
        return this;
    }
}
