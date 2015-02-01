package com.ilyamur.topaz.swing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppProperties {

    public static final String PATH = "./topaz-swing.properties";

    public static final String INITIAL_A = "initial_a";
    public static final String INITIAL_B = "initial_b";
    public static final String INITIAL_LINE = "initial_line";

    public String getProperty(String name) {
        Properties properties = new Properties();
        try {
            FileInputStream file = new FileInputStream(PATH);
            try {
                properties.load(file);
            } finally {
                try {
                    file.close();
                } catch (Throwable ignored) {
                    //
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(name);
    }
}
