package ru.shcheglov.repository.user;

import ru.shcheglov.model.user.User;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.repository.common.CommonRepository;

/**
 * @author Alexey Shcheglov
 * @version dated 23.12.2018
 */

public interface UserProfileRepository extends CommonRepository<UserProfile> {

    UserProfile findOneByUserId(String id);

    UserProfile findOneByUser(User user);

    UserProfile findOneByLogin(String login);

    boolean isEnabled(String login);

    boolean isExist(String login);

}
