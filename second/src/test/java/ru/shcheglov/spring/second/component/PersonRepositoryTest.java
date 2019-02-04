package ru.shcheglov.spring.second.component;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.shcheglov.spring.second.model.Person;
import ru.shcheglov.spring.second.repository.PersonRepository;

import java.util.Collection;

/**
 * @author Alexey Shcheglov
 * @version dated 03.02.2019
 */

@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testWhenFindByEmailFromDbThenSuccess() {
        this.entityManager.persist(new Person("Ivan", "example@example.ru"));
        final Person person = this.personRepository.findOneByEmail("example@example.ru");
        Assert.assertEquals("example@example.ru", person.getEmail());
        Assert.assertEquals("Ivan", person.getFirstName());
    }

    @Test
    public void testWhenDeleteAllThenCountEqualsZero() {
        personRepository.removeAll();
        Assert.assertEquals(personRepository.count(), 0);
    }
}
