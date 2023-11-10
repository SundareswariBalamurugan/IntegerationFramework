package org.e2e.hooks;


import io.cucumber.testng.TestNGCucumberRunner;
import lombok.extern.slf4j.Slf4j;
import org.e2e.dataproviders.ConfigFileReader;
import org.e2e.utils.WebDriverUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

@Slf4j
public class Hooks  {

    private TestNGCucumberRunner testNGCucumberRunner;
    private ConfigFileReader configFileReader;
    static WebDriver driver;




    /**
     * Set up the TestNG test, by opening the Browser and setting the driver.
     *
     * @param result used to get the current test method name from
     */
    @BeforeMethod(alwaysRun = true)
    public void initTestNGConfig(final ITestResult result) {
        configFileReader = ConfigFileReader.getInstance();
        log.info("Running test: '{}'", result.getMethod()
                .getMethodName());
    }

    @BeforeMethod(alwaysRun = true)
    static void setupClass() {
        driver=  WebDriverUtil.getDriver();
    }

    /**
     * Create the Runner used for the automation framework.
     */
    @BeforeClass()
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    /**
     * Finish and close the test runner.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDownClass() {
        if (testNGCucumberRunner == null) {
            return;
        }
        testNGCucumberRunner.finish();
    }

}
