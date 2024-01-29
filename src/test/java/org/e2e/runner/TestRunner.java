package org.e2e.runner;

import io.cucumber.testng.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions(plugin = {"pretty", "html:../reports/", "json:reports/cucumber.json"},
        features = {"src/test/resources/features/backend"}, glue = {"org.e2e.steps"},
        tags = "@weather" )

@Test(priority = 1)
@Slf4j
public class TestRunner extends CustomTestNGCucumberTests {

    /**
     * Get the scenarios to run.
     *
     * @param context Test context with information and parameter about/for the tests
     * @return Object[][] two-dimensional array with all desired test scenarios
     */
    @DataProvider
    @Override
    public Object[][] scenarios(final ITestContext context) {
        if (getTestNGCucumberRunner() == null) {
            return new Object[0][0];
        }
        return getTestNGCucumberRunner().provideScenarios();
    }



}
