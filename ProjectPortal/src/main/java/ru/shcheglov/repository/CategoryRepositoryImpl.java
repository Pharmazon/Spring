package ru.shcheglov.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.Category;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
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
        final Optional<Category> category = findOne(id);
        category.ifPresent(this::delete);
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
    public Optional<Category> findOne(@NotNull final String id) {
        return Optional.of(entityManager.find(Category.class, id));
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
