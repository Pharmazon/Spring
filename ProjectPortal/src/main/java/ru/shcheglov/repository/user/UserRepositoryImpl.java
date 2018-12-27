package ru.shcheglov.repository.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.model.user.User;
import ru.shcheglov.repository.common.AbstractRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

@Repository(UserRepositoryImpl.NAME)
public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {

    @NotNull
    public static final String NAME = "userRepository";

    @Override
    public void deleteOne(@NotNull final String id) {
        final Optional<User> entity = findOne(id);
        entity.ifPresent(this::deleteOne);
    }

    @Override
    public void deleteAll() {
        getEntityManager()
                .createNamedQuery("User.deleteAll", User.class)
                .executeUpdate();
    }

    @Override
    public Optional<User> findOne(@NotNull final String id) {
        return Optional.of(getEntityManager().find(User.class, id));
    }

    @Override
    public List<User> findAll() {
        return getEntityManager()
                .createNamedQuery("User.findAll", User.class)
                .getResultList();
    }

    @Override
    public Long countByLogin(@NotNull final String login) {
        return getEntityManager()
                .createQuery("SELECT COUNT (u) FROM User u WHERE u.login = :userLogin", Long.class)
                .setParameter("userLogin", login)
                .getSingleResult();
    }

    @Override
    public boolean isExist(String login) {
        final User user = findOneByLogin(login);
        return user != null;
    }

    @Override
    public User findOneByLogin(String login) {
        List<User> users = getEntityManager()
                .createNamedQuery("User.findByLogin", User.class)
                .setParameter("userLogin", login)
                .getResultList();
        return DataAccessUtils.singleResult(users);
    }

}
