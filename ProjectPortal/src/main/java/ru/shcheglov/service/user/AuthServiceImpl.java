package ru.shcheglov.service.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    private UserRepository userRepository;

    public UserProfile getUser(@NotNull final HttpServletRequest request) {
        final HttpSession session = request.getSession();
        final String userId = (String) session.getAttribute("userId");
        Optional<User> optional = userRepository.findOne(userId);
        return optional.map(user -> userProfileRepository.findOneByUser(user)).orElse(null);
    }
}