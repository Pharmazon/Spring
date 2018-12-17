package ru.shcheglov.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Category;
import ru.shcheglov.model.Company;

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
    public void save(@NotNull final Category model) {
        super.save(model);
    }

    @Override
    public void delete(@NotNull final String id) {
        final Optional<Category> category = findOne(id);
        category.ifPresent(this::delete);
    }

    @Override
    public void delete(@NotNull final Category model) {
        super.delete(model);
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
    public Category update(@NotNull final Category model) {
        return super.update(model);
    }

    @Override
    public List<Ad> findAllAds(@NotNull final Category category) {
        return entityManager
                .createNamedQuery("Category.findAllAds", Ad.class)
                .setParameter("category", category)
                .getResultList();
    }
}
