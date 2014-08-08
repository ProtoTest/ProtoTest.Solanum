package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.By;
import com.prototest.solanum.EggplantElement;

/**
 * Created by Brian on 6/3/2014.
 */
public class EnterPasscodePopup {
    private EggplantElement LoadingMessage = new EggplantElement("LoadingMessage", By.Text("Loading"));

    private EggplantElement enterPasscodeHeader = new EggplantElement("enterPasscodeHeader", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Popups/Passcode/EnterPasscodeHeader"));
    private EggplantElement button1 = new EggplantElement("button1", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Popups/Passcode/PasscodeButton1"));
    private EggplantElement button2 = new EggplantElement("button2", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Popups/Passcode/PasscodeButton2"));
    private EggplantElement button3 = new EggplantElement("button3", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Popups/Passcode/PasscodeButton3"));
    private EggplantElement button4 = new EggplantElement("button4", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Popups/Passcode/PasscodeButton4"));
    private EggplantElement button5 = new EggplantElement("button5", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Popups/Passcode/PasscodeButton5"));
    private EggplantElement button6 = new EggplantElement("button6", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Popups/Passcode/PasscodeButton6"));
    private EggplantElement button7 = new EggplantElement("button7", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Popups/Passcode/PasscodeButton7"));
    private EggplantElement button8 = new EggplantElement("button8", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Popups/Passcode/PasscodeButton8"));
    private EggplantElement button9 = new EggplantElement("button9", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Popups/Passcode/PasscodeButton9"));
    private EggplantElement button0 = new EggplantElement("button0", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Popups/Passcode/PasscodeButton0"));
    private EggplantElement backspaceButton = new EggplantElement("Passcode backspace", By.Image("KindleTablet/KindleFireHDX/Apps/DishAnywhere/Popups/Passcode/PasscodeButtonBack"));

    public DishAnywhereMovie enterPasscodeIfPresent(String passcode) {
        if (enterPasscodeHeader.isPresent()) {
            return enterPasscode(passcode);
        }
        return new DishAnywhereMovie();
    }

    public DishAnywhereMovie enterPasscode(String passcode) {
        for (int attempt = 0; attempt < 5 && button1.isPresent(); attempt++) {
            for (char c : passcode.toCharArray()) {
                switch (c) {
                    case '1':
                        button1.waitForPresent().click();
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
            // Sometimes eggplant fails to enter all four digits. If so, back the code out and try again.
            if (button1.isPresent()) {
                backspaceButton.click();
                backspaceButton.click();
                backspaceButton.click();
                backspaceButton.click();
            } else {
                break;
            }

        }

        return new DishAnywhereMovie();
    }
}
