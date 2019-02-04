package ru.shcheglov.spring.second.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import ru.shcheglov.spring.second.model.Person;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PersonRepositoryBean extends AbstractRepository<Person> implements PersonRepository {

    @Override
    public Collection<Person> findAll() {
        return getEntityManager()
                .createNamedQuery("Person.findAll", Person.class)
                .getResultList();
    }

    @Override
    public Person findOneById(@Nullable final String id) {
        if (id == null) return null;
        final List<Person> persons = getEntityManager()
                .createNamedQuery("Person.findOne", Person.class)
                .setParameter("personId", id)
                .getResultList();
        return DataAccessUtils.singleResult(persons);
    }

    @Override
    public Collection<Person> findAllByIds(@Nullable final Collection<String> ids) {
        if (ids == null || ids.isEmpty()) return Collections.emptySet();
        @Nullable final Collection<Person> result = new LinkedList<>();
        for (@Nullable final String id : ids) {
            if (id == null || id.isEmpty()) continue;
            @Nullable final Person person = findOneById(id);
            if (person == null) continue;
            result.add(person);
        }
        return result;
    }

    @Override
    public Collection<Person> merge(@Nullable final Collection<Person> entities) {
        if (entities == null || entities.isEmpty()) return Collections.emptySet();
        @NotNull final Collection<Person> result = new LinkedList<>();
        for (@Nullable final Person entity : entities) {
            if (entity == null) continue;
            result.add(merge(entity));
        }
        return result;
    }

    @Override
    public void removeAll() {
        getEntityManager()
                .createNamedQuery("Person.removeAll", Person.class)
                .executeUpdate();
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
        final Person person = findOneById(id);
        if (person == null) return;
        removeOne(person);
    }

    @Override
    public void removeByIds(@Nullable final Collection<String> ids) {
        if (ids == null || ids.isEmpty()) return;
        for (@Nullable final String id : ids) {
            if (id == null || id.isEmpty()) continue;
            removeById(id);
        }
    }

    @Override
    public long count() {
        return getEntityManager()
                .createQuery("SELECT COUNT(p) FROM Person p GROUP BY p.id")
                .getFirstResult();
    }

    @Override
    public Person findOneByEmail(@NotNull String email) {
        final List<Person> persons = getEntityManager()
                .createNamedQuery("Person.findOneByEmail", Person.class)
                .setParameter("personEmail", email)
                .getResultList();
        return DataAccessUtils.singleResult(persons);
    }

}
