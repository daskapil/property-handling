package com.kapil.sample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// Load the properties from file system
public class AppConfigFileSystem {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfigFileSystem.class);

    //Specify absolute or relative path for property file
    private static final String PROPERTY_FILE_PATH = "C:\\Dev\\property-handling\\src\\main\\resources\\application.properties";

    private static Properties loadPropertyFile() {
        Properties properties = new Properties();

        try (InputStream inputStream = new FileInputStream(PROPERTY_FILE_PATH)) {
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            LOGGER.error("Could not read the application.properties file!");
            e.printStackTrace();
            return null;
        }
    }

    public static String getProperty(String key) {
        Properties properties = loadPropertyFile();
        return properties.getProperty(key);
    }

}
