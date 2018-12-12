package ru.shcheglov.geekbrains.hw.hw5.repository;

import ru.shcheglov.geekbrains.hw.hw5.model.Ad;
import ru.shcheglov.geekbrains.hw.hw5.model.Category;
import ru.shcheglov.geekbrains.hw.hw5.model.Company;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 07.12.2018
 */

public interface AdRepository extends Repository<Ad> {

    List<Ad> findAllByCompany(Company company);

    List<Ad> findAllByCategory(Category category);

}
