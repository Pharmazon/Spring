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
import ru.shcheglov.service.user.RoleService;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 22.12.2018
 */

@Controller
public class RoleController implements CommonController<Role> {

    @Autowired
    private RoleService service;

    @GetMapping("role-list")
    public String entityList(final Model model) {
        final List<Role> entities = service.getAll();
        model.addAttribute("roles", entities);
        return "role-list";
    }

    @GetMapping("role-add")
    public String entityAdd(final Role entity, final Model model) {
        model.addAttribute("role", entity);
        return "role-add";
    }

    @PostMapping("role-create")
    public String entityCreate(final Role entity, final BindingResult result) {
        if (!result.hasErrors()) service.saveOne(entity);
        return "redirect:/role-list";
    }

    @GetMapping("role-edit/{id}")
    public String entityEdit(final Model model, @PathVariable("id") final String id) {
        final Optional<Role> optional = service.getOne(id);
        optional.ifPresent(a -> model.addAttribute("role", a));
        return "role-edit";
    }

    @PostMapping("role-save")
    public String entitySave(final Role entity, final BindingResult result) {
        if (!result.hasErrors()) service.updateOne(entity);
        return "redirect:/role-list";
    }

    @GetMapping("role-view/{id}")
    public String entityView(final Model model, @PathVariable("id") final String id) {
        final Optional<Role> entity = service.getOne(id);
        entity.ifPresent(a -> model.addAttribute("role", a));
        return "role-view";
    }

    @GetMapping("role-delete/{id}")
    public String entityDelete(@PathVariable("id") final String id) {
        service.deleteOne(id);
        return "redirect:/role-list";
    }

}
