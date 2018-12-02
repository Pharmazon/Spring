package ru.shcheglov.geekbrains.hw.hw2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.shcheglov.geekbrains.hw.hw2.components.Camera;
import ru.shcheglov.geekbrains.hw.hw2.config.AppConfig;

/**
 * @author Alexey Shcheglov
 * @version dated 01.12.2018
 */

public class Client {

    public static void main(String[] args) {

        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Camera camera = context.getBean("camera", Camera.class);
        camera.breaking();
        camera.doPhotograph();

        camera = context.getBean("camera", Camera.class);
        camera.outdating();
        camera.doPhotograph();

        camera = context.getBean("camera", Camera.class);
        camera.doPhotograph();
    }
}
