package ru.shcheglov.service;

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
 * @version dated 19.12.2018
 */

@Service(UserService.NAME)
@Transactional
public class UserService implements BasicService<User, UserDTO> {

    @NotNull
    public static final String NAME = "userService";

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User entity) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<User> get(String id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void save(UserDTO dto) {

    }

    @Override
    public void delete(UserDTO dto) {

    }
}
