package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.address.Region;
import ru.shcheglov.repository.common.AbstractRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(RegionRepositoryImpl.NAME)
public class RegionRepositoryImpl extends AbstractRepository<Region> implements RegionRepository {

    @NotNull
    public static final String NAME = "regionRepository";

    @Override
    public void deleteOne(@NotNull final String id) {
        final Optional<Region> entity = findOne(id);
        entity.ifPresent(this::deleteOne);
    }

    @Override
    public void deleteAll() {
        getEntityManager()
                .createNamedQuery("Region.deleteAll", Region.class)
                .executeUpdate();
    }

    @Override
    public Optional<Region> findOne(@NotNull final String id) {
        return Optional.of(getEntityManager().find(Region.class, id));
    }

    @Override
    public List<Region> findAll() {
        return getEntityManager()
                .createNamedQuery("Region.findAll", Region.class)
                .getResultList();
    }
}
