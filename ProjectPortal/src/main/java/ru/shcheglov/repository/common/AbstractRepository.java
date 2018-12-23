package ru.shcheglov.repository.basic;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.NoRepositoryBean;
import ru.shcheglov.model.basic.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

@NoRepositoryBean
public abstract class AbstractRepository<T extends AbstractEntity> implements CommonRepository<T> {

    @PersistenceContext
    @Getter
    private EntityManager entityManager;

    public List<T> getEntities(@NotNull final TypedQuery<T> query) {
        final List<T> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList;
    }

    public T getEntity(@NotNull final TypedQuery<T> query) {
        return query.getSingleResult();
    }

    public void saveOne(@NotNull final T model) {
        entityManager.persist(model);
    }

    public T updateOne(@NotNull final T model) {
        return entityManager.merge(model);
    }

    public void deleteOne(@NotNull final T model) {
        entityManager.remove(model);
    }

}
