package ru.shcheglov.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.Ad;
import ru.shcheglov.repository.common.AbstractRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

@Repository(AdRepositoryImpl.NAME)
public class AdRepositoryImpl extends AbstractRepository<Ad> implements AdRepository {

    @NotNull
    public static final String NAME = "adRepository";

    @Override
    public void deleteOne(@NotNull final String id) {
        final Ad ad = getEntityManager().find(Ad.class, id);
        deleteOne(ad);
    }

    @Override
    public void deleteAll() {
        getEntityManager()
                .createNamedQuery("Ad.deleteAll", Ad.class)
                .executeUpdate();
    }

    @Override
    public Optional<Ad> findOne(@NotNull final String id) {
        return Optional.ofNullable(getEntityManager()
                .createNamedQuery("Ad.findOne", Ad.class)
                .setParameter("adId", id)
                .getSingleResult());
    }

    @Override
    public List<Ad> findAll() {
        return getEntityManager()
                .createNamedQuery("Ad.findAll", Ad.class)
                .getResultList();
    }

}
