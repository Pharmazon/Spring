package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.address.Region;
import ru.shcheglov.repository.basic.AbstractRepository;
import ru.shcheglov.repository.basic.BasicRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(RegionRepository.NAME)
public class RegionRepository extends AbstractRepository<Region> implements BasicRepository<Region> {

    @NotNull
    public static final String NAME = "regionRepository";

    @Override
    public void save(Region model) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(Region model) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<Region> findOne(String id) {
        return Optional.empty();
    }

    @Override
    public List<Region> findAll() {
        return null;
    }

    @Override
    public Region update(Region model) {
        return null;
    }
}
