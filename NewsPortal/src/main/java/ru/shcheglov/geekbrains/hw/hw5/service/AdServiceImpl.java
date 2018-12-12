package ru.shcheglov.geekbrains.hw.hw5.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.geekbrains.hw.hw5.model.Ad;
import ru.shcheglov.geekbrains.hw.hw5.model.Category;
import ru.shcheglov.geekbrains.hw.hw5.model.Company;
import ru.shcheglov.geekbrains.hw.hw5.repository.AdRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 10.12.2018
 */

@Service(AdServiceImpl.NAME)
@Transactional
public class AdServiceImpl implements AdService {

    @NotNull
    public static final String NAME = "adService";

    @Autowired
    private AdRepository adRepository;

    @Override
    public List<Ad> get(Company company) {
        return adRepository.findAllByCompany(company);
    }

    @Override
    public List<Ad> get(Category category) {
        return adRepository.findAllByCategory(category);
    }

    @Override
    public void save(Ad model) {
        adRepository.save(model);
    }

    @Override
    public void delete(String id) {
        adRepository.delete(id);
    }

    @Override
    public void delete(Ad model) {
        adRepository.delete(model);
    }

    @Override
    public void deleteAll() {
        adRepository.deleteAll();
    }

    @Override
    public Optional<Ad> get(String id) {
        return adRepository.findOne(id);
    }

    @Override
    public List<Ad> getAll() {
        return adRepository.findAll();
    }

    @Override
    public Ad update(Ad entity) {
        return adRepository.update(entity);
    }

}
