package ru.shcheglov.service.user;

import org.jetbrains.annotations.NotNull;
import ru.shcheglov.dto.RoleDTO;
import ru.shcheglov.enums.UserRole;
import ru.shcheglov.model.user.Role;
import ru.shcheglov.service.common.CommonService;

import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 22.12.2018
 */

public interface RoleService extends CommonService<Role, RoleDTO> {

    Optional<Role> getRole(String role);

    void initRole(String name);

    void createRole(String name);

    void initAllRoles();

}
