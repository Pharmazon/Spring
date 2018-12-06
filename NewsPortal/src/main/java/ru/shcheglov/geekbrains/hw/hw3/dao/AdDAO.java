package ru.shcheglov.geekbrains.hw.hw3.dao;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.geekbrains.hw.hw3.entity.Ad;
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
public class AdDAO implements DAO<Ad, String> {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(@NotNull final Ad ad) {
        entityManager.persist(ad);
    }

    public Ad findOne(@NotNull String id) {
        return entityManager.find(Ad.class, id);
    }

    public List<Ad> findByName(@NotNull final String name) {
        return entityManager.createQuery("SELECT e FROM Ad e WHERE e.name = :adName", Ad.class)
                .setParameter("adName", name)
                .getResultList();
    }

    public void update(@NotNull final Ad ad) {
        entityManager.merge(ad);
    }

    public void delete(@NotNull final String id) {
        @NotNull final Ad ad = entityManager.find(Ad.class, id);
        entityManager.remove(ad);
    }

    public Long getCount() {
        return entityManager
                .createQuery("SELECT COUNT(a) FROM Ad a", Long.class)
                .getSingleResult();
    }

    public List<Ad> readAll() {
        return entityManager
                .createQuery("SELECT a FROM Ad a", Ad.class)
                .getResultList();
    }

    public List<Ad> readPartlyFrom(final int from, final int quantity) {
        return entityManager
                .createQuery("SELECT a FROM Ad a", Ad.class)
                .setFirstResult(from)
                .setMaxResults(quantity)
                .getResultList();
    }
}
