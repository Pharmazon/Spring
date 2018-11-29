package ru.shcheglov.geekbrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.shcheglov.geekbrains.config.AppConfig;
import ru.shcheglov.geekbrains.entity.Rifle;

public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Rifle rifle = context.getBean(Rifle.class);
        rifle.shoot();
    }
}
