package ru.shcheglov.repository;

import ru.shcheglov.model.AbstractEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

public interface BasicRepository<T extends AbstractEntity> {

    void save(T entity);

    void delete(String id);

    void delete(T entity);

    void deleteAll();

    Optional<T> findOne(String id);

    List<T> findAll();

    T update(T entity);

}
