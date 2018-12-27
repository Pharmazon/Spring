package ru.shcheglov.bootstrap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.shcheglov.enums.UserRole;
import ru.shcheglov.model.Ad;
import ru.shcheglov.service.AdService;
import ru.shcheglov.service.CategoryService;
import ru.shcheglov.service.user.RoleService;
import ru.shcheglov.service.user.UserProfileService;

import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 24.12.2018
 */

@Component
public class Bootstrap implements InitializingBean {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private RoleService roleService;

    @Override
    public void afterPropertiesSet() throws Exception {
        roleService.initAllRoles();
        userProfileService.initUser("admin", "admin", UserRole.ADMINISTRATOR);
        userProfileService.initUser("test", "test", UserRole.USER);
        userProfileService.initUser("manager", "manager", UserRole.MANAGER);
    }

}
