package ru.shcheglov.geekbrains.lessons.lesson1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Alexey Shcheglov
 * @version dated 02.12.2018
 */

public class Client {

    public static void main(String[] args) {

        //Раскомментируйте нижеследующую строку, для использования XML-конфигурации
        //ApplicationContext context  = new ClassPathXmlApplicationContext("config.xml");

        //Раскомментируйте нижследующую строку для использования JavaConfig
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        Camera camera = context.getBean("camera", Camera.class);
        camera.doPhotograph();
    }
}
