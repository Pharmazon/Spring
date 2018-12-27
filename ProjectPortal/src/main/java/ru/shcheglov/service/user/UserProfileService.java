package ru.shcheglov.service.user;

import ru.shcheglov.dto.UserProfileDTO;
import ru.shcheglov.enums.UserRole;
import ru.shcheglov.model.user.Role;
import ru.shcheglov.model.user.User;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.service.common.CommonService;

/**
 * @author Alexey Shcheglov
 * @version dated 23.12.2018
 */

public interface UserProfileService extends CommonService<UserProfile, UserProfileDTO> {

    UserProfile getOneByUserId(String id);

    UserProfile getOneByUser(User user);

    Role getRole(UserProfile user);

    UserProfile getByLogin(String login);

    boolean getEnabledByLogin(String login);

    void initUser(String login, String password, UserRole userRole);

    void createUser(String login, String password, UserRole userRole);

    boolean isExist(String login);

}
