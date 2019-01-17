package ru.shcheglov.spring.second.service;

import org.jetbrains.annotations.Nullable;
import ru.shcheglov.spring.second.model.AbstractEntity;

import java.util.Collection;

/**
 * @author Alexey Shcheglov
 * @version dated 18.01.2019
 */

public interface CommonService<T extends AbstractEntity> {

    void saveOne(@Nullable T entity);

    void saveAll(@Nullable Collection<T> entities);

    Collection<T> findAll();

    T findOneById(@Nullable String id);

    Collection<T> findAllByIds(@Nullable Collection<String> ids);

    T merge(@Nullable T entity);

    Collection<T> merge(@Nullable Collection<T> entities);

    void removeAll();

    void remove(@Nullable Collection<T> entities);

    void removeById(@Nullable String id);

    void removeByIds(@Nullable Collection<String> ids);

    void removeOne(@Nullable T entity);

}
