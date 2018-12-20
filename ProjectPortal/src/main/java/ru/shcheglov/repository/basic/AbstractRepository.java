package ru.shcheglov.repository.basic;

import org.jetbrains.annotations.NotNull;
import ru.shcheglov.model.basic.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

public abstract class AbstractRepository<Entity extends AbstractEntity> {

    @PersistenceContext
    protected EntityManager entityManager;

    public List<Entity> getEntities(@NotNull final TypedQuery<Entity> query) {
        final List<Entity> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList;
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

    public void delete(@NotNull final String id, @NotNull final Class<Entity> aClass) {
        final Optional<Entity> entity = findOne(id, aClass);
        entity.ifPresent(this::delete);
    }

    public void deleteAll(@NotNull final String queryName, @NotNull final Class<Entity> aClass) {
        entityManager
                .createNamedQuery(queryName, aClass)
                .executeUpdate();
    }

    public Optional<Entity> findOne(@NotNull final String id, @NotNull final Class<Entity> aClass) {
        return Optional.of(entityManager.find(aClass, id));
    }

    public List<Entity> findAll(@NotNull final String queryName, @NotNull final Class<Entity> aClass) {
        return entityManager
                .createNamedQuery(queryName, aClass)
                .getResultList();
    }

}
