package ru.shcheglov.spring.second.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.shcheglov.spring.second.model.Task;

import java.util.*;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TaskRepositoryBean extends AbstractRepository<Task> implements TaskRepository {

    @Override
    public Collection<Task> findAll() {
        return getEntityManager()
                .createNamedQuery("Task.findAll", Task.class)
                .getResultList();
    }

    @Override
    public Task findOneById(@Nullable final String id) {
        if (id == null) return null;
        return getEntityManager().find(Task.class, id);
    }

    @Override
    public Collection<Task> findAllByIds(@Nullable final Collection<String> ids) {
        if (ids == null || ids.isEmpty()) return Collections.emptySet();
        @Nullable final Collection<Task> result = new LinkedList<>();
        for (@Nullable final String id : ids) {
            if (id == null || id.isEmpty()) continue;
            @Nullable final Task person = findOneById(id);
            if (person == null) continue;
            result.add(person);
        }
        return result;
    }

    @Override
    public Collection<Task> merge(@Nullable final Collection<Task> entities) {
        if (entities == null || entities.isEmpty()) return Collections.emptySet();
        @NotNull final Collection<Task> result = new LinkedList<>();
        for (@Nullable final Task entity : entities) {
            if (entity == null) continue;
            result.add(merge(entity));
        }
        return result;
    }

    @Override
    public void removeAll() {
        getEntityManager()
                .createNamedQuery("Task.removeAll", Task.class)
                .executeUpdate();
    }

    @Override
    public void remove(@Nullable final Collection<Task> entities) {
        if (entities == null || entities.isEmpty()) return;
        for (@Nullable final Task entity : entities) {
            if (entity == null) continue;
            removeById(entity.getId());
        }
    }

    @Override
    public void removeById(@Nullable final String id) {
        if (id == null || id.isEmpty()) return;
        final Task person = findOneById(id);
        removeOne(person);
    }

    @Override
    public void removeByIds(@Nullable final Collection<String> ids) {
        if (ids == null || ids.isEmpty()) return;
        for (@Nullable final String id : ids) removeById(id);
    }

}
