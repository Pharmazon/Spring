package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.address.CityType;
import ru.shcheglov.repository.basic.AbstractRepository;
import ru.shcheglov.repository.basic.BasicRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(CityTypeRepository.NAME)
public class CityTypeRepository extends AbstractRepository<CityType> implements BasicRepository<CityType> {

    @NotNull
    public static final String NAME = "cityTypeRepository";

    @Override
    public void save(CityType model) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(CityType model) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<CityType> findOne(String id) {
        return Optional.empty();
    }

    @Override
    public List<CityType> findAll() {
        return null;
    }

    @Override
    public CityType update(CityType model) {
        return null;
    }
}
