package ru.shcheglov.service.user;

import ru.shcheglov.model.user.Role;
import ru.shcheglov.model.user.UserProfile;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author Alexey Shcheglov
 * @version dated 25.12.2018
 */

public interface AuthService {

    UserProfile getUser(Principal principal);

    Role getUserRole(UserProfile up);

}
