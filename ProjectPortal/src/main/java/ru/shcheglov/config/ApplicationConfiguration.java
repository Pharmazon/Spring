package ru.shcheglov.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Alexey Shcheglov
 * @version dated 16.12.2018
 */

@Configuration
@Import(DataSourceConfiguration.class)
public class ApplicationConfiguration {
}
