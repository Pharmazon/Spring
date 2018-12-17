package ru.shcheglov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.shcheglov.config.ApplicationConfiguration;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Category;
import ru.shcheglov.model.Company;
import ru.shcheglov.repository.CategoryRepository;
import ru.shcheglov.repository.CompanyRepository;
import ru.shcheglov.service.AdService;
import ru.shcheglov.service.CategoryService;
import ru.shcheglov.service.CompanyService;

import java.util.List;
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

        final CompanyRepository companyRepository = context.getBean("companyRepository", CompanyRepository.class);
        final CategoryRepository categoryRepository = context.getBean("categoryRepository", CategoryRepository.class);

        Company company = companyService.get("92d890ff-4031-4457-86f0-1630b537d6f6").get();
        Category category = categoryService.get("76801e71-95ff-4ac3-836a-3f3291bff254").get();

        List all = categoryRepository.findAllAds(category);
        List ads = companyRepository.findAllAds(company);
        all.forEach(System.out::println);
        System.out.println("-----------------------------");
        ads.forEach(System.out::println);

    }
}