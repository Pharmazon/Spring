package ru.shcheglov.repository.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.user.Role;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.repository.common.AbstractRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

@Repository(RoleRepositoryImpl.NAME)
public class RoleRepositoryImpl extends AbstractRepository<Role> implements RoleRepository {

    @NotNull
    public static final String NAME = "roleRepository";

    @Override
    public void deleteOne(@NotNull final String id) {
        final Optional<Role> entity = findOne(id);
        entity.ifPresent(this::deleteOne);
    }

    @Override
    public void deleteAll() {
        getEntityManager()
                .createNamedQuery("Role.deleteAll", Role.class)
                .executeUpdate();
    }

    @Override
    public Optional<Role> findOne(@NotNull final String id) {
        return Optional.of(getEntityManager().find(Role.class, id));
    }

    @Override
    public List<Role> findAll() {
        return getEntityManager()
                .createNamedQuery("Role.findAll", Role.class)
                .getResultList();
    }

    @Override
    public Optional<Role> findRole(@NotNull final String role) {
        return Optional.of(getEntityManager()
                .createNamedQuery("Role.getUserRole", Role.class)
                .setParameter("roleName", role)
                .getSingleResult());
    }
}
