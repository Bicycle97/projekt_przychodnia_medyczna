package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
    private static String CONFIG_FILENAME = "/config/config.properties";
    private static ConfigProperties configManager;
    private Properties properties;

    private ConfigProperties() {
        properties = new Properties();
        loadProperties();
    }

    public static ConfigProperties getInstance() {
        if (configManager == null) {
            configManager = new ConfigProperties();
        }
        return configManager;
    }

    private void loadProperties() {
        InputStream inputStream;
        try {
            inputStream = this.getClass().getResource(CONFIG_FILENAME).openStream();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
