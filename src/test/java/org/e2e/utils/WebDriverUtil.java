package org.e2e.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * this Class will get the browser from run time input
 * and launch the particular driver
 */
public class WebDriverUtil {


    static WebDriver driver;
    String driver_Option="Chrome" ;
   // driver_Option = System.getProperty("app.browser");
    private static  final String CHROME_PATH ="src/test/resources/drivers/Chrome/Chrome/chromedriver_V114";

    public WebDriverUtil() {

        switch (driver_Option){
            case "Firefox":
                setDriver(launchFirefox());
                break;
            case "Safari":
                setDriver(launchSafari());
                break;
            default:
                setDriver(launchChrome());

        }
    }


    public static WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver launchChrome(){
       // System.setProperty("webdriver.chrome.driver",CHROME_PATH);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver launchFirefox(){
        WebDriverManager.firefoxdriver().setup();
        return driver;
    }

    public WebDriver launchSafari(){
        driver = new SafariDriver();
        return driver;
    }


}
