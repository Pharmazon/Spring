package ru.shcheglov.geekbrains.hw.hw3.dao;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.geekbrains.hw.hw3.entity.Category;
import ru.shcheglov.geekbrains.hw.hw3.entity.Company;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 06.12.2018
 */

@Repository
@Transactional
public class CategoryDAO implements DAO<Category, String> {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(@NotNull final Category category) {
        entityManager.persist(category);
    }

    public Category findOne(@NotNull String id) {
        return entityManager.find(Category.class, id);
    }

    public List<Category> findByName(@NotNull final String name) {
        return entityManager.createQuery("SELECT e FROM Category e WHERE e.name = :categoryName", Category.class)
                .setParameter("categoryName", name)
                .getResultList();
    }

    public void update(@NotNull final Category category) {
        entityManager.merge(category);
    }

    public void delete(@NotNull final String id) {
        @NotNull final Category category = entityManager.find(Category.class, id);
        entityManager.remove(category);
    }

    public Long getCount() {
        return entityManager
                .createQuery("SELECT COUNT(a) FROM Category a", Long.class)
                .getSingleResult();
    }

    public List<Category> readAll() {
        return entityManager
                .createQuery("SELECT a FROM Category a", Category.class)
                .getResultList();
    }

    public List<Category> readPartlyFrom(final int from, final int quantity) {
        return entityManager
                .createQuery("SELECT a FROM Category a", Category.class)
                .setFirstResult(from)
                .setMaxResults(quantity)
                .getResultList();
    }
}
