package ru.shcheglov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.shcheglov.config.ApplicationConfiguration;
import ru.shcheglov.service.user.UserService;

/**
 * @author Alexey Shcheglov
 * @version dated 16.12.2018
 */

public class Main {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        final PasswordEncoder encoder = context.getBean("passwordEncoder", PasswordEncoder.class);
//        UserService service = context.getBean("userService", UserService.class);

//        service.initUser("admin", "admin");
    }
}