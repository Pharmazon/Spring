package ru.shcheglov.spring.second;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.shcheglov.spring.second.model.Person;
import ru.shcheglov.spring.second.repository.PersonRepository;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTests {

    @Autowired
    private PersonRepository personRepository;

    private Person actualPerson;

    @Before
    public void init() {
        this.actualPerson = new Person("Сидр", "Иванов", "Иванович", "ivan@ivanov.com");
    }

    @Test
    public void whenCreateReadPersonThenExists() {
        personRepository.merge(actualPerson);
        final Person expectedPerson = personRepository.findOneById(actualPerson.getId());
        Assert.assertEquals(expectedPerson, actualPerson);
    }

    @Test
    public void whenUpdatePersonThenEquals() {
        final String actualId = actualPerson.getId();
        personRepository.merge(actualPerson);
        final Person expectedPerson = personRepository.findOneById(actualId);
        expectedPerson.setFirstName("Alexey");
        personRepository.merge(expectedPerson);
        final Person updatedPerson = personRepository.findOneById(actualId);
        Assert.assertEquals(updatedPerson, actualPerson);
    }

    @Test
    public void whenDeletePersonThenNull() {
        final String actualId = actualPerson.getId();
        personRepository.removeById(actualId);
        final Person expectedPerson = personRepository.findOneById(actualId);
        Assert.assertNull(expectedPerson);
    }

    @After
    public void deinit() {
        this.actualPerson = null;
    }

}
