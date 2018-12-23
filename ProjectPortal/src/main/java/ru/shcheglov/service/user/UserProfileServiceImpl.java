package ru.shcheglov.service.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.dto.UserProfileDTO;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.repository.user.UserProfileRepository;

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
    private UserProfileRepository repository;

    @Override
    public void saveOne(UserProfile entity) {
        repository.saveOne(entity);
    }

    @Override
    public void saveAll(@NotNull final List<UserProfile> list) {
        for (UserProfile t : list) repository.saveOne(t);
    }

    @Override
    public void deleteOne(String id) {
        repository.deleteOne(id);
    }

    @Override
    public void deleteOne(UserProfile entity) {
        repository.deleteOne(entity);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Optional<UserProfile> getOne(String id) {
        return repository.findOne(id);
    }

    @Override
    public List<UserProfile> getAll() {
        return repository.findAll();
    }

    @Override
    public UserProfile updateOne(UserProfile entity) {
        return repository.updateOne(entity);
    }

    @Override
    public void saveOne(UserProfileDTO dto) {

    }

    @Override
    public void deleteOne(UserProfileDTO dto) {
        deleteOne(dto.getId());
    }

}
