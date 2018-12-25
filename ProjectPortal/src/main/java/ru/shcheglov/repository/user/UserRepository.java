package ru.shcheglov.repository.user;

import ru.shcheglov.model.user.User;
import ru.shcheglov.repository.common.CommonRepository;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

public interface UserRepository extends CommonRepository<User> {

    User findByLogin(String login);

    Boolean isEnabled(String login);

    Long countByLogin(String login);

    Boolean isExist(String login);

}
