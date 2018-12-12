package ru.shcheglov.geekbrains.hw.hw5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import ru.shcheglov.geekbrains.hw.hw5.model.Ad;
import ru.shcheglov.geekbrains.hw.hw5.model.Category;
import ru.shcheglov.geekbrains.hw.hw5.model.Company;
import ru.shcheglov.geekbrains.hw.hw5.service.AdService;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 12.12.2018
 */

@Controller
public class AdController {

    @Autowired
    private AdService adService;

    @GetMapping("ad-list")
    public String adList(final Model model) {
        final List<Ad> ads = adService.getAll();
        model.addAttribute("ads", ads);
        return "ad-list";
    }

    @GetMapping("ad-create")
    public String adCreate() {
        final Category category = new Category();
        category.setName("");
        final Company company = new Company();
        company.setName("");
        company.setDescription("");
        company.setAddress("");
        final Ad ad = new Ad();
        ad.setCategory(category);
        ad.setCompany(company);
        ad.setName("");
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

    @GetMapping("ad-save")
    public String adSave(@ModelAttribute("ad") final Ad ad, final BindingResult result) {
        if (!result.hasErrors()) adService.save(ad);
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
