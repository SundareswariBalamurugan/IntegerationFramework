package org.e2e.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

      final String URL_VAL =dataLoadUtil.fetchConfigValue("app_url");




      public  static final String ACCEPTCOOKIE= dataLoadUtil.fetchLocatorValue("acceptCookie");
      public static final String PRODUCTOPTIONINMENU = dataLoadUtil.fetchLocatorValue("menuOptions");

      public static final String PRODUCTSUBMENUOPTION = dataLoadUtil.fetchLocatorValue("submenuOptions");


      static By homepageAcceptCookie = By.id(ACCEPTCOOKIE);

      static By menuListProduct = By.cssSelector(PRODUCTOPTIONINMENU);
      static By subMenuList = By.xpath(PRODUCTSUBMENUOPTION);




      public void launchApplication(){
          helperUtil.launchUrl(URL_VAL);
      }

      public void validateTitleOfPage(String title){
          helperUtil.validateTitle(title);
      }

      public void acceptCookie(){
          helperUtil.wait_forVisibilityof(homepageAcceptCookie);
          helperUtil.click(homepageAcceptCookie);
          helperUtil.click(menuListProduct);

      }

      public void selectRunaSendFromSubmenu(){
          List<WebElement> valuesInSubmenuList = helperUtil.selectElementFromList(subMenuList);
          for(int i=0;i<valuesInSubmenuList.size();i++){
              if((valuesInSubmenuList.get(i).getAttribute("id").equalsIgnoreCase("runa-send"))){
                  valuesInSubmenuList.get(i).click();
              }
          }

      }

}
