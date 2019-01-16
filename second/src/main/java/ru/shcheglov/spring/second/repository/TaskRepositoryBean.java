package ru.shcheglov.spring.second.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.shcheglov.spring.second.model.Person;
import ru.shcheglov.spring.second.model.Task;

import java.util.*;

public class TaskRepositoryBean implements TaskRepository {

    @NotNull
    private Map<String, Task> products = new LinkedHashMap<>();

    @Override
    public Collection<Task> findAll() {
        return products.values();
    }

    @Override
    public Task findOneById(@Nullable final String id) {
        if (id == null || id.isEmpty()) return null;
        return products.get(id);
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
        if (products.containsKey(id)) {
            products.replace(id, products.get(id), entity);
        }
        if (!products.containsKey(id)) {
            products.put(id, entity);
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
        products.clear();
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
        if (!products.containsKey(id)) return;
        products.remove(id);
    }

    @Override
    public void removeByIds(@Nullable final Collection<String> ids) {
        if (ids == null || ids.isEmpty()) return;
        for (@Nullable final String id : ids) removeById(id);
    }

}
