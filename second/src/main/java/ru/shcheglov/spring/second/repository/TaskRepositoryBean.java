package ru.shcheglov.spring.second.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.shcheglov.spring.second.model.Task;

import java.util.*;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TaskRepositoryBean implements TaskRepository {

    @NotNull
    private Map<String, Task> tasks = new LinkedHashMap<>();

    @Override
    public Collection<Task> findAll() {
        return tasks.values();
    }

    @Override
    public Task findOneById(@Nullable final String id) {
        if (id == null || id.isEmpty()) return null;
        return tasks.get(id);
    }

    @Override
    public Collection<Task> findAllByIds(@Nullable final Collection<String> ids) {
        if (ids == null || ids.isEmpty()) return Collections.emptySet();
        @Nullable final Collection<Task> result = new LinkedHashSet<>();
        for (@Nullable final String id : ids) {
            if (id == null || id.isEmpty()) continue;
            @Nullable final Task product = findOneById(id);
            if (product == null) continue;
            result.add(product);
        }
        return result;
    }

    @Override
    public Task merge(@Nullable final Task entity) {
        if (entity == null) return null;
        @Nullable final String id = entity.getId();
        if (id == null || id.isEmpty()) return null;
        if (tasks.containsKey(id)) {
            tasks.replace(id, tasks.get(id), entity);
        }
        if (!tasks.containsKey(id)) {
            tasks.put(id, entity);
        }
        return entity;
    }

    @Override
    public Collection<Task> merge(@Nullable final Collection<Task> entities) {
        if (entities == null || entities.isEmpty()) return Collections.emptySet();
        @NotNull final Collection<Task> result = new LinkedHashSet<>();
        for (@Nullable final Task entity : entities) {
            if (entity == null) continue;
            result.add(merge(entity));
        }
        return result;
    }

    @Override
    public void removeAll() {
        tasks.clear();
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
        if (!tasks.containsKey(id)) return;
        tasks.remove(id);
    }

    @Override
    public void removeByIds(@Nullable final Collection<String> ids) {
        if (ids == null || ids.isEmpty()) return;
        for (@Nullable final String id : ids) removeById(id);
    }

}
