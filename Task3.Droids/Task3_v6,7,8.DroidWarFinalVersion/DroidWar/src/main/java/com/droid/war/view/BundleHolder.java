package com.droid.war.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundleHolder {
    private static ResourceBundle bundle = ResourceBundle.getBundle("resources", new Locale("en", "US"));

    public static ResourceBundle getBundle() {
        return bundle;
    }

    public static void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle("resources", locale);
    }

}
