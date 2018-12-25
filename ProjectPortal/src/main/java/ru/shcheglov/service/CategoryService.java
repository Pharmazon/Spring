package ru.shcheglov.service;

import ru.shcheglov.model.common.AbstractEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 25.12.2018
 */

public interface CategoryService<T extends AbstractEntity> {

    void saveOne(T entity);

    void saveAll(List<T> list);

    void deleteOne(String id);

    void deleteOne(T entity);

    void deleteAll();

    Optional<T> getOne(String id);

    List<T> getAll();

    T updateOne(T entity);

    Optional<T> getOneParent(String id);

}
