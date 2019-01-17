package ru.shcheglov.spring.second.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.shcheglov.spring.second.model.Person;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PersonRepositoryBean implements PersonRepository {

    @NotNull
    private Map<String, Person> persons = new LinkedHashMap<>();

    @PostConstruct
    private void init() {
        final Person person = new Person("Иван", "Иванов", "Иванович", "ivan@ivanov.com");
        merge(person);
        System.out.println(person.getId());
        merge(new Person("Петр", "Петров", "Петрович", "petr@petrov.ru"));
    }

    @Override
    public Collection<Person> findAll() {
        return persons.values();
    }

    @Override
    public Person findOneById(@Nullable final String id) {
        if (id == null || id.isEmpty()) return null;
        return persons.get(id);
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
        if (persons.containsKey(id)) {
            persons.replace(id, persons.get(id), entity);
        }
        if (!persons.containsKey(id)) {
            persons.put(id, entity);
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
        persons.clear();
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
        if (!persons.containsKey(id)) return;
        persons.remove(id);
    }

    @Override
    public void removeByIds(@Nullable final Collection<String> ids) {
        if (ids == null || ids.isEmpty()) return;
        for (@Nullable final String id : ids) removeById(id);
    }

}
