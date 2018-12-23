package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.address.StreetName;
import ru.shcheglov.repository.common.AbstractRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(StreetNameRepositoryImpl.NAME)
public class StreetNameRepositoryImpl extends AbstractRepository<StreetName> implements StreetNameRepository {

    @NotNull
    public static final String NAME = "streetNameRepository";

    @Override
    public void deleteOne(@NotNull final String id) {
        final Optional<StreetName> entity = findOne(id);
        entity.ifPresent(this::deleteOne);
    }

    @Override
    public void deleteAll() {
        getEntityManager()
                .createNamedQuery("StreetName.deleteAll", StreetName.class)
                .executeUpdate();
    }

    @Override
    public Optional<StreetName> findOne(@NotNull final String id) {
        return Optional.of(getEntityManager().find(StreetName.class, id));
    }

    @Override
    public List<StreetName> findAll() {
        return getEntityManager()
                .createNamedQuery("StreetName.findAll", StreetName.class)
                .getResultList();
    }
}
