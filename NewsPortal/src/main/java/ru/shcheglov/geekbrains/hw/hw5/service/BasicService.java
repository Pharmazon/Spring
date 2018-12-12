package ru.shcheglov.geekbrains.hw.hw5.service;

import ru.shcheglov.geekbrains.hw.hw5.model.AbstractEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 10.12.2018
 */

public interface Service<T extends AbstractEntity> {

    void save(T entity);

    void delete(String id);

    void delete(T entity);

    void deleteAll();

    Optional<T> get(String id);

    List<T> getAll();

    T update(T entity);
    
}
