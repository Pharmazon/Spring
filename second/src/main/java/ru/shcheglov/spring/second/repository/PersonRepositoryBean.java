package ru.shcheglov.spring.second.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.shcheglov.spring.second.model.Person;

import javax.annotation.PostConstruct;
import java.util.*;

public class PersonRepositoryBean implements PersonRepository {

    @NotNull
    private Map<String, Person> products = new LinkedHashMap<>();

    @PostConstruct
    private void init() {
        merge(new Person("Иванов", "Иван", "Иванович", "ivan@ivanov.com"));
        merge(new Person("Петров", "Петр", "Петрович", "petr@petrov.ru"));
    }

    @Override
    public Collection<Person> findAll() {
        return products.values();
    }

    @Override
    public Person findOneById(@Nullable final String id) {
        if (id == null || id.isEmpty()) return null;
        return products.get(id);
    }

    @Override
    public Collection<Person> findAllByIds(@Nullable final Collection<String> ids) {
        if (ids == null || ids.isEmpty()) return Collections.emptySet();
        @Nullable final Collection<Person> result = new LinkedHashSet<>();
        for (@Nullable final String id : ids) {
            if (id == null || id.isEmpty()) continue;
            @Nullable final Person product = findOneById(id);
            if (product == null) continue;
            result.add(product);
        }
        return result;
    }

    @Override
    public Person merge(@Nullable final Person entity) {
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
    public Collection<Person> merge(@Nullable final Collection<Person> entities) {
        if (entities == null || entities.isEmpty()) return Collections.emptySet();
        @NotNull final Collection<Person> result = new LinkedHashSet<>();
        for (@Nullable final Person entity : entities) {
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
    public void remove(@Nullable final Collection<Person> entities) {
        if (entities == null || entities.isEmpty()) return;
        for (@Nullable final Person entity : entities) {
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
