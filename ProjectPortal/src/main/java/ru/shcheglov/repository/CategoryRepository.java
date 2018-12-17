package ru.shcheglov.repository;

import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Category;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

public interface CategoryRepository extends BasicRepository<Category> {

    List<Ad> findAllAds(Category model);

}
