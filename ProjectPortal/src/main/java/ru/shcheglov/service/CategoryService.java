package ru.shcheglov.service;

import ru.shcheglov.dto.CategoryDTO;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Category;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

public interface CategoryService extends BasicService<Category, CategoryDTO> {

    List<Ad> getAllAds(Category category);

}
