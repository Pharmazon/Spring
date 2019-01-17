package ru.shcheglov.spring.second;

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
public class SecondApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	private Person actualPerson;

	@Before
	public void init() {
		this.actualPerson = new Person("Сидр", "Иванов", "Иванович", "ivan@ivanov.com");
		personRepository.merge(actualPerson);
	}

	@Test
	public void whenUpdatePersonThenEquals() {
		final String addedId = actualPerson.getId();
		final Person expectedPerson = personRepository.findOneById(addedId);
		expectedPerson.setFirstName("Alexey");
		personRepository.merge(expectedPerson);
		Assert.assertEquals(expectedPerson, actualPerson);
	}

	@Test
	public void contextLoads() {
	}

}

