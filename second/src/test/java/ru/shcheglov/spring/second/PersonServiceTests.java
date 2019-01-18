package ru.shcheglov.spring.second;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.shcheglov.spring.second.model.Person;
import ru.shcheglov.spring.second.service.PersonService;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTests {

    @Autowired
    private PersonService personService;

    private static Person actualPerson;

    @BeforeClass
    public static void initClass() {
        actualPerson = new Person("Nikola", "Tesla", "Vasevich", "nikola@tesla.com");
    }

    @Before
    public void initTest() {
        personService.merge(actualPerson);
    }

    @After
    public void deinitTest() {
        personService.removeOne(actualPerson);
    }

    @Test
    public void whenCreatePersonThenNotNull() {
        Assert.assertNotNull(actualPerson);
    }

    @Test
    public void whenReadPersonThenExists() {
        final String actualId = actualPerson.getId();
        final Person expectedPerson = personService.findOneById(actualId);
        expectedPerson.setTasks(null);
        boolean equals = expectedPerson.equals(actualPerson);
        Assert.assertEquals(actualPerson, expectedPerson);
    }

    @Test
    public void whenUpdatePersonThenEquals() {
        final String actualId = actualPerson.getId();
        final Person expectedPerson = personService.findOneById(actualId);
        expectedPerson.setFirstName("Alexey");
        personService.merge(expectedPerson);
        final Person updatedPerson = personService.findOneById(actualId);
        Assert.assertEquals(updatedPerson, actualPerson);
    }

    @Test
    public void whenDeletePersonThenNull() {
        final String actualId = actualPerson.getId();
        personService.removeOne(actualPerson);
        final Person expectedPerson = personService.findOneById(actualId);
        Assert.assertNull(expectedPerson);
    }

}
