package com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire;

import com.prototest.solanum.*;

import java.awt.*;

/**
 * Created by Brian on 6/11/2014.
 */
public class KindleSettings extends DeviceMain {
    EggplantElement applications = new EggplantElement("applications", By.Text("Applications", SearchRectangle.Quadrants.LEFT_QUARTER,TextOption.contrast(true), TextOption.contrastColor("Black")));
    EggplantElement manageAllApplications = new EggplantElement("manageAllApplications", By.Text("Manage All Applications", SearchRectangle.Quadrants.LEFT_QUARTER,TextOption.contrast(true), TextOption.contrastColor("Black")));
    EggplantElement middleOfScreen = new EggplantElement("middleOfScreen", By.Point(new Point(EggplantTestBase.driver.getScreenSize().x/2,EggplantTestBase.driver.getScreenSize().y/2)));
    EggplantElement forceStopButton = new EggplantElement("forceStopButton", By.Text("Force stop", SearchRectangle.Quadrants.LEFT_QUARTER));
    EggplantElement forceStopPopupButton = new EggplantElement("forceStopPopupButton", By.Text("Force Stop", SearchRectangle.Quadrants.BOTTOM_HALF));


    public KindleSettings stopApplication(String name){
        EggplantElement app = new EggplantElement("app", By.Text(name, SearchRectangle.Quadrants.LEFT_QUARTER,TextOption.contrast(true)));

        applications.waitForPresent().click();
        manageAllApplications.waitForPresent().click();
        for(int i=0;(i<10&&!app.isPresent());i++){
            EggplantTestBase.driver.scrollWheelDown("1");
        }
        app.click();
        forceStopButton.waitForPresent(30).click();
        forceStopPopupButton.waitForPresent(30).click();
        return this;
    }


}
