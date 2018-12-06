package ru.shcheglov.geekbrains.hw.hw3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.shcheglov.geekbrains.hw.hw3.config.ApplicationConfiguration;
import ru.shcheglov.geekbrains.hw.hw3.dao.DAO;
import ru.shcheglov.geekbrains.hw.hw3.entity.Ad;
import ru.shcheglov.geekbrains.hw.hw3.entity.Category;
import ru.shcheglov.geekbrains.hw.hw3.entity.Company;

/**
 * @author Alexey Shcheglov
 * @version dated 06.12.2018
 */

public class Main {

    public static void main(String[] args) {

        final ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        final DAO companyDAO = context.getBean("companyDAO", DAO.class);
        final DAO categoryDAO = context.getBean("categoryDAO", DAO.class);
        final DAO adDAO = context.getBean("adDAO", DAO.class);

//        for (int i = 0; i < 10; i++) {
//            final Company company = new Company();
//            company.setAddress("Address-" + i);
//            company.setName("Name-" + i);
//            company.setDescription("Description-" + i);
//            companyDAO.create(company);
//
//            final Category category = new Category();
//            category.setName("Category-" + i);
//            categoryDAO.create(category);
//
//            final Ad ad = new Ad();
//            ad.setCompany(company);
//            ad.setCategory(category);
//            ad.setContent("Content-" + i);
//            ad.setName("Name-" + i);
//            ad.setNumber("32" + i + "23" + i + "76" + i);
//            adDAO.create(ad);
//        }
        System.out.println("Company=" + companyDAO.read("ded3a6c3-7026-45f4-871a-894ee16da5c4"));
        System.out.println("Category=" + categoryDAO.read("39d6cf8b-fa9b-4500-8eb5-2e27ac956e3c"));
        System.out.println("Ad=" + adDAO.read("5ca6edfd-d5c9-4d57-ba36-c2b9a475b520"));
    }
}
