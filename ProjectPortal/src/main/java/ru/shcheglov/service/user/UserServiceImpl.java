package ru.shcheglov.service.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.dto.UserDTO;
import ru.shcheglov.model.user.Role;
import ru.shcheglov.model.user.User;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.repository.user.UserProfileRepository;
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

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public void saveOne(User entity) {
        repository.saveOne(entity);
    }

    @Override
    public void saveAll(@NotNull final List<User> list) {
        for (User t : list) repository.saveOne(t);
    }

    @Override
    public void deleteOne(@NotNull final String id) {
        repository.deleteOne(id);
    }

    @Override
    public void deleteOne(@NotNull final User entity) {
        repository.deleteOne(entity);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Optional<User> getOne(@NotNull final String id) {
        return repository.findOne(id);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User updateOne(@NotNull final User entity) {
        return repository.updateOne(entity);
    }

    @Override
    public void saveOne(@NotNull final UserDTO dto) {
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
    public void deleteOne(@NotNull final UserDTO dto) {
        deleteOne(dto.getId());
    }


    @Override
    public Long countByLogin(@NotNull final String login) {
        return repository.countByLogin(login);
    }

    @Override
    public boolean isExist(String login) {
        return repository.isExist(login);
    }

    @Override
    public Role getRole(@NotNull final User user) {
        final UserProfile profile = userProfileRepository.findOneByUser(user);
        return profile.getRole();
    }

    @Override
    public Role getRoleByUserId(@NotNull final String id) {
        Optional<User> user = repository.findOne(id);
        return user
                .map(us -> userProfileRepository.findOneByUser(us).getRole())
                .orElse(null);
    }

}
