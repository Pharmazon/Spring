package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.address.Street;
import ru.shcheglov.repository.common.AbstractRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(StreetRepositoryImpl.NAME)
public class StreetRepositoryImpl extends AbstractRepository<Street> implements StreetRepository {

    @NotNull
    public static final String NAME = "streetRepository";

    @Override
    public void deleteOne(@NotNull final String id) {
        final Optional<Street> entity = findOne(id);
        entity.ifPresent(this::deleteOne);
    }

    @Override
    public void deleteAll() {
        getEntityManager()
                .createNamedQuery("Street.deleteAll", Street.class)
                .executeUpdate();
    }

    @Override
    public Optional<Street> findOne(@NotNull final String id) {
        return Optional.of(getEntityManager().find(Street.class, id));
    }

    @Override
    public List<Street> findAll() {
        return getEntityManager()
                .createNamedQuery("Street.findAll", Street.class)
                .getResultList();
    }
}
