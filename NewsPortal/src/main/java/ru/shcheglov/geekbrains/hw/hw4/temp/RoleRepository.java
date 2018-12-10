package ru.shcheglov.geekbrains.hw.hw4.temp;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.volnenko.enterprise.model.Project;

/**
 * @author Denis Volnenko
 */

@Repository(RoleRepository.NAME)
public class RoleRepository extends AbstractRepository<Project> {

    @NotNull
    public static final String NAME = "groupRepository";


}
