package org.e2e.steps.frontEnd;

import io.cucumber.java.en.Given;
import org.e2e.pages.HomePage;


public class HomeSteps {

    HomePage home;

    public HomeSteps() {
        this.home =  new HomePage();
    }

    @Given("User launches the Genomics England site")
    public void user_launches_the_genomics_england_site() {
        home.launchApplication();
    }


    @Given("title should be {string}")
    public void title_should_be(String title) {
        home.validateTitleOfPage(title);
        home.acceptCookie();
        home.selectRunaSendFromSubmenu();

    }

}
