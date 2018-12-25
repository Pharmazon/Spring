package ru.shcheglov.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.model.Category;
import ru.shcheglov.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 25.12.2018
 */

@Service(CategoryServiceImpl.NAME)
@Transactional
public class CategoryServiceImpl implements CategoryService<Category> {

    @NotNull
    public static final String NAME = "categoryService";

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void saveOne(@NotNull final Category entity) {
        categoryRepository.saveOne(entity);
    }

    @Override
    public void saveAll(@NotNull final List<Category> list) {
        for (Category t : list) categoryRepository.saveOne(t);
    }

    @Override
    public void deleteOne(@NotNull final String id) {
        categoryRepository.deleteOne(id);
    }

    @Override
    public void deleteOne(@NotNull final Category entity) {
        categoryRepository.deleteOne(entity);
    }

    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    @Override
    public Optional<Category> getOne(@NotNull final String id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateOne(@NotNull final Category entity) {
        return categoryRepository.updateOne(entity);
    }

    @Override
    public Optional<Category> getOneParent(String id) {
        return categoryRepository.findOneParent(id);
    }

}
