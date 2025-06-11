package ru.rzd.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String get(String key){
        String value = properties.getProperty(key);
        if(value == null){
            throw new RuntimeException("Ключ "+value+" не найден в cinfig.properties");
        }
        return value;
    }
}
