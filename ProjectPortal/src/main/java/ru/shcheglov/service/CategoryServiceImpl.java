package ru.shcheglov.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.dto.CategoryDTO;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Category;
import ru.shcheglov.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

@Service(CategoryServiceImpl.NAME)
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @NotNull
    public static final String NAME = "categoryService";

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void save(Category entity) {
        categoryRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        categoryRepository.delete(id);
    }

    @Override
    public void delete(Category entity) {
        categoryRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    @Override
    public Optional<Category> get(String id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category update(Category entity) {
        return categoryRepository.update(entity);
    }

    @Override
    public void save(CategoryDTO dto) {
        final Optional<Category> optional = get(dto.getId());
        final Category category = optional.orElseGet(Category::new);
        category.setId(dto.getId());
        category.setName(dto.getName());
        save(category);
    }

    @Override
    public void delete(CategoryDTO dto) {
        delete(dto.getId());
    }

    @Override
    public List<Ad> getAllAds(Category category) {
        return categoryRepository.findAllAds(category);
    }
}
