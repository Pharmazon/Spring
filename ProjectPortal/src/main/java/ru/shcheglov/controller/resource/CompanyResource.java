package ru.shcheglov.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shcheglov.dto.CompanyDTO;
import ru.shcheglov.dto.ResultDTO;
import ru.shcheglov.model.user.Company;
import ru.shcheglov.service.user.CompanyService;

import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 17.12.2018
 */

@RestController
@RequestMapping("api/company")
public class CompanyResource {

    @Autowired
    private CompanyService companyService;

    @GetMapping(value = "{id}", produces = "application/json")
    public CompanyDTO get(@PathVariable("id") final String id) {
        final Optional<Company> company = companyService.getOne(id);
        return company.map(CompanyDTO::new).orElse(null);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO post(final CompanyDTO dto) {
        companyService.saveOne(dto);
        return new ResultDTO();
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO put(final CompanyDTO dto) {
        companyService.saveOne(dto);
        return new ResultDTO();
    }

    @DeleteMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO delete(final CompanyDTO dto) {
        companyService.deleteOne(dto);
        return new ResultDTO();
    }

}
