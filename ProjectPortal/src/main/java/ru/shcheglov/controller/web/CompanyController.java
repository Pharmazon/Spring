package ru.shcheglov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.shcheglov.model.Company;
import ru.shcheglov.service.CompanyService;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 14.12.2018
 */

@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("company-list")
    public String companyList(final Model model) {
        final List<Company> companies = companyService.getAll();
        model.addAttribute("companies", companies);
        return "company-list";
    }

    @GetMapping("company-create")
    public String companyCreate(@ModelAttribute("model") final Model model) {
        final Company company = new Company();
//        company.setName(name);
//        company.setDescription(description);
//        company.setAddress(address);
//        model.addAttribute("company", company);
        companyService.save(company);
        return "redirect:/company-list";
    }

    @GetMapping("company-edit/{id}")
    public String companyEdit(final Model model, @PathVariable("id") final String id) {
        final Optional<Company> company = companyService.get(id);
        company.ifPresent(co -> model.addAttribute("company", co));
        return "company-edit";
    }

    @PostMapping("company-save")
    public String companySave(@ModelAttribute("company") final Company company, final BindingResult result) {
        if (!result.hasErrors()) companyService.update(company);
        return "redirect:/company-list";
    }

    @GetMapping("company-view/{id}")
    public String companyView(final Model model, @PathVariable("id") final String id) {
        final Optional<Company> company = companyService.get(id);
        company.ifPresent(a -> model.addAttribute("company", a));
        return "company-view";
    }

    @GetMapping("company-delete/{id}")
    public String companyDelete(@PathVariable("id") final String id) {
        companyService.delete(id);
        return "redirect:/company-list";
    }
}
