package com.kapil.sample.config;

import java.util.ResourceBundle;

public enum AppConfigResourceBundle {
    DB_URL,
    DB_USER,
    DB_PASSWORD;

    ResourceBundle appConfigResourceBundle = ResourceBundle.getBundle("application");

    public String getValue() {
        return appConfigResourceBundle.getString(name());
    }
}
