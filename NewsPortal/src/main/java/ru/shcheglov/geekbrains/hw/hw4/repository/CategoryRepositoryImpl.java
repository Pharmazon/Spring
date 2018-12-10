package ru.shcheglov.geekbrains.hw.hw4.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.geekbrains.hw.hw4.entity.Category;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 10.12.2018
 */

@Repository(CategoryRepositoryImpl.NAME)
public class CategoryRepositoryImpl extends AbstractRepository<Category> implements CategoryRepository {

    @NotNull
    public static final String NAME = "categoryRepository";

    @Override
    public void save(@NotNull final Category entity) {
        super.save(entity);
    }

    @Override
    public void delete(@NotNull final String id) {
        final Category category = findOne(id);
        delete(category);
    }

    @Override
    public void delete(@NotNull final Category entity) {
        super.delete(entity);
    }

    @Override
    public void deleteAll() {
        entityManager
                .createNamedQuery("Category.deleteAll", Category.class)
                .executeUpdate();
    }

    @Override
    public Category findOne(@NotNull final String id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    public List<Category> findAll() {
        return entityManager
                .createNamedQuery("Category.findAll", Category.class)
                .getResultList();
    }

    @Override
    public Category update(@NotNull final Category entity) {
        return super.update(entity);
    }
}
