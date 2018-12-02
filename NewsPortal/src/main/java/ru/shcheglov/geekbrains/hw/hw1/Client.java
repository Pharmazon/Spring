package ru.shcheglov.geekbrains.hw.hw1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.shcheglov.geekbrains.hw.hw1.config.AppConfig;
import ru.shcheglov.geekbrains.hw.hw1.component.Rifle;

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
