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
import ru.shcheglov.model.Company;
import ru.shcheglov.service.AdService;
import ru.shcheglov.service.CategoryService;
import ru.shcheglov.service.CompanyService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
        return "ad/ad-list";
    }

    @GetMapping("ad-add")
    public String adAdd(final Ad ad, final Model model) {
        final List<Company> companies = companyService.getAll();
        final List<Category> categories = categoryService.getAll();
        model.addAttribute("companies", companies);
        model.addAttribute("categories", categories);
        model.addAttribute("ad", ad);
        return "ad/ad-add";
    }

    @PostMapping("ad-create")
    public String adCreate(final Ad ad, final BindingResult result) {
        ad.setDate(new Date());
        if (!result.hasErrors()) adService.save(ad);
        return "redirect:/ad-list";
    }

    @GetMapping("ad-edit/{id}")
    public String adEdit(final Model model, @PathVariable("id") final String id) {
        final Optional<Ad> ad = adService.get(id);
        ad.ifPresent(a -> model.addAttribute("ad", a));
        final List<Company> companies = companyService.getAll();
        final List<Category> categories = categoryService.getAll();
        model.addAttribute("companies", companies);
        model.addAttribute("categories", categories);
        return "ad/ad-edit";
    }

    @PostMapping("ad-save")
    public String adSave(final Ad ad, final BindingResult result) {
        if (!result.hasErrors()) adService.update(ad);
        return "redirect:/ad-list";
    }

    @GetMapping("ad-view/{id}")
    public String adView(final Model model, @PathVariable("id") final String id) {
        final Optional<Ad> ad = adService.get(id);
        ad.ifPresent(a -> model.addAttribute("ad", a));
        return "ad/ad-view";
    }

    @GetMapping("ad-delete/{id}")
    public String adDelete(@PathVariable("id") final String id) {
        adService.delete(id);
        return "redirect:/ad-list";
    }

}
