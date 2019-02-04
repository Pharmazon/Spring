package ru.shcheglov.spring.second.layer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.shcheglov.spring.second.model.Person;

/**
 * @author Alexey Shcheglov
 * @version dated 03.02.2019
 */

@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonPersistenceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void test() {
        deleteAllFromPerson();
        Assert.assertEquals(getCountPersons(), 0);

        entityManager.persist(new Person());
        Assert.assertEquals(getCountPersons(), 1L);

        deleteAllFromPerson();
        Assert.assertEquals(getCountPersons(), 0);
    }

    private long getCountPersons() {
        return entityManager
                .getEntityManager()
                .createQuery("SELECT COUNT(p) FROM Person p GROUP BY p.id")
                .getFirstResult();
    }

    private void deleteAllFromPerson() {
        entityManager
                .getEntityManager()
                .createQuery("DELETE FROM Person")
                .executeUpdate();
    }
}
