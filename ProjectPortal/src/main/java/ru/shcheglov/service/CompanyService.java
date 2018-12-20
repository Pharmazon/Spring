package ru.shcheglov.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.dto.CompanyDTO;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.user.Company;
import ru.shcheglov.repository.basic.BasicRepository;
import ru.shcheglov.repository.user.CompanyRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

@Service(CompanyService.NAME)
@Transactional
public class CompanyService implements BasicService<Company, CompanyDTO> {

    @NotNull
    public static final String NAME = "companyService";

    @Autowired
    private CompanyRepository companyRepository;

    public Company get(Ad ad) {
        return companyRepository.findOneByAd(ad);
    }

    public List<Ad> getAllAds(Company company) {
        return companyRepository.findAllAds(company);
    }

    @Override
    public void save(Company entity) {
        companyRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        companyRepository.delete(id);
    }

    @Override
    public void delete(Company entity) {
        companyRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        companyRepository.deleteAll();
    }

    @Override
    public Optional<Company> get(String id) {
        return companyRepository.findOne(id);
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company update(Company entity) {
        return companyRepository.update(entity);
    }

    @Override
    public void save(CompanyDTO dto) {
        final Optional<Company> optional = get(dto.getId());
        final Company company = optional.orElseGet(Company::new);
        company.setId(dto.getId());
        company.setName(dto.getName());
        company.setAddress(dto.getAddress());
        company.setDescription(dto.getDescription());
        save(company);
    }

    @Override
    public void delete(CompanyDTO dto) {
        delete(dto.getId());
    }

}
