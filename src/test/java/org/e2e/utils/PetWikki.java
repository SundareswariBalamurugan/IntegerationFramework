package org.e2e.utils;

import org.openqa.selenium.*;
import java.io.*;
import org.openqa.selenium.chrome.*;
import java.util.concurrent.TimeUnit;

public class PetWikki {
    public static String getLoadedData(WebDriver driver) {
        WebElement loadButton = driver.findElement(By.id("load-button"));
        if(loadButton.isEnabled()==false){
            driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        }
        WebElement innerHtml= driver.findElement(By.xpath("/html/head/document/"));
        innerHtml.getAttribute("innerHTML");

        return null;
    }
}
