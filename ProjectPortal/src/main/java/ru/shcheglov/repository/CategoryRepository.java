package ru.shcheglov.repository;

import ru.shcheglov.model.Category;
import ru.shcheglov.repository.common.CommonRepository;

import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

public interface CategoryRepository extends CommonRepository<Category> {

    Optional<Category> findOneParent(String id);

}
