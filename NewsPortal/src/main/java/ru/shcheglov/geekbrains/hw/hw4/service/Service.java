package ru.shcheglov.geekbrains.hw.hw4.service;

import ru.shcheglov.geekbrains.hw.hw4.entity.AbstractEntity;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 10.12.2018
 */

public interface Service<T extends AbstractEntity> {

    void save(T entity);

    void delete(String id);

    void delete(T entity);

    void deleteAll();

    T get(String id);

    List<T> getAll();

    T update(T entity);
    
}
