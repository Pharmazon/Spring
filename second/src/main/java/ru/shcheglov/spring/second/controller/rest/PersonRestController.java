package ru.shcheglov.spring.second.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shcheglov.spring.second.dto.PersonDTO;
import ru.shcheglov.spring.second.dto.ResultDTO;
import ru.shcheglov.spring.second.model.Person;
import ru.shcheglov.spring.second.service.PersonService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Alexey Shcheglov
 * @version dated 03.02.2019
 */

@RestController
@RequestMapping("/api/person-service")
public class PersonRestController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/ping",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResultDTO ping() {
        return new ResultDTO();
    }

    @RequestMapping(value = "/persons",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public List<PersonDTO> getPersonsList() {
        try {
            final Collection<Person> persons = personService.findAll();
            return persons.stream()
                    .map(PersonDTO::new)
                    .collect(Collectors.toList());
        } catch (final Exception e) {
            return Collections.emptyList();
        }
    }

    @RequestMapping(value = "/person/{email}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public PersonDTO getPerson(@PathVariable("email") final String email) {
        final Person person = personService.findOneByEmail(email);
        return new PersonDTO(person);
    }

}
