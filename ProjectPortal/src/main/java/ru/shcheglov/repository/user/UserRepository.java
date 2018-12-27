package ru.shcheglov.repository.user;

import ru.shcheglov.model.user.User;
import ru.shcheglov.repository.common.CommonRepository;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

public interface UserRepository extends CommonRepository<User> {

    Long countByLogin(String login);

    boolean isExist(String login);

    User findOneByLogin(String login);

}
