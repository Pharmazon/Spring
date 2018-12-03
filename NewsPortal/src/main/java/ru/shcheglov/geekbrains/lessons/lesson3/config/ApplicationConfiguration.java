package ru.shcheglov.geekbrains.lessons.lesson3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Alexey Shcheglov
 * @version dated 03.12.2018
 */

@Configuration
@ComponentScan("ru.shcheglov.geekbrains.lessons.lesson3")
@Import(DataSourceConfiguration.class)
public class ApplicationConfiguration {
}
