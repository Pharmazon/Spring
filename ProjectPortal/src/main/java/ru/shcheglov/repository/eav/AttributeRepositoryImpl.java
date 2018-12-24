package ru.shcheglov.repository.eav;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.eav.Attribute;
import ru.shcheglov.repository.common.AbstractRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

@Repository(AttributeRepositoryImpl.NAME)
public class AttributeRepositoryImpl extends AbstractRepository<Attribute> implements AttributeRepository {

    @NotNull
    public static final String NAME = "attributeRepository";

    @Override
    public void deleteOne(@NotNull final String id) {
        final Optional<Attribute> entity = findOne(id);
        entity.ifPresent(this::deleteOne);
    }

    @Override
    public void deleteAll() {
        getEntityManager()
                .createNamedQuery("Attribute.deleteAll", Attribute.class)
                .executeUpdate();
    }

    @Override
    public Optional<Attribute> findOne(@NotNull final String id) {
        return Optional.of(getEntityManager().find(Attribute.class, id));
    }

    @Override
    public List<Attribute> findAll() {
        return getEntityManager()
                .createNamedQuery("Attribute.findAll", Attribute.class)
                .getResultList();
    }
}
