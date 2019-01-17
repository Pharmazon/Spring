package ru.shcheglov.spring.second.service;

import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shcheglov.spring.second.model.Person;
import ru.shcheglov.spring.second.repository.PersonRepository;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * @author Alexey Shcheglov
 * @version dated 18.01.2019
 */

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void saveOne(@Nullable Person entity) {
        personRepository.saveOne(entity);
    }

    @Override
    public void saveAll(@Nullable Collection<Person> entities) {
        personRepository.saveAll(entities);
    }

    @Override
    public Collection<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findOneById(@Nullable String id) {
        return personRepository.findOneById(id);
    }

    @Override
    public Collection<Person> findAllByIds(@Nullable Collection<String> ids) {
        return personRepository.findAllByIds(ids);
    }

    @Override
    public Person merge(@Nullable Person entity) {
        return personRepository.merge(entity);
    }

    @Override
    public Collection<Person> merge(@Nullable Collection<Person> entities) {
        return personRepository.merge(entities);
    }

    @Override
    public void removeAll() {
        personRepository.removeAll();
    }

    @Override
    public void remove(@Nullable Collection<Person> entities) {
        personRepository.remove(entities);
    }

    @Override
    public void removeById(@Nullable String id) {
        personRepository.removeById(id);
    }

    @Override
    public void removeByIds(@Nullable Collection<String> ids) {
        personRepository.removeByIds(ids);
    }

    @Override
    public void removeOne(@Nullable Person entity) {
        personRepository.removeOne(entity);
    }

    @Override
    public void initPerson(@Nullable String firstName, @Nullable String lastName, @Nullable String middleName, @Nullable String email) {
        final Person person = new Person(firstName, lastName, middleName, email);
        personRepository.merge(person);
    }
}
