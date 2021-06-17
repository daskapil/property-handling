package com.kapil.sample;

import com.kapil.sample.config.AppConfigClassPath;
import com.kapil.sample.config.AppConfigFileSystem;
import com.kapil.sample.config.AppConfigResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private static final String DB_URL = "db.url";
    private static final String DB_USER = "db.user";
    private static final String DB_PASSWORD = "db.password";

    public static void main(String[] args) {
        LOGGER.info("--- From CLASSPATH using Static Method  ----");
        LOGGER.info(AppConfigClassPath.getProperty(DB_URL));
        LOGGER.info(AppConfigClassPath.getProperty(DB_USER));
        LOGGER.info(AppConfigClassPath.getProperty(DB_PASSWORD));

        LOGGER.info("--- From CLASSPATH using Non-Static Method ----");
        AppConfigClassPath appConfigClassPath = new AppConfigClassPath();
        LOGGER.info(appConfigClassPath.getPropertyNonStatic(DB_URL));
        LOGGER.info(appConfigClassPath.getPropertyNonStatic(DB_USER));
        LOGGER.info(appConfigClassPath.getPropertyNonStatic(DB_PASSWORD));

        LOGGER.info("--- From FILE SYSTEM  ----");
        LOGGER.info(AppConfigFileSystem.getProperty(DB_URL));
        LOGGER.info(AppConfigFileSystem.getProperty(DB_USER));
        LOGGER.info(AppConfigFileSystem.getProperty(DB_PASSWORD));

        // Unlike above; DB_URL, DB_USER & DB_PASSWORD @ below are Enum declared in AppConfigResourceBundle
        LOGGER.info("--- Using ResourceBundle  ----");
        LOGGER.info(AppConfigResourceBundle.DB_URL.getValue());
        LOGGER.info(AppConfigResourceBundle.DB_USER.getValue());
        LOGGER.info(AppConfigResourceBundle.DB_PASSWORD.getValue());
    }


}
