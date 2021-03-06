package ru.shcheglov.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.shcheglov.model.user.Role;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.service.user.CompanyService;
import ru.shcheglov.service.user.RoleService;
import ru.shcheglov.service.user.UserProfileService;
import ru.shcheglov.service.user.UserService;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 23.12.2018
 */

@Controller
public class UserController {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/admin/user-list")
    public String list(final Model model) {
        final List<UserProfile> entities = userProfileService.getAll();
        model.addAttribute("users", entities);
        return "admin/user-list";
    }

    @PostMapping("/admin/user-create")
    public String create(final UserProfile entity, final BindingResult result) {
        if (!result.hasErrors()) userProfileService.saveOne(entity);
        return "redirect:/admin/user-list";
    }

    @GetMapping("/admin/user-edit/{id}")
    public String edit(final Model model, @PathVariable("id") final String id) {
        final Optional<UserProfile> optional = userProfileService.getOne(id);
        List<Role> roles = roleService.getAll();
        model.addAttribute("roles", roles);
        optional.ifPresent(u -> model.addAttribute("userProfile", u));
        return "admin/user-edit";
    }

    @PostMapping("/admin/user-save")
    public String save(final UserProfile entity, final BindingResult result) {
        System.out.println(entity);
        System.out.println(result);
        if (!result.hasErrors()) {
            userProfileService.updateOne(entity);
        }
        return "redirect:/admin/user-list";
    }

    @GetMapping("/admin/user-view/{id}")
    public String view(final Model model, @PathVariable("id") final String id) {
        final Optional<UserProfile> entity = userProfileService.getOne(id);
        entity.ifPresent(a -> model.addAttribute("user", a));
        return "admin/user-view";
    }

    @GetMapping("/admin/user-delete/{id}")
    public String delete(@PathVariable("id") final String id) {
        userProfileService.deleteOne(id);
        return "redirect:/admin/user-list";
    }

}
