package ru.shcheglov.geekbrains.lessons.lesson2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alexey Shcheglov
 * @version dated 01.12.2018
 */

@Configuration
@ComponentScan({"ru.shcheglov.geekbrains.lessons.lesson2.components",
                "ru.shcheglov.geekbrains.lessons.lesson2.lifecycle"})
public class AppConfig {
}
