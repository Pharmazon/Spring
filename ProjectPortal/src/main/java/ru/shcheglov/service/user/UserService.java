package ru.shcheglov.service.user;

import ru.shcheglov.dto.UserDTO;
import ru.shcheglov.model.user.User;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.service.common.CommonService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alexey Shcheglov
 * @version dated 23.12.2018
 */

public interface UserService extends CommonService<User, UserDTO> {

    User getByLogin(String login);

    Boolean getEnabledByLogin(String login);

    void initUser(String login, String password);

    void createUser(String login, String password);

    Long countByLogin(String login);

    Boolean isExist(String login);

}
