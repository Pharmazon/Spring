package ru.shcheglov.geekbrains.lessons.lesson3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import ru.shcheglov.geekbrains.lessons.lesson3.util.Assets;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Alexey Shcheglov
 * @version dated 02.12.2018
 */

@Configuration
@ComponentScan("ru.shcheglov.geekbrains.lessons.lesson3.entity")
public class AppConfig {

    @Bean(name = "dataSource")
    public DataSource getDataSource() {

        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(Assets.getInstance().getUrl());
        dataSource.setUsername(Assets.getInstance().getUserName());
        dataSource.setDriverClassName(Assets.getInstance().getClassName());
        dataSource.setPassword(Assets.getInstance().getPassword());

        return dataSource;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManager() {

        final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(getDataSource());

        final Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", Assets.getInstance().getDialect());
        jpaProperties.put("hibernate.max_fetch_depth", Assets.getInstance().getMaxFetchDepth()));
        jpaProperties.put("hibernate.jdbc.fetch_size", Assets.getInstance().getFetchSize());
        jpaProperties.put("hibernate.jdbc.batch_size", Assets.getInstance().getBatchSize());
        jpaProperties.put("hibernate.show_sql", Assets.getInstance().isShowSql());
        factory.setJpaProperties(jpaProperties);

        return factory;
    }
}
