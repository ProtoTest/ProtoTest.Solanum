package com.echostar.dish_anywhere.tests.aPhone.galaxyS5;

import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DeviceMain;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereHome;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereLogin;
import com.echostar.dish_anywhere.screenobjects.aPhone.galaxyS5.DishAnywhereSettings;
import com.prototest.solanum.Config;
import com.prototest.solanum.CukePlant;
import com.prototest.solanum.PageFunction;
import com.prototest.solanum.Verifications;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 */
public class s5testdefs extends CukePlant {
    @Given("^the application is in a clean state$")
    public void applicationSetup() throws Throwable {
        at( new DeviceMain()
                .goHome()
                .openDishAnywhereApp()
                .logOutIfLoggedIn()
                .login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass"))
                .closePopups()
        );
    }

    @And("^the application is on the on the guide$")
    public void openGuide() throws Throwable {
        at((DishAnywhereHome home) -> home.openGuide());
    }


    @When("^the user clicks settings$")
    public void the_user_clicks_settings() throws Throwable {
        at((DishAnywhereHome home) -> home.openSettings());
    }

    @And("^the user clicks logs out$")
    public void the_user_clicks_logs_out() throws Throwable {
        at((DishAnywhereSettings settings) -> settings.logout());
    }

    @And("^the user logs in$")
    public void the_user_logs_in() throws Throwable {
        at((DishAnywhereLogin login_screen) ->
             login_screen.login(Config.getTestProp("dishAnywhereLoginName"), Config.getTestProp("dishAnywhereLoginPass")));
    }

    @Then("^the application should be logged in")
    public void the_application_should_be_on_the_guide() throws Throwable {
        at((DishAnywhereHome home) -> home.verifyLoggedIn());
    }
}
