package ru.shcheglov.repository.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.user.Role;
import ru.shcheglov.model.user.User;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.repository.common.AbstractRepository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 23.12.2018
 */

@Repository(UserProfileRepositoryImpl.NAME)
public class UserProfileRepositoryImpl extends AbstractRepository<UserProfile> implements UserProfileRepository {

    @NotNull
    public static final String NAME = "userProfileRepository";

    @Override
    public void deleteOne(@NotNull final String id) {
        final UserProfile up = getEntityManager().find(UserProfile.class, id);
        deleteOne(up);
    }

    @Override
    public void deleteAll() {
        getEntityManager()
                .createNamedQuery("UserProfile.deleteAll", UserProfile.class)
                .executeUpdate();
    }

    @Override
    public Optional<UserProfile> findOne(@NotNull final String id) {
        final List<UserProfile> userProfiles = getEntityManager()
                .createNamedQuery("UserProfile.findOne", UserProfile.class)
                .setParameter("userProfileId", id)
                .getResultList();
        return Optional.ofNullable(DataAccessUtils.singleResult(userProfiles));
    }

    @Override
    public List<UserProfile> findAll() {
        return getEntityManager()
                .createNamedQuery("UserProfile.findAll", UserProfile.class)
                .getResultList();
    }

    @Override
    public UserProfile findOneByUserId(@NotNull final String id) {
        return getEntityManager()
                .createNamedQuery("UserProfile.findOneByUserId", UserProfile.class)
                .setParameter("userId", id)
                .getSingleResult();
    }

    @Override
    public UserProfile findOneByUser(@NotNull final User user) {
        return findOneByUserId(user.getId());
    }

    @Override
    public UserProfile findOneByLogin(@NotNull final String login) {
        final Optional<UserProfile> optional = getEntityManager()
                .createNamedQuery("UserProfile.findByLogin", UserProfile.class)
                .setParameter("userLogin", login)
                .getResultList()
                .stream()
                .findFirst();
        return optional.orElse(null);
    }

    @Override
    public boolean isEnabled(@NotNull final String login) {
        final UserProfile up = findOneByLogin(login);
        return up.getUser().getEnabled();
    }

    @Override
    public boolean isExist(@NotNull final String login) {
        final UserProfile up = findOneByLogin(login);
        return up != null;
    }

}
