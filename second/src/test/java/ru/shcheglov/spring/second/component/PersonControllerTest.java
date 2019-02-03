package ru.shcheglov.spring.second.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.shcheglov.spring.second.controller.PersonController;
import ru.shcheglov.spring.second.model.Person;
import ru.shcheglov.spring.second.service.PersonService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Alexey Shcheglov
 * @version dated 03.02.2019
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonService personService;

    @Test
    public void test() throws Exception {
        given(this.personService
                .findOneByEmail("example@example.ru"))
                .willReturn(new Person("Ivan", "example@example.ru"));

        this.mvc.perform(get("/person?email={email}", "example@example.ru")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
