package org.e2e.pages;

import org.e2e.utils.DataLoadingUtil;
import org.e2e.utils.HelperUtil;
import org.e2e.utils.WebDriverUtil;

public class BasePage {
    static final DataLoadingUtil dataLoadUtil = new DataLoadingUtil();
     final WebDriverUtil driverUtil = new WebDriverUtil();
     final HelperUtil helperUtil = new HelperUtil();
}
