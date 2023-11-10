package org.e2e.steps.frontEnd;

import io.cucumber.java.en.Given;


public class HomeSteps extends BaseSteps{

    @Given("User launches the Runa.io site")
    public void user_launches_the_runa_io_site() {
        home.launchApplication();

    }

    @Given("title should be {string}")
    public void title_should_be(String title) {
        home.validateTitleOfPage(title);
        home.acceptCookie();
        home.selectRunaSendFromSubmenu();

    }

}
