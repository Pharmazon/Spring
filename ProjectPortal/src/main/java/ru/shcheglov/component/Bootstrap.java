package ru.shcheglov.component;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.shcheglov.service.user.UserProfileService;
import ru.shcheglov.service.user.UserService;

/**
 * @author Alexey Shcheglov
 * @version dated 24.12.2018
 */

@Component
public class Bootstrap implements InitializingBean {

    @Autowired
    private UserProfileService userProfileService;

    @Override
    public void afterPropertiesSet() throws Exception {
        userProfileService.initUser("admin", "admin");
        userProfileService.initUser("test", "test");
    }

}
