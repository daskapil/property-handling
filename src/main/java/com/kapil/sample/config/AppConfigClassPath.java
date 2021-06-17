package com.kapil.sample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// Load property from classpath using ClassLoader
public class AppConfigClassPath {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfigClassPath.class);
    private static final String APPLICATION_PROPERTIES = "application.properties";

    // 1. loadPropertyFile - it is a static method.
    private static Properties loadPropertyFile() {
        Properties properties = new Properties();

        try (InputStream inputStream = AppConfigClassPath.class.getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES)) {
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            LOGGER.error("Could not read the application.properties file!");
            e.printStackTrace();
            return null;
        }
    }

    // 2. If you want to load the properties file from a non-static method,
    //    you should use the getClass() method
    private Properties loadPropertyFileNonStatic() {
        Properties properties = new Properties();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES)) {
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

    public String getPropertyNonStatic(String key) {
        Properties properties = loadPropertyFileNonStatic();
        return properties.getProperty(key);
    }

}
