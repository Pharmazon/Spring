package ru.shcheglov.geekbrains.hw.hw5.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.geekbrains.hw.hw5.model.Ad;
import ru.shcheglov.geekbrains.hw.hw5.model.Company;
import ru.shcheglov.geekbrains.hw.hw5.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 10.12.2018
 */

@Service(CompanyServiceImpl.NAME)
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @NotNull
    public static final String NAME = "companyService";

    private CompanyRepository companyRepository;

    @Override
    public Company get(Ad ad) {
        return companyRepository.findOneByAd(ad);
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

}
