package ru.shcheglov.repository.user;

import ru.shcheglov.model.user.Role;
import ru.shcheglov.repository.common.CommonRepository;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

public interface RoleRepository extends CommonRepository<Role> {

    Role findUser();

}
