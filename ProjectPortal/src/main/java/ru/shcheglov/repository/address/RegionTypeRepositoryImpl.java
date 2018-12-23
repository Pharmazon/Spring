package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.address.RegionType;
import ru.shcheglov.repository.common.AbstractRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(RegionTypeRepositoryImpl.NAME)
public class RegionTypeRepositoryImpl extends AbstractRepository<RegionType> implements RegionTypeRepository {

    @NotNull
    public static final String NAME = "regionTypeRepository";

    @Override
    public void deleteOne(@NotNull final String id) {
        final Optional<RegionType> entity = findOne(id);
        entity.ifPresent(this::deleteOne);
    }

    @Override
    public void deleteAll() {
        getEntityManager()
                .createNamedQuery("RegionType.deleteAll", RegionType.class)
                .executeUpdate();
    }

    @Override
    public Optional<RegionType> findOne(@NotNull final String id) {
        return Optional.of(getEntityManager().find(RegionType.class, id));
    }

    @Override
    public List<RegionType> findAll() {
        return getEntityManager()
                .createNamedQuery("RegionType.findAll", RegionType.class)
                .getResultList();
    }
}
