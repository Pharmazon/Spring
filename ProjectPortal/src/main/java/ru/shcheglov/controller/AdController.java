package ru.shcheglov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Category;
import ru.shcheglov.model.Company;
import ru.shcheglov.service.AdService;
import ru.shcheglov.service.CategoryService;
import ru.shcheglov.service.CompanyService;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

@Controller
public class AdController {

    @Autowired
    private AdService adService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CompanyService companyService;

    @GetMapping("ad-list")
    public String adList(final Model model) {
        final List<Ad> ads = adService.getAll();
        model.addAttribute("ads", ads);
        return "ad-list";
    }

    @GetMapping("ad-create")
    public String adCreate() {
        final Company company = new Company();
        company.setName("Company Name");
        company.setDescription("Company description");
        company.setAddress("Company address");
        companyService.save(company);
        final Category category = new Category();
        category.setName("Новая категория");
        categoryService.save(category);
        final Ad ad = new Ad();
        ad.setCompany(company);
        ad.setCategory(category);
        ad.setName("New Ad");
        ad.setNumber("");
        ad.setContent("");
        adService.save(ad);
        return "redirect:/ad-list";
    }

    @GetMapping("ad-edit/{id}")
    public String adEdit(final Model model, @PathVariable("id") final String id) {
        final Optional<Ad> ad = adService.get(id);
        ad.ifPresent(a -> model.addAttribute("ad", a));
        return "ad-edit";
    }

    @PostMapping("ad-save")
    public String adSave(@ModelAttribute("ad") final Ad ad, final BindingResult result) {
        if (!result.hasErrors()) adService.update(ad);
        return "redirect:/ad-list";
    }

    @GetMapping("ad-view/{id}")
    public String adView(final Model model, @PathVariable("id") final String id) {
        final Optional<Ad> ad = adService.get(id);
        ad.ifPresent(a -> model.addAttribute("ad", a));
        return "ad-view";
    }

    @GetMapping("ad-delete/{id}")
    public String adDelete(@PathVariable("id") final String id) {
        adService.delete(id);
        return "redirect:/ad-list";
    }

}
