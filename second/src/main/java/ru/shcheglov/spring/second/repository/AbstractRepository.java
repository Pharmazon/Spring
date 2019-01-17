package ru.shcheglov.spring.second.repository;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;
import ru.shcheglov.spring.second.model.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * @author Alexey Shcheglov
 * @version dated 18.01.2019
 */

public abstract class AbstractRepository<T extends AbstractEntity> {

    @Getter
    @PersistenceContext
    private EntityManager entityManager;

    public void saveOne(@Nullable final T entity) {
        if (entity == null) return;
        entityManager.persist(entity);
    }

    public void saveAll(@Nullable final Collection<T> entities) {
        if (entities == null || entities.isEmpty()) return;
        for (T entity : entities) entityManager.persist(entity);
    }

    public T merge(@Nullable final T entity) {
        if (entity == null) return null;
        return entityManager.merge(entity);
    }

    public void removeOne(@Nullable final T entity) {
        if (entity == null) return;
        entityManager.remove(entity);
    }

}
