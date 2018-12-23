package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.address.City;
import ru.shcheglov.repository.common.AbstractRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(CityRepositoryImpl.NAME)
public class CityRepositoryImpl extends AbstractRepository<City> implements CityRepository {

    @NotNull
    public static final String NAME = "cityRepository";

    @Override
    public void deleteOne(@NotNull final String id) {
        final Optional<City> entity = findOne(id);
        entity.ifPresent(this::deleteOne);
    }

    @Override
    public void deleteAll() {
        getEntityManager()
                .createNamedQuery("City.deleteAll", City.class)
                .executeUpdate();
    }

    @Override
    public Optional<City> findOne(@NotNull final String id) {
        return Optional.of(getEntityManager().find(City.class, id));
    }

    @Override
    public List<City> findAll() {
        return getEntityManager()
                .createNamedQuery("City.findAll", City.class)
                .getResultList();
    }
}
