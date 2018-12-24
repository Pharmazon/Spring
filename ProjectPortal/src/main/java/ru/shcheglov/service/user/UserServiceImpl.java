package ru.shcheglov.service.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.dto.UserDTO;
import ru.shcheglov.model.user.User;
import ru.shcheglov.repository.user.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 23.12.2018
 */

@Service(UserServiceImpl.NAME)
@Transactional
public class UserServiceImpl implements UserService {

    @NotNull
    public static final String NAME = "userService";

    @Autowired
    private UserRepository repository;

    @Override
    public void saveOne(User entity) {
        repository.saveOne(entity);
    }

    @Override
    public void saveAll(@NotNull final List<User> list) {
        for (User t : list) repository.saveOne(t);
    }

    @Override
    public void deleteOne(String id) {
        repository.deleteOne(id);
    }

    @Override
    public void deleteOne(User entity) {
        repository.deleteOne(entity);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Optional<User> getOne(String id) {
        return repository.findOne(id);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User updateOne(User entity) {
        return repository.updateOne(entity);
    }

    @Override
    public void saveOne(UserDTO dto) {
        final Optional<User> optional = getOne(dto.getId());
        if (!optional.isPresent()) {
            final User entity = new User();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setLogin(dto.getLogin());
            saveOne(entity);
        }
    }

    @Override
    public void deleteOne(UserDTO dto) {
        deleteOne(dto.getId());
    }

    @Override
    public User getByLogin(String login) {
        return repository.findByLogin(login);
    }

}
