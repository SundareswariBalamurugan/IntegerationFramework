package org.e2e.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Genomics {

    public static final String ACCEPTCOOKIE = "elc-accept-link";
    public static final String SEARCHINNAVBAR = "//a[@href='/search']";
    public static final String SEARCHINPUTFIELD = "global--search";
    public static final String SEARCHRESULTCOUNT = "p.text-charcoal.mb-30.h5";
    public static final String SEARCHRESULTS = "span.block.mb-10.h4.o-link--heading";

    public static final String VIEWRESULTS ="//span[@class='inline-block mt-10 o-link']";





    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.genomicsengland.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        String titleValue= driver.getTitle();
        System.out.println("title value is" +titleValue);

        WebElement acceptCookie = driver.findElement(By.id(ACCEPTCOOKIE));
        acceptCookie.click();

        List<WebElement> searchInNavBar = driver.findElements(By.xpath(SEARCHINNAVBAR));
        searchInNavBar.get(0).click();

        WebElement searchInputField = driver.findElement(By.id(SEARCHINPUTFIELD));
        WebDriverWait waits =  new WebDriverWait(driver, Duration.ofSeconds(30));
        waits.until(ExpectedConditions.presenceOfElementLocated(By.id(SEARCHINPUTFIELD)));
        searchInputField.sendKeys("Gene");
        searchInputField.sendKeys(Keys.ENTER);



        FluentWait waitfluent = new FluentWait(driver);
        waitfluent.withTimeout(Duration.ofSeconds(3000)).
                pollingEvery(Duration.ofSeconds(20)).ignoring(Exception.class).
                    withMessage(SEARCHRESULTCOUNT+"Not visible after wait");


        waitfluent.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(SEARCHRESULTCOUNT)));
        WebElement resultCount = driver.findElement(By.cssSelector(SEARCHRESULTCOUNT));
        String valueCount = resultCount.getText().replace(" results found","");
        int value = Integer.parseInt(valueCount);
        System.out.println(" result count is " + value);

        List<WebElement> results = driver.findElements(By.cssSelector(SEARCHRESULTS));
        List<WebElement> viewMore = driver.findElements(By.xpath(VIEWRESULTS));
        System.out.println("result value" + results.size());
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,100)");

        System.out.println(results.get(3).getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
        JavascriptExecutor jsee = (JavascriptExecutor)driver;
        jsee.executeScript("window.scrollBy(0,100)");


       // driver.findElement(By.linkText(results.get(3).getText())).click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       // File newFile = new File("/Users/susi/Desktop/Integeration/Integeration-Framework/src/test/resources/data/screenshot.docx");
        FileUtils.copyFile(srcFile,new File("/Users/susi/Desktop/Integeration/Integeration-Framework/src/test/resources/data/screenshot.png"));

        File newElementFile = searchInputField.getScreenshotAs(OutputType.FILE);
//       for (int i=0;i<results.size();i++) {
//            System.out.println("result value of " + results.get(i).getText());
//            if(results.get(i).getText().equalsIgnoreCase(
//                    " GENE Consortium Launch Event ")){
//                JavascriptExecutor jse = (JavascriptExecutor) driver;
//                jse.executeScript("arguments[0].scrollIntoView();",viewMore.get(i));
//
//            }
//
//        }

        //driver.close();
        Map<String,Integer> map = new HashMap<>();

        String value1;
        BufferedReader reader = new BufferedReader(new FileReader(""));
        value1 = reader.readLine();
        if(value1!=null){

        }

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        driver.switchTo().frame(0);
        driver.navigate().back();
    }



}
