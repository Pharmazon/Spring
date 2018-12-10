package ru.shcheglov.geekbrains.hw.hw4.repository;

import ru.shcheglov.geekbrains.hw.hw4.entity.AbstractEntity;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 10.12.2018
 */

public interface Repository<T extends AbstractEntity> {

    void save(T entity);

    void delete(String id);

    void delete(T entity);

    void deleteAll();

    T findOne(String id);

    List<T> findAll();

    T update(T entity);

}
