package ru.shcheglov.geekbrains.hw.hw4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.shcheglov.geekbrains.hw.hw4.config.ApplicationConfiguration;
import ru.shcheglov.geekbrains.hw.hw4.service.Service;

/**
 * @author Alexey Shcheglov
 * @version dated 06.12.2018
 */

public class Main {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        final Service adService = context.getBean("adService", Service.class);
        final Service categoryService = context.getBean("categoryService", Service.class);
        final Service companyService = context.getBean("companyService", Service.class);
    }
}
