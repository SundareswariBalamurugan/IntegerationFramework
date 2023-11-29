package org.e2e.pages;


import org.e2e.utils.DataLoadingUtil;
import org.e2e.utils.HelperUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

        static final DataLoadingUtil dataLoadUtil = new DataLoadingUtil();
        final HelperUtil helperUtil = new HelperUtil();

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
          valuesInSubmenuList.get(0).click();

      }

}
