package ru.shcheglov.geekbrains.hw.hw4.repository;

import ru.shcheglov.geekbrains.hw.hw4.entity.Ad;
import ru.shcheglov.geekbrains.hw.hw4.entity.Category;
import ru.shcheglov.geekbrains.hw.hw4.entity.Company;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 07.12.2018
 */

public interface AdRepository extends Repository<Ad> {

    List<Ad> findAllByCompany(Company company);

    List<Ad> findAllByCategory(Category category);

}
