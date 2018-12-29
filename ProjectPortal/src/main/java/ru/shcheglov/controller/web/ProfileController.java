package ru.shcheglov.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.service.user.AuthService;
import ru.shcheglov.service.user.UserProfileService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 24.12.2018
 */

@Controller
public class ProfileController {

    private final UserProfileService userProfileService;

    private final AuthService authService;

    @Autowired
    public ProfileController(UserProfileService userProfileService, AuthService authService) {
        this.userProfileService = userProfileService;
        this.authService = authService;
    }

    @GetMapping("/profile/profile-edit")
    public String edit(final Model model, final Principal principal) {
        final UserProfile userProfile = authService.getUser(principal);
        model.addAttribute("user", userProfile);
        return "profile/profile-edit";
    }

    @PostMapping("/profile/profile-save")
    public String save(
            @ModelAttribute("user") final UserProfile user,
            final BindingResult result
    ) {
        if (!result.hasErrors()) {
            userProfileService.updateOne(user);
        }
        return "redirect:/profile/profile-edit";
    }

}
