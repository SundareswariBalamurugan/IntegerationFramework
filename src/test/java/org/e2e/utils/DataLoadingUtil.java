package org.e2e.utils;

import org.e2e.dataproviders.ConfigFileReader;
import org.e2e.enums.PropertiesSetup;

public class DataLoadingUtil extends PropertiesSetup {

    private final ConfigFileReader configFileReader;

    public DataLoadingUtil() {
        this.configFileReader = ConfigFileReader.getInstance();
    }

    /**
     * this method will fetch the values from Configuration.properties file
     */

    public  String fetchConfigValue(String value) {
        String config_Val = null;
        ConfigFileReader.getInstance().setConfig();
        config_Val = getConfig_props().getProperty(value).toString();
        if (config_Val != null)
            return config_Val;
        else
            throw new RuntimeException("values not specified in the Configuration.properties file for this element.");
    }

    /**
     * this method will fetch the locator values from Application.properties file
     */
    public String fetchLocatorValue(String element) {
        String locator_Val = null;
        locator_Val = getLocatorProps().getProperty(element).toString();
        if (locator_Val != null)
            return locator_Val;
        else
            throw new RuntimeException("values not specified in the Configuration.properties file for this element.");
    }
}
