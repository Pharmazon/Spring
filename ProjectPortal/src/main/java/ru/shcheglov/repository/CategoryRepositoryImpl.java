package ru.shcheglov.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.Category;
import ru.shcheglov.repository.common.AbstractRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

@Repository(CategoryRepositoryImpl.NAME)
public class CategoryRepositoryImpl extends AbstractRepository<Category> implements CategoryRepository {

    @NotNull
    public static final String NAME = "categoryRepository";

    @Override
    public void deleteOne(@NotNull final String id) {
        final Optional<Category> entity = findOne(id);
        entity.ifPresent(this::deleteOne);
    }

    @Override
    public void deleteAll() {
        getEntityManager()
                .createNamedQuery("Category.deleteAll", Category.class)
                .executeUpdate();
    }

    @Override
    public Optional<Category> findOne(@NotNull final String id) {
        return Optional.of(getEntityManager().find(Category.class, id));
    }

    @Override
    public List<Category> findAll() {
        return getEntityManager()
                .createNamedQuery("Category.findAll", Category.class)
                .getResultList();
    }

}
