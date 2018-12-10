package ru.shcheglov.geekbrains.hw.hw4.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.geekbrains.hw.hw4.entity.Category;
import ru.shcheglov.geekbrains.hw.hw4.repository.CategoryRepository;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 10.12.2018
 */

@Service(CategoryServiceImpl.NAME)
public class CategoryServiceImpl implements CategoryService {

    @NotNull
    public static final String NAME = "categoryService";

    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void save(Category entity) {
        categoryRepository.save(entity);
    }

    @Override
    @Transactional
    public void delete(String id) {
        categoryRepository.delete(id);
    }

    @Override
    @Transactional
    public void delete(Category entity) {
        categoryRepository.delete(entity);
    }

    @Override
    @Transactional
    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Category get(String id) {
        return categoryRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public Category update(Category entity) {
        return categoryRepository.update(entity);
    }
}
