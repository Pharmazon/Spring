package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.address.Street;
import ru.shcheglov.repository.basic.AbstractRepository;
import ru.shcheglov.repository.basic.BasicRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(StreetRepository.NAME)
public class StreetRepository extends AbstractRepository<Street> implements BasicRepository<Street> {

    @NotNull
    public static final String NAME = "streetRepository";

    @Override
    public void save(Street model) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(Street model) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<Street> findOne(String id) {
        return Optional.empty();
    }

    @Override
    public List<Street> findAll() {
        return null;
    }

    @Override
    public Street update(Street model) {
        return null;
    }
}
