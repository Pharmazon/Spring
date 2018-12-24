package ru.shcheglov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.shcheglov.config.ApplicationConfiguration;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.service.user.UserProfileService;

import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 16.12.2018
 */

public class Main {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        UserProfileService service = context.getBean("userProfileService", UserProfileService.class);
    }
}