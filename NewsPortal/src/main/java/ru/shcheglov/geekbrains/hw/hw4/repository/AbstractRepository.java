package ru.shcheglov.geekbrains.hw.hw4.repository;

import org.jetbrains.annotations.NotNull;
import ru.shcheglov.geekbrains.hw.hw4.entity.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 07.12.2018
 */

public abstract class AbstractRepository<T extends AbstractEntity> {

    @PersistenceContext
    protected EntityManager entityManager;

    public T getEntity(@NotNull final TypedQuery<T> query) {
        final List<T> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    public void save(@NotNull final T entity) {
        entityManager.persist(entity);
    }

    public T update(@NotNull final T entity) {
        return entityManager.merge(entity);
    }

    public void delete(@NotNull final T entity) {
        entityManager.remove(entity);
    }
}
