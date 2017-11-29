package main.java.com.epam.parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjectProperties {
    private static Properties properties;

    static {
        init();
    }

    private static void init() {
        properties = new java.util.Properties();
        try {
            properties.load(new FileInputStream("default.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProperties() {
        return properties;
    }
}