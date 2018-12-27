package ru.shcheglov.service.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.dto.RoleDTO;
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
    private RoleRepository repository;

    @Override
    public void saveOne(@NotNull final Role entity) {
        repository.saveOne(entity);
    }

    @Override
    public void saveAll(@NotNull final List<Role> list) {
        for (Role t : list) repository.saveOne(t);
    }

    @Override
    public void deleteOne(@NotNull final String id) {
        repository.deleteOne(id);
    }

    @Override
    public void deleteOne(@NotNull final Role entity) {
        repository.deleteOne(entity);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Optional<Role> getOne(@NotNull final String id) {
        return repository.findOne(id);
    }

    @Override
    public List<Role> getAll() {
        return repository.findAll();
    }

    @Override
    public Role updateOne(@NotNull final Role entity) {
        return repository.updateOne(entity);
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
        return repository.findRole(role);
    }
}
