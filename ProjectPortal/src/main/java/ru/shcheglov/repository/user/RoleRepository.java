package ru.shcheglov.repository.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.user.Role;
import ru.shcheglov.repository.basic.AbstractRepository;
import ru.shcheglov.repository.basic.BasicRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

@Repository(RoleRepository.NAME)
public class RoleRepository extends AbstractRepository<Role> implements BasicRepository<Role> {

    @NotNull
    public static final String NAME = "roleRepository";

    @Override
    public void delete(String id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<Role> findOne(String id) {
        return Optional.empty();
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

}
