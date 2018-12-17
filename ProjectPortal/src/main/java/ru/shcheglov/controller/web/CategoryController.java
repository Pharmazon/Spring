package ru.shcheglov.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.shcheglov.model.Category;
import ru.shcheglov.service.CategoryService;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 15.12.2018
 */

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("category-list")
    public String categoryList(final Model model) {
        final List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "category/category-list";
    }

    @GetMapping("category-add")
    public String categoryAdd(@ModelAttribute("category") final Category category, final Model model) {
        model.addAttribute("category", category);
        return "category/category-add";
    }

    @PostMapping("category-create")
    public String categoryCreate(final Category category, final BindingResult result) {
        if (!result.hasErrors()) categoryService.save(category);
        return "redirect:/category-list";
    }

    @PostMapping("category-save")
    public String categorySave(final Category category, final BindingResult result) {
        if (!result.hasErrors()) categoryService.update(category);
        return "redirect:/category-list";
    }

    @GetMapping("category-edit/{id}")
    public String categoryEdit(final Model model, @PathVariable("id") final String id) {
        final Optional<Category> category = categoryService.get(id);
        category.ifPresent(cat -> model.addAttribute("category", cat));
        return "category/category-edit";
    }

    @GetMapping("category-view/{id}")
    public String categoryView(final Model model, @PathVariable("id") final String id) {
        final Optional<Category> category = categoryService.get(id);
        category.ifPresent(a -> model.addAttribute("category", a));
        return "category/category-view";
    }

    @GetMapping("category-delete/{id}")
    public String categoryDelete(@PathVariable("id") final String id) {
        categoryService.delete(id);
        return "redirect:/category-list";
    }
}
