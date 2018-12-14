package ru.shcheglov.service;

import ru.shcheglov.model.AbstractEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

public interface BasicService<T extends AbstractEntity> {

    void save(T entity);

    void delete(String id);

    void delete(T entity);

    void deleteAll();

    Optional<T> get(String id);

    List<T> getAll();

    T update(T entity);

}
