package ru.shcheglov.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Category;
import ru.shcheglov.model.user.Company;
import ru.shcheglov.repository.basic.AbstractRepository;
import ru.shcheglov.repository.basic.BasicRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

@Repository(AdRepository.NAME)
public class AdRepository extends AbstractRepository<Ad> implements BasicRepository<Ad> {

    @NotNull
    public static final String NAME = "adRepository";

    @Override
    public void delete(@NotNull final String id) {
        final Optional<Ad> ad = findOne(id);
        ad.ifPresent(this::delete);
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

    public List<Ad> findAllByCompany(@NotNull final Company company) {
        return null;
//        return entityManager
//                .createNamedQuery("Ad.findAllAdsByCompany", Ad.class)
//                .setParameter("company", company)
//                .getResultList();
    }

    public List<Ad> findAllByCategory(@NotNull final Category model) {
        return entityManager
                .createNamedQuery("Ad.findAllAdsByCategory", Ad.class)
                .setParameter("category", model)
                .getResultList();
    }

}
