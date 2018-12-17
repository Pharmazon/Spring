package ru.shcheglov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.shcheglov.config.ApplicationConfiguration;
import ru.shcheglov.model.Ad;
import ru.shcheglov.service.AdService;
import ru.shcheglov.service.CategoryService;
import ru.shcheglov.service.CompanyService;

import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 16.12.2018
 */

public class Main {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        final AdService adService = context.getBean("adService", AdService.class);
        final CategoryService categoryService = context.getBean("categoryService", CategoryService.class);
        final CompanyService companyService = context.getBean("companyService", CompanyService.class);

        Optional<Ad> ad = adService.get("303d56ae-57ef-4147-8ffc-10b8054dd72e");
        System.out.println(ad.get());
    }
}