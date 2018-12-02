package ru.shcheglov.geekbrains.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.shcheglov.geekbrains.hw.config.AppConfig;
import ru.shcheglov.geekbrains.hw.entity.Rifle;

/**
 * @author Alexey Shcheglov
 * @version dated 29.11.2018
 */

public class Client {

    public static void main(String[] args) {

        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        final Rifle rifle = context.getBean(Rifle.class);
        rifle.shoot();
    }
}
