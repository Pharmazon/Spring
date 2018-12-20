package ru.shcheglov.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.dto.AdDTO;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Category;
import ru.shcheglov.model.user.Company;
import ru.shcheglov.model.user.User;
import ru.shcheglov.repository.AdRepository;
import ru.shcheglov.repository.CategoryRepository;
import ru.shcheglov.repository.user.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

@Service(AdService.NAME)
@Transactional
public class AdService implements BasicService<Ad, AdDTO> {

    @NotNull
    public static final String NAME = "adService";

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Ad> get(Company company) {
        return adRepository.findAllByCompany(company);
    }

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

    @Override
    public void delete(@NotNull final AdDTO dto) {
        delete(dto.getId());
    }

    @Override
    public void save(@NotNull final AdDTO dto) {
        final Optional<Ad> optional = get(dto.getId());
        final Ad ad = optional.orElseGet(Ad::new);
        ad.setId(dto.getId());
        ad.setName(dto.getName());
        ad.setContent(dto.getContent());
        ad.setPrice(dto.getPrice());
        ad.setDateTime(dto.getDateTime());
        final String categoryId = dto.getCategoryId();
        final Optional<Category> category = categoryRepository.findOne(categoryId);
        category.ifPresent(ad::setCategory);
        final String userId = dto.getUserId();
        final Optional<User> user = userRepository.findOne(userId);
        user.ifPresent(ad::setUser);
        save(ad);
    }

}
