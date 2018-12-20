package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.address.StreetType;
import ru.shcheglov.repository.basic.AbstractRepository;
import ru.shcheglov.repository.basic.BasicRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(StreetTypeRepository.NAME)
public class StreetTypeRepository extends AbstractRepository<StreetType> implements BasicRepository<StreetType> {

    @NotNull
    public static final String NAME = "streetTypeRepository";

    @Override
    public void save(StreetType model) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(StreetType model) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<StreetType> findOne(String id) {
        return Optional.empty();
    }

    @Override
    public List<StreetType> findAll() {
        return null;
    }

    @Override
    public StreetType update(StreetType model) {
        return null;
    }
}
