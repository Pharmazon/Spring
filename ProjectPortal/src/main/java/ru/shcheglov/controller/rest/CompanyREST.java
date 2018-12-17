package ru.shcheglov.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shcheglov.dto.*;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Company;
import ru.shcheglov.service.CompanyService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Alexey Shcheglov
 * @version dated 17.12.2018
 */

@RestController
@RequestMapping("CompanyService")
public class CompanyREST {

    @Autowired
    private CompanyService companyService;

    @GetMapping(value = "ping", produces = "application/json")
    public ResultDTO ping() {
        return new ResultDTO();
    }

    @GetMapping(value = "createCompany", produces = "application/json")
    public CompanyDTO createAd() {
        try {
            final Company company = new Company();
            company.setName("8888");
            companyService.save(company);
            return new CompanyDTO(company);
        } catch (final Exception e) {
            return null;
        }
    }

    @GetMapping(value = "getCompanyList", produces = "application/json")
    public List<CompanyDTO> getCompanyList() {
        try {
            final List<Company> companies = companyService.getAll();
            return companies.stream()
                    .map(CompanyDTO::new)
                    .collect(Collectors.toList());
        } catch (final Exception e) {
            return Collections.emptyList();
        }
    }

    @GetMapping(value = "getCompanyById/{id}", produces = "application/json")
    public CompanyDTO getCompanyById(@PathVariable("id") final String id) {
        try {
            final Optional<Company> company = companyService.get(id);
            return company.map(CompanyDTO::new).orElse(null);
        } catch (final Exception e) {
            return null;
        }
    }

    @PostMapping(value = "mergeCompany", produces = "application/json", consumes = "application/json")
    public ResultDTO mergeCompany(final CompanyDTO dto) {
        try {
            companyService.save(dto);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

    @PostMapping(value = "mergeCompanies", produces = "application/json", consumes = "application/json")
    public ResultDTO mergeCompanies(final CompanyDTO[] dtos) {
        try {
            for (final CompanyDTO dto : dtos) companyService.save(dto);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

    @GetMapping(value = "deleteCompanyById/{id}", produces = "application/json")
    public ResultDTO deleteCompanyById(@PathVariable("id") final String id) {
        try {
            companyService.delete(id);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

    @PostMapping(value = "deleteCompany", produces = "application/json", consumes = "application/json")
    public ResultDTO deleteCompany(final CompanyDTO dto) {
        try {
            companyService.delete(dto);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

    @DeleteMapping(value = "deleteCompanies", produces = "application/json")
    public ResultDTO deleteCompanies(final CompanyDTO[] dtos) {
        try {
            for (final CompanyDTO dto : dtos) companyService.delete(dto);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

}
