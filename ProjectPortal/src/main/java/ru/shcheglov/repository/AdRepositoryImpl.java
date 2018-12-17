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

@Repository(AdRepositoryImpl.NAME)
public class AdRepositoryImpl extends AbstractRepository<Ad> implements AdRepository {

    @NotNull
    public static final String NAME = "adRepository";

    @Override
    public void save(@NotNull final Ad model) {
        super.save(model);
    }

    @Override
    public void delete(@NotNull final String id) {
        final Optional<Ad> ad = findOne(id);
        ad.ifPresent(this::delete);
    }

    @Override
    public void delete(@NotNull final Ad model) {
        super.delete(model);
    }

    @Override
    public void deleteAll() {
        entityManager
                .createNamedQuery("Ad.deleteAll", Ad.class)
                .executeUpdate();
    }

    @Override
    public Optional<Ad> findOne(@NotNull final String id) {
        return Optional.of(entityManager.find(Ad.class, id));
    }

    @Override
    public List<Ad> findAll() {
        return entityManager
                .createNamedQuery("Ad.findAll", Ad.class)
                .getResultList();
    }

    @Override
    public Ad update(@NotNull final Ad model) {
        return super.update(model);
    }

    @Override
    public List<Ad> findAllByCompany(@NotNull final Company company) {
        return entityManager
                .createNamedQuery("Ad.findAllAdsByCompany", Ad.class)
                .setParameter("company", company)
                .getResultList();
    }

    @Override
    public List<Ad> findAllByCategory(@NotNull final Category model) {
        return entityManager
                .createNamedQuery("Ad.findAllAdsByCategory", Ad.class)
                .setParameter("category", model)
                .getResultList();
    }

}
