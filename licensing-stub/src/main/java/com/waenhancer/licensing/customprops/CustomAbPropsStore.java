package com.waenhancer.licensing.customprops;

public interface CustomAbPropsStore {
    boolean getBoolean(String key, boolean defaultValue);
    void putBoolean(String key, boolean value);
    String getString(String key, String defaultValue);
    void putString(String key, String value);
}