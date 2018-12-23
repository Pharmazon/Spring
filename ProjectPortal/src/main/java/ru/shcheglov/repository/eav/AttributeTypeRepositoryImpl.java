package ru.shcheglov.repository.eav;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.eav.AttributeType;
import ru.shcheglov.repository.common.AbstractRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

@Repository(AttributeTypeRepositoryImpl.NAME)
public class AttributeTypeRepositoryImpl extends AbstractRepository<AttributeType> implements AttributeTypeRepository {

    @NotNull
    public static final String NAME = "attributeTypeRepository";

    @Override
    public void deleteOne(@NotNull final String id) {
        final Optional<AttributeType> entity = findOne(id);
        entity.ifPresent(this::deleteOne);
    }

    @Override
    public void deleteAll() {
        getEntityManager()
                .createNamedQuery("AttributeType.deleteAll", AttributeType.class)
                .executeUpdate();
    }

    @Override
    public Optional<AttributeType> findOne(@NotNull final String id) {
        return Optional.of(getEntityManager().find(AttributeType.class, id));
    }

    @Override
    public List<AttributeType> findAll() {
        return getEntityManager()
                .createNamedQuery("AttributeType.findAll", AttributeType.class)
                .getResultList();
    }

}
