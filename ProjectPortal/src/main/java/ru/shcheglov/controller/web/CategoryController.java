package ru.shcheglov.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.shcheglov.model.Category;
import ru.shcheglov.service.CategoryService;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 25.12.2018
 */

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/category-list")
    public String list(final Model model) {
        final List<Category> entities = categoryService.getAll();
        model.addAttribute("categories", entities);
        return "admin/category-list";
    }

    @GetMapping("/admin/category-add")
    public String add(final Category entity, final Model model) {
        final List<Category> entities = categoryService.getAll();
        model.addAttribute("categories", entities);
        model.addAttribute("category", entity);
        return "admin/category-add";
    }

    @PostMapping("/admin/category-create")
    public String create(final Category entity, final BindingResult result) {
        System.out.println(entity);
        if (!result.hasErrors()) categoryService.saveOne(entity);
        return "redirect:/admin/category-list";
    }

    @GetMapping("/admin/category-edit/{id}")
    public String edit(final Model model, @PathVariable("id") final String id) {
        final Optional<Category> optional = categoryService.getOne(id);
        final List<Category> entities = categoryService.getAll();
        model.addAttribute("categories", entities);
        optional.ifPresent(a -> model.addAttribute("category", a));
        return "admin/category-edit";
    }

    @PostMapping("/admin/category-save")
    public String save(final Category entity, final BindingResult result) {
        if (!result.hasErrors()) categoryService.updateOne(entity);
        return "redirect:/admin/category-list";
    }

    @GetMapping("/admin/category-delete/{id}")
    public String delete(@PathVariable("id") final String id) {
        categoryService.deleteOne(id);
        return "redirect:/admin/category-list";
    }
}
