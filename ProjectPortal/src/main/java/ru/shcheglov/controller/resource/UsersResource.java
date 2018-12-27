package ru.shcheglov.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shcheglov.dto.*;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.service.user.UserProfileService;
import ru.shcheglov.service.user.UserService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexey Shcheglov
 * @version dated 27.12.2018
 */

@RestController
@RequestMapping("api/users")
public class UsersResource {

    @Autowired
    private UserService userService;

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping(produces = "application/json")
    public List<UserProfileDTO> get() {
        List<UserProfile> users = userProfileService.getAll();
        return users.stream()
                .map(UserProfileDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO post(final UserDTO dto) {
        userService.saveOne(dto);
        return new ResultDTO();
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO put(final UserDTO dto) {
        userService.saveOne(dto);
        return new ResultDTO();
    }

    @DeleteMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO delete(final UserDTO dto) {
        userService.deleteOne(dto);
        return new ResultDTO();
    }
}
