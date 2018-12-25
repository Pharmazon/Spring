package ru.shcheglov.controller.user;

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
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 24.12.2018
 */

@Controller
public class ProfileController {

    @Autowired
    private UserProfileService service;

    @Autowired
    private AuthService authService;

    @GetMapping("/profile/profile-view")
    public String get(final Model model, final HttpServletRequest request) {
        final UserProfile user = authService.getUser(request);
        if (user == null) return "redirect:/login";
        model.addAttribute("user", user);
        return "profile/profile-view";
    }

    @GetMapping("/profile/profile-edit/{id}")
    public String edit(final Model model, @PathVariable("id") final String id) {
        final Optional<UserProfile> optional = service.getOne(id);
        optional.ifPresent(u -> model.addAttribute("user", u));
        return "profile/profile-edit";
    }

    @PostMapping("/profile/profile-save")
    public String save(
            HttpServletRequest request,
            @ModelAttribute("user") final UserProfile user,
            final BindingResult result
    ) {
        if (!result.hasErrors()) {
            final UserProfile userSession = authService.getUser(request);
            service.saveOne(userSession);
        }
        return "redirect:/profile/profile-view";
    }

}
