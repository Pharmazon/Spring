package ru.shcheglov.geekbrains.hw.hw5.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.geekbrains.hw.hw5.model.Category;
import ru.shcheglov.geekbrains.hw.hw5.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 10.12.2018
 */

@Service(CategoryServiceImpl.NAME)
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @NotNull
    public static final String NAME = "categoryService";

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

}
