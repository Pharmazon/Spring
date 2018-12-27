package ru.shcheglov.service.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.dto.UserProfileDTO;
import ru.shcheglov.enums.UserRole;
import ru.shcheglov.model.user.Role;
import ru.shcheglov.model.user.User;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.repository.user.RoleRepository;
import ru.shcheglov.repository.user.UserProfileRepository;
import ru.shcheglov.repository.user.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 23.12.2018
 */

@Service(UserProfileServiceImpl.NAME)
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @NotNull
    public static final String NAME = "userProfileService";

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public void saveOne(@NotNull final UserProfile entity) {
        userProfileRepository.saveOne(entity);
    }

    @Override
    public void saveAll(@NotNull final List<UserProfile> list) {
        for (UserProfile t : list) userProfileRepository.saveOne(t);
    }

    @Override
    public void deleteOne(@NotNull final String id) {
        userProfileRepository.deleteOne(id);
    }

    @Override
    public void deleteOne(@NotNull final UserProfile entity) {
        userProfileRepository.deleteOne(entity);
    }

    @Override
    public void deleteAll() {
        userProfileRepository.deleteAll();
    }

    @Override
    public Optional<UserProfile> getOne(@NotNull final String id) {
        return userProfileRepository.findOne(id);
    }

    @Override
    public List<UserProfile> getAll() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile updateOne(@NotNull final UserProfile entity) {
        return userProfileRepository.updateOne(entity);
    }

    @Override
    public void saveOne(@NotNull final UserProfileDTO dto) {
//        final Optional<User> optional = getOne(dto.getId());
//        if (!optional.isPresent()) {
//            final UserProfile entity = new UserProfile();
//            entity.setId(dto.getId());
//            entity.setName(dto.getName());
//            entity.setLogin(dto.getLogin());
//            saveOne(entity);
//        }
    }

    @Override
    public void deleteOne(@NotNull final UserProfileDTO dto) {
        deleteOne(dto.getId());
    }

    @Override
    public UserProfile getOneByUserId(@NotNull final String id) {
        return userProfileRepository.findOneByUserId(id);
    }

    @Override
    public UserProfile getOneByUser(@NotNull final User user) {
        return userProfileRepository.findOneByUser(user);
    }

    @Override
    public Role getRole(@NotNull final UserProfile user) {
        return user.getRole();
    }


    @Override
    public UserProfile getByLogin(@NotNull final String login) {
        return userProfileRepository.findOneByLogin(login);
    }

    @Override
    public boolean getEnabledByLogin(@NotNull final String login) {
        return userProfileRepository.isEnabled(login);
    }

    @Override
    public void initUser(
            @NotNull final String login,
            @NotNull final String password,
            @NotNull final UserRole userRole) {
        if (userRepository.isExist(login)) return;
        createUser(login, password, userRole);
    }

    @Override
    public void createUser(
            @NotNull final String login,
            @NotNull final String password,
            @NotNull final UserRole userRole) {
//        final String passwordHash = passwordEncoder.encode(password);
        final String passwordHash = password;
        final User user = new User();
        user.setLogin(login);
        user.setEnabled(true);
        user.setPassword(passwordHash);
        final Optional<Role> role = roleRepository.findOneByName(userRole.name());
        if (!role.isPresent()) {
            final Role newRole = new Role();
            newRole.setName(userRole.name());
            roleRepository.saveOne(newRole);
        }

        final UserProfile up = new UserProfile();
        role.ifPresent(up::setRole);
        up.setUser(user);
        up.setDateRegistered(LocalDateTime.now());
        
        userRepository.saveOne(user);
        userProfileRepository.saveOne(up);
    }

    @Override
    public boolean isExist(@NotNull final String login) {
        return userProfileRepository.isExist(login);
    }
}
