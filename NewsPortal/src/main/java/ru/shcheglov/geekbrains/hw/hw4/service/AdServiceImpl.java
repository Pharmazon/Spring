package ru.shcheglov.geekbrains.hw.hw4.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.geekbrains.hw.hw4.entity.Ad;
import ru.shcheglov.geekbrains.hw.hw4.entity.Category;
import ru.shcheglov.geekbrains.hw.hw4.entity.Company;
import ru.shcheglov.geekbrains.hw.hw4.repository.AdRepository;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 10.12.2018
 */

@Service(AdServiceImpl.NAME)
public class AdServiceImpl implements AdService {

    @NotNull
    public static final String NAME = "adService";

    @Autowired
    private AdRepository adRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Ad> get(Company company) {
        return adRepository.findAllByCompany(company);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ad> get(Category category) {
        return adRepository.findAllByCategory(category);
    }

    @Override
    @Transactional
    public void save(Ad entity) {
        adRepository.save(entity);
    }

    @Override
    @Transactional
    public void delete(String id) {
        adRepository.delete(id);
    }

    @Override
    @Transactional
    public void delete(Ad entity) {
        adRepository.delete(entity);
    }

    @Override
    @Transactional
    public void deleteAll() {
        adRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Ad get(String id) {
        return adRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ad> getAll() {
        return adRepository.findAll();
    }

    @Override
    @Transactional
    public Ad update(Ad entity) {
        return adRepository.update(entity);
    }
}
