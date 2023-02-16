package com.kazmiruk.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ExternalPropertiesFile {

    private final Logger logger = LoggerFactory.getLogger(ExternalPropertiesFile.class);

    private String filename;

    private final Properties properties = new Properties();

    public ExternalPropertiesFile(String filename) {
        try {
            this.filename = filename;
            String fileConfigPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(filename)).getPath();
            logger.info("Path to the properties file: {}", fileConfigPath);
            properties.load(new FileInputStream(fileConfigPath));
            logger.info("File {} read successfully", filename);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public String getProperty(String key) {
        String property = properties.getProperty(key);
        logger.info("{} = {}", key, property);
        return property;
    }

    public String getFilename() {
        return filename;
    }
}
