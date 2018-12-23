package ru.shcheglov.repository.address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.address.StreetType;
import ru.shcheglov.repository.common.AbstractRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Repository(StreetTypeRepositoryImpl.NAME)
public class StreetTypeRepositoryImpl extends AbstractRepository<StreetType> implements StreetTypeRepository {

    @NotNull
    public static final String NAME = "streetTypeRepository";

    @Override
    public void deleteOne(@NotNull final String id) {
        final Optional<StreetType> entity = findOne(id);
        entity.ifPresent(this::deleteOne);
    }

    @Override
    public void deleteAll() {
        getEntityManager()
                .createNamedQuery("StreetType.deleteAll", StreetType.class)
                .executeUpdate();
    }

    @Override
    public Optional<StreetType> findOne(@NotNull final String id) {
        return Optional.of(getEntityManager().find(StreetType.class, id));
    }

    @Override
    public List<StreetType> findAll() {
        return getEntityManager()
                .createNamedQuery("StreetType.findAll", StreetType.class)
                .getResultList();
    }
}
