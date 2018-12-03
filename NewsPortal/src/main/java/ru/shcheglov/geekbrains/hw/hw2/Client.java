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

        final Camera firstCamera = context.getBean("camera", Camera.class);
        firstCamera.breaking();
        firstCamera.doPhotograph();

        final Camera secondCamera = context.getBean("camera", Camera.class);
        secondCamera.outdating();
        secondCamera.doPhotograph();

        final Camera thirdCamera = context.getBean("camera", Camera.class);
        thirdCamera.doPhotograph();
    }
}
