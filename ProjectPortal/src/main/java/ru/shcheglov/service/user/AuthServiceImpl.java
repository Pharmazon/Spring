package ru.shcheglov.service.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.model.user.Role;
import ru.shcheglov.model.user.User;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.repository.user.UserProfileRepository;
import ru.shcheglov.repository.user.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 25.12.2018
 */

@Service(AuthServiceImpl.NAME)
@Transactional
public class AuthServiceImpl implements AuthService {

    @NotNull
    public static final String NAME = "authService";

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile getUser(@NotNull final HttpServletRequest request) {
        final HttpSession session = request.getSession();
        final String userId = (String) session.getAttribute("userId");
        return userProfileRepository.findOneByUserId(userId);
    }

    @Override
    public Role getUserRole(@NotNull final UserProfile up) {
        return up.getRole();
    }

}
