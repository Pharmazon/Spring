package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.address.City;
import ru.shcheglov.repository.basic.AbstractRepository;
import ru.shcheglov.repository.basic.BasicRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(CityRepository.NAME)
public class CityRepository extends AbstractRepository<City> implements BasicRepository<City> {

    @NotNull
    public static final String NAME = "cityRepository";

    @Override
    public void save(City model) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(City model) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<City> findOne(String id) {
        return Optional.empty();
    }

    @Override
    public List<City> findAll() {
        return null;
    }

    @Override
    public City update(City model) {
        return null;
    }
}
