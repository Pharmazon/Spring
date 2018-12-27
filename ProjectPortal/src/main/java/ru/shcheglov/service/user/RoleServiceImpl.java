package ru.shcheglov.service.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.dto.RoleDTO;
import ru.shcheglov.enums.UserRole;
import ru.shcheglov.model.user.Role;
import ru.shcheglov.repository.user.RoleRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

@Service(RoleServiceImpl.NAME)
@Transactional
public class RoleServiceImpl implements RoleService {

    @NotNull
    public static final String NAME = "roleService";

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void saveOne(@NotNull final Role entity) {
        roleRepository.saveOne(entity);
    }

    @Override
    public void saveAll(@NotNull final List<Role> list) {
        for (Role t : list) roleRepository.saveOne(t);
    }

    @Override
    public void deleteOne(@NotNull final String id) {
        roleRepository.deleteOne(id);
    }

    @Override
    public void deleteOne(@NotNull final Role entity) {
        roleRepository.deleteOne(entity);
    }

    @Override
    public void deleteAll() {
        roleRepository.deleteAll();
    }

    @Override
    public Optional<Role> getOne(@NotNull final String id) {
        return roleRepository.findOne(id);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role updateOne(@NotNull final Role entity) {
        return roleRepository.updateOne(entity);
    }

    @Override
    public void deleteOne(@NotNull final RoleDTO dto) {
        deleteOne(dto.getId());
    }

    @Override
    public void saveOne(@NotNull final RoleDTO dto) {
        final Optional<Role> optional = getOne(dto.getId());
        if (!optional.isPresent()) {
            final Role entity = new Role();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            saveOne(entity);
        }
    }

    @Override
    public Optional<Role> getRole(String role) {
        return roleRepository.findOneByName(role);
    }

    @Override
    public void createRole(@NotNull final String name) {
        final Role role = new Role();
        role.setName(name);
        roleRepository.saveOne(role);
    }

    @Override
    public void initRole(@NotNull final String name) {
        if (roleRepository.isExist(name)) return;
        createRole(name);
    }

    @Override
    public void initAllRoles() {
        for (UserRole role : UserRole.values()) {
            initRole(role.name());
        }
    }
}
