package ru.shcheglov.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Category;
import ru.shcheglov.repository.basic.AbstractRepository;
import ru.shcheglov.repository.basic.BasicRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

@Repository(CategoryRepository.NAME)
public class CategoryRepository extends AbstractRepository<Category> implements BasicRepository<Category> {

    @NotNull
    public static final String NAME = "categoryRepository";

    @Override
    public void delete(@NotNull final String id) {
        final Optional<Category> category = findOne(id);
        category.ifPresent(this::delete);
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

    public List<Ad> findAllAds(@NotNull final Category category) {
        return entityManager
                .createNamedQuery("Category.findAllAds", Ad.class)
                .setParameter("category", category)
                .getResultList();
    }
}
