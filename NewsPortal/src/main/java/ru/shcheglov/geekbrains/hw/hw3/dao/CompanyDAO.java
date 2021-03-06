package ru.shcheglov.geekbrains.hw.hw3.dao;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
public class CompanyDAO implements DAO<Company, String> {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(@NotNull final Company company) {
        entityManager.persist(company);
    }

    public Company findOne(@NotNull final String id) {
        return entityManager.find(Company.class, id);
    }

    public List<Company> findByName(@NotNull final String name) {
        return entityManager.createQuery("SELECT e FROM Company e WHERE e.name = :companyName", Company.class)
                .setParameter("companyName", name)
                .getResultList();
    }

    public void update(@NotNull final Company company) {
        entityManager.merge(company);
    }

    public void delete(@NotNull final String id) {
        @NotNull final Company company = entityManager.find(Company.class, id);
        entityManager.remove(company);
    }

    public Long getCount() {
        return entityManager
                .createQuery("SELECT COUNT(a) FROM Company a", Long.class)
                .getSingleResult();
    }

    public List<Company> readAll() {
        return entityManager
                .createQuery("SELECT a FROM Company a", Company.class)
                .getResultList();
    }

    public List<Company> readPartlyFrom(final int from, final int quantity) {
        return entityManager
                .createQuery("SELECT a FROM Company a", Company.class)
                .setFirstResult(from)
                .setMaxResults(quantity)
                .getResultList();
    }
}
