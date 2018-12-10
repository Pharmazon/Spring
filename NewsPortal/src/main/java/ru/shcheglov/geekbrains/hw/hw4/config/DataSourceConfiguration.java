package ru.shcheglov.geekbrains.hw.hw4.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Alexey Shcheglov
 * @version dated 07.12.2018
 */

@PropertySource("classpath:config.properties")
public class DataSourceConfiguration {

    @Bean
    public DataSource dataSource(
            @Value("${db_url}") final String dbUrl,
            @Value("${db_username}") final String dbUserName,
            @Value("${db_driver}") final String dbDriver,
            @Value("${db_password}") final String dbPassword
    ) {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUserName);
        dataSource.setDriverClassName(dbDriver);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            final DataSource dataSource,
            @Value("${hibernate.max_fetch_depth}") final int maxFetchDepth,
            @Value("${hibernate.jdbc.fetch_size}") final int fetchSize,
            @Value("${hibernate.jdbc.batch_size}") final int batchSize,
            @Value("${hibernate.show_sql}") final boolean showSql,
            @Value("${hibernate.hbm2ddl.auto}") final String tableStrategy,
            @Value("${hibernate.dialect}") final String dialect
    ) {
        final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPackagesToScan("ru.shcheglov.geekbrains.hw.hw4.entity");
        final Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.max_fetch_depth", maxFetchDepth);
        properties.put("hibernate.jdbc.fetch_size", fetchSize);
        properties.put("hibernate.jdbc.batch_size", batchSize);
        properties.put("hibernate.show_sql", showSql);
        properties.put("hibernate.hbm2ddl.auto", tableStrategy);
        factoryBean.setJpaProperties(properties);
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(final LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
        return transactionManager;
    }
}
