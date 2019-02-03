package ru.shcheglov.spring.second.layer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.shcheglov.spring.second.model.Person;

import java.io.IOException;

/**
 * @author Alexey Shcheglov
 * @version dated 03.02.2019
 */

@JsonTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ExternalizationTest {

    @Autowired(required = false)
    private JacksonTester<Person> json;

    @Test
    public void toJsonTest() throws IOException {
        final Person person = new Person("Ivan", "example@example.ru");
        Assert.assertThat(json.write(person))
                .extractingJsonPathStringValue("@.firstName")
                .isEqualTo("Ivan");
    }
}
