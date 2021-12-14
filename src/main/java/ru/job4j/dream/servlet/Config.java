package ru.job4j.dream.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private final Properties properties = new Properties();

    public Config() {
        try (FileInputStream input = new FileInputStream("c:\\projects\\job4j_dreamjob\\data\\dreamjob.properties")) {
            properties.load(input);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String name) {
        return properties.getProperty(name);
    }

}
