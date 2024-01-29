package org.e2e.enums;

import java.util.Properties;

public class PropertiesSetup {

    static Properties configProps;

    public  Properties getConfig_props() {
        return configProps;
    }

    public static void setConfigProps(Properties newConfigProps) {
        configProps = newConfigProps;
    }


}
