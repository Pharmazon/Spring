package ru.shcheglov.spring.second.repository;

import org.jetbrains.annotations.NotNull;
import ru.shcheglov.spring.second.model.Person;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

public interface PersonRepository extends CommonRepository<Person> {

    Person findOneByEmail(@NotNull String email);

}
