package ru.shcheglov.repository.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.user.Role;
import ru.shcheglov.model.user.User;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.repository.common.AbstractRepository;

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
        return Optional.of(getEntityManager()
                .createNamedQuery("UserProfile.findOne", UserProfile.class)
                .setParameter("userId", id)
                .getSingleResult());
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
    public UserProfile findOneByUser(User user) {
        return findOneByUserId(user.getId());
    }
}
