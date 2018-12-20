package ru.shcheglov.repository.basic;

import org.jetbrains.annotations.NotNull;
import ru.shcheglov.model.basic.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

public abstract class AbstractRepository<Entity extends AbstractEntity> {

    @PersistenceContext
    protected EntityManager entityManager;

    public Entity getEntity(@NotNull final TypedQuery<Entity> query) {
        final List<Entity> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    public void save(@NotNull final Entity model) {
        entityManager.persist(model);
    }

    public Entity update(@NotNull final Entity model) {
        return entityManager.merge(model);
    }

    public void delete(@NotNull final Entity model) {
        entityManager.remove(model);
    }

}
