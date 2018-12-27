package ru.shcheglov.service.user;

import ru.shcheglov.dto.RoleDTO;
import ru.shcheglov.model.user.Role;
import ru.shcheglov.service.common.CommonService;

import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 22.12.2018
 */

public interface RoleService extends CommonService<Role, RoleDTO> {

    Optional<Role> getRole(String role);

}
