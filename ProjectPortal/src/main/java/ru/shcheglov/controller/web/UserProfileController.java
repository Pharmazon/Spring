package ru.shcheglov.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.shcheglov.controller.common.CommonController;
import ru.shcheglov.model.user.Role;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.service.user.RoleService;
import ru.shcheglov.service.user.UserProfileService;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 23.12.2018
 */

@Controller
public class UserProfileController implements CommonController<UserProfile> {

    @Autowired
    private UserProfileService service;

    @Autowired
    private RoleService roleService;

    @GetMapping("user-list")
    public String entityList(final Model model) {
        final List<UserProfile> entities = service.getAll();
        model.addAttribute("users", entities);
        return "user-list";
    }

    @Override
    public String entityAdd(UserProfile entity, Model model) {
        return null;
    }

    @PostMapping("user-create")
    public String entityCreate(final UserProfile entity, final BindingResult result) {
        if (!result.hasErrors()) service.saveOne(entity);
        return "redirect:/user-list";
    }

    @GetMapping("user-edit/{id}")
    public String entityEdit(final Model model, @PathVariable("id") final String id) {
        final Optional<UserProfile> optional = service.getOne(id);
        List<Role> roles = roleService.getAll();
        model.addAttribute("roles", roles);
        optional.ifPresent(u -> model.addAttribute("user", u));
        System.out.println(model);
        return "user-edit";
    }

    @PostMapping("user-save")
    public String entitySave(final UserProfile entity, final BindingResult result) {
        System.out.println(entity);
        if (!result.hasErrors()) service.updateOne(entity);
        return "redirect:/user-list";
    }

    @GetMapping("user-view/{id}")
    public String entityView(final Model model, @PathVariable("id") final String id) {
        final Optional<UserProfile> entity = service.getOne(id);
        entity.ifPresent(a -> model.addAttribute("user", a));
        return "user-view";
    }

    @GetMapping("user-delete/{id}")
    public String entityDelete(@PathVariable("id") final String id) {
        service.deleteOne(id);
        return "redirect:/user-list";
    }

}
