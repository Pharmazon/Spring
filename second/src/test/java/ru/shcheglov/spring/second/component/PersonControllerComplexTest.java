package ru.shcheglov.spring.second.component;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.shcheglov.spring.second.dto.PersonDTO;

/**
 * @author Alexey Shcheglov
 * @version dated 03.02.2019
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerComplexTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test() {
        final ResponseEntity<PersonDTO> entity = restTemplate
                .getForEntity("/api/person-service/person?email=example@example.ru", PersonDTO.class);
        Assert.assertSame(entity.getStatusCode(), HttpStatus.OK);
        final PersonDTO personDTO = entity.getBody();
        Assert.assertNotNull(personDTO);
        Assert.assertNotNull(personDTO.getEmail());
    }
}
