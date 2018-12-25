package ru.shcheglov.service.user;

import org.jetbrains.annotations.NotNull;
import ru.shcheglov.model.user.UserProfile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alexey Shcheglov
 * @version dated 25.12.2018
 */

public interface AuthService {

    UserProfile getUser(HttpServletRequest request);

}
