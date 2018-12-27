package ru.shcheglov.repository.common;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.shcheglov.model.common.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

public abstract class AbstractRepository<T extends AbstractEntity> implements CommonRepository<T> {

    @PersistenceContext
    @Getter
    private EntityManager entityManager;

    public List<T> getEntities(@NotNull final TypedQuery<T> query) {
        final List<T> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList;
    }

    public void saveOne(@NotNull final T model) {
        entityManager.persist(model);
    }

    public void saveAll(@NotNull final List<T> list) {
        for (T t : list) entityManager.persist(t);
    }

    public T updateOne(@NotNull final T model) {
        return entityManager.merge(model);
    }

    public void deleteOne(@NotNull final T model) {
        entityManager.remove(model);
    }

}
