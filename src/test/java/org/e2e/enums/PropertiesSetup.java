package org.e2e.enums;

import java.util.Properties;

public class PropertiesSetup {

    static Properties configProps;
    static Properties locatorProps;
    public  Properties getConfig_props() {
        return configProps;
    }

    public static void setConfigProps(Properties newConfigProps) {
        configProps = newConfigProps;
    }

    public Properties getLocatorProps() {
        return locatorProps;
    }

    public static void setLocatorProps(Properties newLocatorProps) {
     locatorProps = newLocatorProps;
    }
}
