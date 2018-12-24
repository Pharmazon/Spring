package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.address.CityType;
import ru.shcheglov.repository.common.AbstractRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(CityTypeRepositoryImpl.NAME)
public class CityTypeRepositoryImpl extends AbstractRepository<CityType> implements CityTypeRepository {

    @NotNull
    public static final String NAME = "cityTypeRepository";

    @Override
    public void deleteOne(@NotNull final String id) {
        final Optional<CityType> entity = findOne(id);
        entity.ifPresent(this::deleteOne);
    }

    @Override
    public void deleteAll() {
        getEntityManager()
                .createNamedQuery("CityType.deleteAll", CityType.class)
                .executeUpdate();
    }

    @Override
    public Optional<CityType> findOne(@NotNull final String id) {
        return Optional.of(getEntityManager().find(CityType.class, id));
    }

    @Override
    public List<CityType> findAll() {
        return getEntityManager()
                .createNamedQuery("CityType.findAll", CityType.class)
                .getResultList();
    }
}
