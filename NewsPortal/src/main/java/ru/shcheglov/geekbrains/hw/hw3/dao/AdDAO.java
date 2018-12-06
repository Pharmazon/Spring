package ru.shcheglov.geekbrains.hw.hw3.dao;

import org.hibernate.Hibernate;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.geekbrains.hw.hw3.entity.Ad;

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

    public Ad read(@NotNull String id) {
        Ad ad = entityManager.find(Ad.class, id);
        if (ad != null) {
            Hibernate.initialize(ad.getCategory());
            Hibernate.initialize(ad.getCompany());
        }
        return ad;
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
