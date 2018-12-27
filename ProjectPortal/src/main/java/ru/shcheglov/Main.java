package ru.shcheglov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.shcheglov.config.ApplicationConfiguration;
import ru.shcheglov.model.user.User;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.service.user.UserProfileService;
import ru.shcheglov.service.user.UserService;

import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 16.12.2018
 */

public class Main {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
//        final PasswordEncoder encoder = context.getBean("passwordEncoder", PasswordEncoder.class);
        final UserProfileService service = context.getBean("userProfileService", UserProfileService.class);

        Optional<UserProfile> one = service.getOne("6294331a-4fa4-4b23-b180-d027554b8b71");
        System.out.println(one.get().getUser().getLogin());
    }
}