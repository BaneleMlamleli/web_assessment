package com.ndosi.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigReader {

    private Properties properties;
    FileInputStream fileInputStream;

    public Logger logger = LogManager.getLogger(new Object() {
    }.getClass().getName());

    public ConfigReader() {
        properties = new Properties();
        try {
            fileInputStream = new FileInputStream("src/test/resources/config/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            logger.error("'" + e.getMessage() + "' in method '" + new Object() {
            }.getClass().getEnclosingMethod().getName() + "'");
            System.out.println("'" + e.getMessage() + "' in method '" + new Object() {
            }.getClass().getEnclosingMethod().getName() + "'");
        }
    }

    public String getProperty(String key) {
        logger.info("**** Executing getProperty method in ConfigReader class ****");
        return properties.getProperty(key);
    }

}
