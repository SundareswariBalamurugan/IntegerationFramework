package org.e2e.utils;


import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@Slf4j
public class HelperUtil{
     WebDriverUtil driverUtil = new WebDriverUtil();
     WebDriver driver = driverUtil.getDriver() ;


    public void launchUrl(String url){
        driver.get(url);
    }

    /**
     * this method will wait and click any particular element
     */

    public void clickElement(By element) {

        wait_forVisibilityof(element);
        driver.findElement((element)).click();
    }

    public void clear_Element(By element){
        driver.findElement((element)).clear();
    }

    public int randomNumberGenerator(){
        Random random = new Random();

        int rand = Math.abs(random.nextInt());

        return rand;
    }
    public String get_Attribute(By elem){
        WebElement element = driver.findElement(elem);
        String elementval = element.getAttribute("data-saferedirecturl");
        System.out.println("Element value is" + elementval);
        return elementval;
    }

    public void validateTitle(String title){
        String titleFromApp = driver.getTitle();
        assertThat("title is valid",titleFromApp,is(title));
    }



    /**
     * this method will validate two text
     */

    public void assertEquals(int actual, int expected) {

     Assert.assertEquals(actual, expected);

    }

    public void compare_twoDifferentText(String text1, String text2){
        if(!text1.equals(text2)){
            System.out.println("Texts are not equal");
        }else{
            Assert.assertFalse(text1.equals(text2),"Search isn't filtering the results");
        }
    }

    /**
     * this method will validate first text contains second text
     */

    public void assertContainsValue(String actual, String expected) {

        boolean compare_result = expected.contains(actual);
        Assert.assertTrue(compare_result );

    }



    /**
     * this method will navigate back to previous page
     */

    public void deviceBack() {
        driver.navigate().back();
    }

    /**
     * this method will click particular element
     */

    public void click(By by) {
        wait_forVisibilityof(by);
        driver.findElement(by).click();
    }

    /**
     * this method will send input text to a particular element
     */

    public void sendtexttoInput(By element, String value) {
        wait_forVisibilityof(element);
        driver.findElement(element).sendKeys(value);
    }

    /**
     * this method will fetch the value from element and validate against expected
     * text
     */

    public void passingKeyboardValue(By element){
        driver.findElement(element).sendKeys(Keys.ENTER);
    }

    public void assertText(By element, String text) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        Assert.assertEquals(driver.findElement(element).getText(), "");
    }

    /**
     * this method wait for visibility of particular element
     */

    public void wait_forVisibilityof(By element) {
        // explicit wait - to wait for the compose button to be click-able

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    }

    public void move_tonewTab(){
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

    }

    /**
     * this method will validate whether element is present or not
     */

    public boolean isElementPresent(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * this method will validate whether element is enabled or not
     */

    public boolean isEnableElement(By element) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        Assert.assertTrue(driver.findElement(element).isEnabled());
        return true;
    }

    /**
     * this method will wait for particular element
     */

    public void waitforFewSeconds() {
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    /**
     * this method will validate find a element
     */

    public WebElement waitAndFindElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * this method will make the thread go for sleep for sometime
     */

    public void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method will validate whether actual and expected text are matching
     */

    public static boolean verifyTextMatch(String actualText, String expectedText) {
        boolean flag = false;
        try {
            log.info("Actual Text From Application Web UI --> :: " + actualText);
            log.info("Expected Text From Application Web UI --> :: " + expectedText);

            if (actualText.equals(expectedText)) {
                log.info("### VERIFICATION TEXT MATCHED !!!");
                flag = true;
            } else {
                log.error("### VERIFICATION TEXT DOES NOT MATCHED !!!");
            }

        } catch (Exception Ex) {
            log.error("Exception Occurred While Verifying The Text Match: " + Ex.getMessage());
        }
        return flag;
    }

    /**
     * this method will get the current URL of the page
     */

    public String getCurrenURL() {
        String current_URL;
        getImplicitlyWait();
        current_URL = driver.getCurrentUrl();
        return current_URL;
    }

    /**
     * this method will make the method wait for defined seconds
     */

    public void getImplicitlyWait() {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("waiting for " + 30 + " sec");

    }

    /**
     * @param element
     * @return this method will return text from the web element
     */
    public String getText(By element) {

        wait_forVisibilityof(element);
        String text_Val = driver.findElement((element)).getText();
        //System.out.println("Text value inside header is " + text_Val);
        if (text_Val != null) {
            return text_Val;
        } else {
            throw new RuntimeException("Text value from screen is empty");

        }

    }

    /**
     * this method will scroll down the page
     */

    public void scrollDown(int scroll_Val) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0," + scroll_Val + ")");
    }

    public void scrollUp(int scroll_Val) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(" + scroll_Val +", 0)");
    }

    /**
     * this method will scroll down the page until a particular element
     */

    public void scrollUntilElementVisible(By element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(element);
        jse.executeScript("arguments[0].scrollIntoView();", Element);

    }


    /**
     * this method will scroll down to bottom of the page
     */

    public void scrollTotheBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }




    /**
     * this method is to hover over the element
     */

    public void hoverOverElement(By element1, By element2) {

        Actions action = new Actions(driver);
        WebElement we = driver.findElement(element1);
        action.moveToElement(we).moveToElement(driver.findElement(element2)).click().build().perform();

    }


    /**
     * this method is to list of Webelements
     */
    public List<WebElement> selectElementFromList(By element){
        List<WebElement> listVal = driver.findElements(element);
        return listVal;
    }


    @AfterAll
    public void tearDown(){
        driver.quit();
    }




    /**
     * this method is to hover over the element
     */

    public void selectvaluesFromDropdown(By element1,String value) {

        //wait_forVisibilityof(element1);
        Select select_fromdrpdown = new Select(driver.findElement(element1));
        select_fromdrpdown.selectByValue(value);

    }

    public void alertManager(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            driver.switchTo().alert().sendKeys("");
            driver.switchTo().alert().dismiss();

        } catch (Exception e) {
            //exception handling
        }
    }


}
