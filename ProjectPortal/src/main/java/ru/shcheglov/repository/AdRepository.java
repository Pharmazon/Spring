package ru.shcheglov.repository;

import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Category;
import ru.shcheglov.model.Company;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

public interface AdRepository extends BasicRepository<Ad> {

    List<Ad> findAllByCompany(Company model);

    List<Ad> findAllByCategory(Category model);

}
