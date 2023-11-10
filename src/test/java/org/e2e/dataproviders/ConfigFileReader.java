package org.e2e.dataproviders;

import org.e2e.enums.PropertiesSetup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader extends PropertiesSetup {

    private static ConfigFileReader configFileReader;

    private ConfigFileReader(){

    }



    private static final String CONFIG_PROPS = "src//main//org.e2e.config//Configuration.properties";
    private static final String LOCATOR_PROPS = "src//main//org.e2e.config//Application.properties";


    public static ConfigFileReader getInstance() {
        if (configFileReader == null) {
            configFileReader = new ConfigFileReader();
        }
        return configFileReader;
    }

    public static void setConfig(){
        setConfigProps(readConfigFileValues(CONFIG_PROPS));
        setLocatorProps(readConfigFileValues(LOCATOR_PROPS));
    }

    /**
     * this method will read the values from properties file
     */

    public static Properties readConfigFileValues(String fileName){
        Properties props = new Properties();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            try {
                props.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + props);
        }
        return props;
    }


}
