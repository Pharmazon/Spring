package ru.shcheglov.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Category;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.service.AdService;
import ru.shcheglov.service.CategoryService;
import ru.shcheglov.service.user.AuthService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 27.12.2018
 */

@Controller
public class AdController {

    @Autowired
    private AdService adService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AuthService authService;

    @GetMapping("/profile/ad-list")
    public String list(final Model model) {
        final List<Ad> entities = adService.getAll();
        model.addAttribute("ads", entities);
        return "profile/ad-list";
    }

    @GetMapping("/profile/ad-add")
    public String add(final Ad entity, final Model model) {
        final List<Ad> entities = adService.getAll();
        final List<Category> categories = categoryService.getAll();
        model.addAttribute("ad", entity);
        model.addAttribute("ads", entities);
        model.addAttribute("categories", categories);
        return "profile/ad-add";
    }

    @PostMapping("/profile/ad-create")
    public String create(final Ad entity, final Principal principal, final BindingResult result) {
        if (!result.hasErrors()) {
            entity.setDateTime(LocalDateTime.now());
            final UserProfile userProfile = authService.getUser(principal);
            entity.setUser(userProfile);
            adService.saveOne(entity);
        }
        return "redirect:/profile/ad-list";
    }

    @GetMapping("/profile/ad-edit/{id}")
    public String edit(final Model model, @PathVariable("id") final String id) {
        final Optional<Ad> optional = adService.getOne(id);
        final List<Ad> entities = adService.getAll();
        final List<Category> categories = categoryService.getAll();
        model.addAttribute("ads", entities);
        model.addAttribute("categories", categories);
        optional.ifPresent(a -> model.addAttribute("ad", a));
        return "profile/ad-edit";
    }

    @PostMapping("/profile/ad-save")
    public String save(final Ad entity, final BindingResult result) {
        if (!result.hasErrors()) adService.updateOne(entity);
        return "redirect:/profile/ad-list";
    }

    @GetMapping("/profile/ad-view/{id}")
    public String view(final Model model, @PathVariable("id") final String id) {
        final Optional<Ad> entity = adService.getOne(id);
        entity.ifPresent(a -> model.addAttribute("ad", a));
        return "profile/ad-view";
    }

    @GetMapping("/profile/ad-delete/{id}")
    public String delete(@PathVariable("id") final String id) {
        adService.deleteOne(id);
        return "redirect:/profile/ad-list";
    }
}
