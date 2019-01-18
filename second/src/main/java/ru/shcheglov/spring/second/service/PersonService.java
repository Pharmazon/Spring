package ru.shcheglov.spring.second.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.shcheglov.spring.second.model.Person;

/**
 * @author Alexey Shcheglov
 * @version dated 18.01.2019
 */

public interface PersonService extends CommonService<Person> {

    void initPerson(@Nullable String firstName, @Nullable String lastName, @Nullable String middleName,
                    @NotNull String email);

    Person findOneByEmail(@NotNull String email);

    boolean isPersonExists(@NotNull String email);

}
