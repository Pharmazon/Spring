package ru.shcheglov.geekbrains.hw.hw4.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Alexey Shcheglov
 * @version dated 06.12.2018
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("ru.shcheglov.geekbrains.hw.hw4.repository")
@ComponentScan("ru.shcheglov.geekbrains.hw.hw4.service")
@Import(DataSourceConfiguration.class)
public class ApplicationConfiguration {
}
