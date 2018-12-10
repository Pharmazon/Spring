package ru.shcheglov.geekbrains.hw.hw4.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.geekbrains.hw.hw4.entity.Ad;
import ru.shcheglov.geekbrains.hw.hw4.entity.Company;
import ru.shcheglov.geekbrains.hw.hw4.repository.CompanyRepository;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 10.12.2018
 */

@Service(CompanyServiceImpl.NAME)
public class CompanyServiceImpl implements CompanyService {

    @NotNull
    public static final String NAME = "companyService";

    private CompanyRepository companyRepository;

    @Override
    @Transactional(readOnly = true)
    public Company get(Ad ad) {
        return companyRepository.findOneByAd(ad);
    }

    @Override
    @Transactional
    public void save(Company entity) {
        companyRepository.save(entity);
    }

    @Override
    @Transactional
    public void delete(String id) {
        companyRepository.delete(id);
    }

    @Override
    @Transactional
    public void delete(Company entity) {
        companyRepository.delete(entity);
    }

    @Override
    @Transactional
    public void deleteAll() {
        companyRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Company get(String id) {
        return companyRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    @Transactional
    public Company update(Company entity) {
        return companyRepository.update(entity);
    }
}
