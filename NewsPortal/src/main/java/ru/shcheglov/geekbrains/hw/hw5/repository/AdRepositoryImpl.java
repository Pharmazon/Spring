package ru.shcheglov.geekbrains.hw.hw5.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.geekbrains.hw.hw5.model.Ad;
import ru.shcheglov.geekbrains.hw.hw5.model.Category;
import ru.shcheglov.geekbrains.hw.hw5.model.Company;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 10.12.2018
 */

@Repository(AdRepositoryImpl.NAME)
public class AdRepositoryImpl extends AbstractRepository<Ad> implements AdRepository {

    @NotNull
    public static final String NAME = "adRepository";

    @Override
    public void save(@NotNull final Ad entity) {
        super.save(entity);
    }

    @Override
    public void delete(@NotNull final String id) {
        final Optional<Ad> ad = findOne(id);
        ad.ifPresent(this::delete);
    }

    @Override
    public void delete(@NotNull final Ad entity) {
        super.delete(entity);
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
    public Ad update(@NotNull final Ad entity) {
        return super.update(entity);
    }

    @Override
    public List<Ad> findAllByCompany(@NotNull final Company company) {
        return entityManager
                .createNamedQuery("Ad.findAllByCompany", Ad.class)
                .setParameter("company", company)
                .getResultList();
    }

    @Override
    public List<Ad> findAllByCategory(@NotNull final Category category) {
        return entityManager
                .createNamedQuery("Ad.findAllByCategory", Ad.class)
                .setParameter("category", category)
                .getResultList();
    }

}
