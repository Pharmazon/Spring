package ru.shcheglov.spring.second.endpoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.shcheglov.spring.second.model.Person;
import ru.shcheglov.spring.second.service.PersonService;

import java.util.Collection;

/**
 * @author Alexey Shcheglov
 * @version dated 23.01.2019
 */

@Endpoint
public class PersonEndpoint {

    @NotNull
    private static final Logger LOGGER = LogManager.getLogger(PersonEndpoint.class);

    @NotNull
    public static final String LOCATION_URI = "/soap/persons";

    @NotNull
    public static final String PORT_TYPE_NAME = "PersonEndpointPort";

    @NotNull
    public static final String NAMESPACE = "http://localhost:8080/soap/persons";

    @Autowired
    private PersonService personService;

    @ResponsePayload
    @PayloadRoot(localPart = "createPersonByEmailRequest", namespace = NAMESPACE)
    public Person createPersonByEmail(
            @RequestPayload final String email
    ) {
        final Person person = new Person();
        person.setEmail(email);
        return person;
    }

    @ResponsePayload
    @PayloadRoot(localPart = "createEmptyPersonRequest", namespace = NAMESPACE)
    public Person createEmptyPerson() {
        return new Person();
    }

    @ResponsePayload
    @PayloadRoot(localPart = "createFullPersonRequest", namespace = NAMESPACE)
    public Person createFullPerson(
            @RequestPayload final String firstName,
            @RequestPayload final String lastName,
            @RequestPayload final String middleName,
            @RequestPayload final String email
    ) {
        final Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMiddleName(middleName);
        person.setEmail(email);
        return person;
    }

    @ResponsePayload
    @PayloadRoot(localPart = "getAllPersonsRequest", namespace = NAMESPACE)
    public Collection<Person> getAllPersons() {
        return personService.findAll();
    }

    @ResponsePayload
    @PayloadRoot(localPart = "getPersonByIdRequest", namespace = NAMESPACE)
    public Person getPersonById(
            @RequestPayload final String personId
    ) {
        return personService.findOneById(personId);
    }

    @ResponsePayload
    @PayloadRoot(localPart = "getPersonByEmailRequest", namespace = NAMESPACE)
    public Person getPersonByEmail(
            @RequestPayload final String personEmail
    ) {
        return personService.findOneByEmail(personEmail);
    }

    @ResponsePayload
    @PayloadRoot(localPart = "isPersonExistsRequest", namespace = NAMESPACE)
    public boolean isPersonExists(
            @RequestPayload final String personEmail
    ) {
        return personService.isPersonExists(personEmail);
    }


    @ResponsePayload
    @PayloadRoot(localPart = "removeAllPersonsRequest", namespace = NAMESPACE)
    public void removeAllPersons() {
        personService.removeAll();
    }

    @ResponsePayload
    @PayloadRoot(localPart = "removePersonByIdRequest", namespace = NAMESPACE)
    public Person removePersonById(
            @RequestPayload final String personId
    ) {
        final Person person = personService.findOneById(personId);
        personService.removeOne(person);
        return person;
    }

//    @NotNull
//    private PersonRecord toRecord(@NotNull final Person person) {
//        final PersonRecord record = new PersonRecord();
//        record.setId(person.getId());
//        record.setFirstName(person.getFirstName());
//        record.setLastName(person.getLastName());
//        record.setEmail(person.getEmail());
//        record.setMiddleName(person.getMiddleName());
//        return record;
//    }

}
