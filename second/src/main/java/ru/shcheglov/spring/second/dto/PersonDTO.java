package ru.shcheglov.spring.second.dto;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.shcheglov.spring.second.model.Person;
import ru.shcheglov.spring.second.model.Task;

import javax.persistence.Column;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 03.02.2019
 */

@Getter
@Setter
public class PersonDTO {

    @Nullable
    private String firstName;

    @Nullable
    private String lastName;

    @Nullable
    private String middleName;

    @Nullable
    private String email;

    @Nullable
    private List<Task> tasks;

    public PersonDTO(@NotNull final Person person) {
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.middleName = person.getMiddleName();
        this.email = person.getEmail();
        this.tasks = person.getTasks();
    }
}
