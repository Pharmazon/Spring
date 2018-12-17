package ru.shcheglov.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shcheglov.dto.CategoryDTO;
import ru.shcheglov.dto.CompanyDTO;
import ru.shcheglov.dto.ResultDTO;
import ru.shcheglov.model.Category;
import ru.shcheglov.model.Company;
import ru.shcheglov.service.CompanyService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexey Shcheglov
 * @version dated 17.12.2018
 */

@RestController
@RequestMapping("api/companies")
public class CompaniesResource {

    @Autowired
    private CompanyService companyService;

    @GetMapping(produces = "application/json")
    public List<CompanyDTO> get() {
        final List<Company> ads = companyService.getAll();
        return ads.stream()
                .map(CompanyDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO post(final CompanyDTO[] dtos) {
        for (final CompanyDTO dto : dtos) companyService.save(dto);
        return new ResultDTO();
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO put(final CompanyDTO[] dtos) {
        for (final CompanyDTO dto : dtos) companyService.save(dto);
        return new ResultDTO();
    }

    @DeleteMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO delete(final CompanyDTO[] dtos) {
        for (final CompanyDTO dto : dtos) companyService.delete(dto);
        return new ResultDTO();
    }

}
