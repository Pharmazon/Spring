package ru.shcheglov.service;

import ru.shcheglov.dto.CategoryDTO;
import ru.shcheglov.model.Category;
import ru.shcheglov.model.common.AbstractEntity;
import ru.shcheglov.service.common.CommonService;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 25.12.2018
 */

public interface CategoryService extends CommonService<Category, CategoryDTO> {

    Optional<Category> getOneParent(String id);

}
