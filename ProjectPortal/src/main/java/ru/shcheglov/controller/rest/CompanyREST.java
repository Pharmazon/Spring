package ru.shcheglov.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shcheglov.dto.CompanyDTO;
import ru.shcheglov.dto.FailDTO;
import ru.shcheglov.dto.ResultDTO;
import ru.shcheglov.dto.SuccessDTO;
import ru.shcheglov.model.user.Company;
import ru.shcheglov.service.user.CompanyService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Alexey Shcheglov
 * @version dated 17.12.2018
 */

//@RestController
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
            companyService.saveOne(company);
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
            final Optional<Company> company = companyService.getOne(id);
            return company.map(CompanyDTO::new).orElse(null);
        } catch (final Exception e) {
            return null;
        }
    }

    @PostMapping(value = "mergeCompany", produces = "application/json", consumes = "application/json")
    public ResultDTO mergeCompany(final CompanyDTO dto) {
        try {
            companyService.saveOne(dto);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

    @PostMapping(value = "mergeCompanies", produces = "application/json", consumes = "application/json")
    public ResultDTO mergeCompanies(final CompanyDTO[] dtos) {
        try {
            for (final CompanyDTO dto : dtos) companyService.saveOne(dto);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

    @GetMapping(value = "deleteCompanyById/{id}", produces = "application/json")
    public ResultDTO deleteCompanyById(@PathVariable("id") final String id) {
        try {
            companyService.deleteOne(id);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

    @PostMapping(value = "deleteCompany", produces = "application/json", consumes = "application/json")
    public ResultDTO deleteCompany(final CompanyDTO dto) {
        try {
            companyService.deleteOne(dto);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

    @DeleteMapping(value = "deleteCompanies", produces = "application/json")
    public ResultDTO deleteCompanies(final CompanyDTO[] dtos) {
        try {
            for (final CompanyDTO dto : dtos) companyService.deleteOne(dto);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

}
