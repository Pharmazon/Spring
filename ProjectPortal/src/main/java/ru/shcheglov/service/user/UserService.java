package ru.shcheglov.service.user;

import ru.shcheglov.dto.UserDTO;
import ru.shcheglov.model.user.Role;
import ru.shcheglov.model.user.User;
import ru.shcheglov.service.common.CommonService;

/**
 * @author Alexey Shcheglov
 * @version dated 23.12.2018
 */

public interface UserService extends CommonService<User, UserDTO> {

    Long countByLogin(String login);

    boolean isExist(String login);

    Role getRole(User user);

    Role getRoleByUserId(String id);

}
