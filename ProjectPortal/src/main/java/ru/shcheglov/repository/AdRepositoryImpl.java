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
        final Optional<Ad> entity = findOne(id);
        entity.ifPresent(this::deleteOne);
    }

    @Override
    public void deleteAll() {
        getEntityManager()
                .createNamedQuery("Ad.deleteAll", Ad.class)
                .executeUpdate();
    }

    @Override
    public Optional<Ad> findOne(@NotNull final String id) {
        return Optional.of(getEntityManager().find(Ad.class, id));
    }

    @Override
    public List<Ad> findAll() {
        return getEntityManager()
                .createNamedQuery("Ad.findAll", Ad.class)
                .getResultList();
    }

}
