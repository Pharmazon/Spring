package ru.shcheglov.geekbrains.lessons.lesson3.util;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Alexey Shcheglov
 * @version dated 03.12.2018
 */

public class Assets {

    private static Assets instance;

    private final Properties PROPERTIES;

    @Getter
    private String url;

    @Getter
    private String userName;

    @Getter
    private String className;

    @Getter
    private String password;

    @Getter
    private String dialect;

    @Getter
    private int maxFetchDepth;

    @Getter
    private int fetchSize;

    @Getter
    private int batchSize;

    @Getter
    private boolean showSql;

    private Assets() {
        this.PROPERTIES = new Properties();
        this.readProperties();
    }

    public static synchronized Assets getInstance() {
        if (instance == null) {
            instance = new Assets();
        }
        return instance;
    }

    private void readProperties() {
        try (InputStream in = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("config.properties")) {
            this.PROPERTIES.load(in);
            this.url = PROPERTIES.getProperty("db_url");
            this.userName = PROPERTIES.getProperty("db_username");
            this.className = PROPERTIES.getProperty("db_classname");
            this.password = PROPERTIES.getProperty("db_password");

            this.dialect = PROPERTIES.getProperty("hibernate.dialect");
            this.maxFetchDepth = Integer.parseInt(PROPERTIES.getProperty("hibernate.max_fetch_depth"));
            this.fetchSize = Integer.parseInt(PROPERTIES.getProperty("hibernate.jdbc.fetch_size"));
            this.batchSize = Integer.parseInt(PROPERTIES.getProperty("hibernate.jdbc.batch_size"));
            this.showSql = Boolean.parseBoolean(PROPERTIES.getProperty("hibernate.show_sql"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
