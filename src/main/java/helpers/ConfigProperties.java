package helpers;

import page.BasePage;

import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    protected static Properties configProperties;

    static {
        configProperties = new Properties();
        try {
            configProperties.load(BasePage.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new IllegalStateException("config.properties is not loaded", e);
        }
    }

    public static String getProperty(String property) {
        return configProperties.getProperty(property);
    }

}
