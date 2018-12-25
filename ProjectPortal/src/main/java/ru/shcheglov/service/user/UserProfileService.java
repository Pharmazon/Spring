package ru.shcheglov.service.user;

import ru.shcheglov.dto.UserProfileDTO;
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

}
