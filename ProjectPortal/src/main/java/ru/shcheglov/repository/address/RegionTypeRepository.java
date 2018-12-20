package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.address.RegionType;
import ru.shcheglov.repository.basic.AbstractRepository;
import ru.shcheglov.repository.basic.BasicRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(RegionTypeRepository.NAME)
public class RegionTypeRepository extends AbstractRepository<RegionType> implements BasicRepository<RegionType> {

    @NotNull
    public static final String NAME = "regionTypeRepository";

    @Override
    public void save(RegionType model) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(RegionType model) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<RegionType> findOne(String id) {
        return Optional.empty();
    }

    @Override
    public List<RegionType> findAll() {
        return null;
    }

    @Override
    public RegionType update(RegionType model) {
        return null;
    }
}
