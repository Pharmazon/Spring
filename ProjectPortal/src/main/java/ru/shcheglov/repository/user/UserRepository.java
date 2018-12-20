package ru.shcheglov.repository.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.user.User;
import ru.shcheglov.repository.basic.AbstractRepository;
import ru.shcheglov.repository.basic.BasicRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(UserRepository.NAME)
public class UserRepository extends AbstractRepository<User> implements BasicRepository<User> {

    @NotNull
    public static final String NAME = "userRepository";

    @Override
    public void delete(@NotNull final String id) {
        final Optional<User> user = findOne(id);
        user.ifPresent(this::delete);
    }

    @Override
    public void deleteAll() {
        entityManager
                .createNamedQuery("User.deleteAll", User.class)
                .executeUpdate();
    }

    @Override
    public Optional<User> findOne(@NotNull final String id) {
        return Optional.of(entityManager.find(User.class, id));
    }

    @Override
    public List<User> findAll() {
        return entityManager
                .createNamedQuery("User.findAll", User.class)
                .getResultList();
    }

}
