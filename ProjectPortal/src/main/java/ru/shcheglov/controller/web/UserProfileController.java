package ru.shcheglov.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.service.user.UserProfileService;

import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 24.12.2018
 */

@Controller
public class UserProfileController {

    @Autowired
    private UserProfileService service;

    @GetMapping("profile/{id}")
    public String entityGet(final Model model, @PathVariable("id") final String id) {
        Optional<UserProfile> optional = service.getOne(id);
        optional.ifPresent(u -> model.addAttribute("userProfile", u));
        return "profile/view";
    }

    @GetMapping("profile/edit/{id}")
    public String entityEdit(final Model model, @PathVariable("id") final String id) {
        final Optional<UserProfile> optional = service.getOne(id);
        optional.ifPresent(u -> model.addAttribute("userProfile", u));
        return "profile/edit";
    }

    @PostMapping("profile/save")
    public String entitySave(final UserProfile entity, final BindingResult result) {
        if (!result.hasErrors()) service.updateOne(entity);
        return "redirect:/profile/view";
    }

    @GetMapping("profile/view/{id}")
    public String entityView(final Model model, @PathVariable("id") final String id) {
        final Optional<UserProfile> entity = service.getOne(id);
        entity.ifPresent(a -> model.addAttribute("userProfile", a));
        return "profile/view";
    }

}
