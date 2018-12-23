package ru.shcheglov.repository.eav;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.eav.AdAttributeValue;
import ru.shcheglov.repository.common.AbstractRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

@Repository(AdAttributeValueRepositoryImpl.NAME)
public class AdAttributeValueRepositoryImpl extends AbstractRepository<AdAttributeValue> implements AdAttributeValueRepository {

    @NotNull
    public static final String NAME = "adAttributeValueRepository";

    @Override
    public void deleteOne(@NotNull final String id) {
        final Optional<AdAttributeValue> entity = findOne(id);
        entity.ifPresent(this::deleteOne);
    }

    @Override
    public void deleteAll() {
        getEntityManager()
                .createNamedQuery("AdAttributeValue.deleteAll", AdAttributeValue.class)
                .executeUpdate();
    }

    @Override
    public Optional<AdAttributeValue> findOne(@NotNull final String id) {
        return Optional.of(getEntityManager().find(AdAttributeValue.class, id));
    }

    @Override
    public List<AdAttributeValue> findAll() {
        return getEntityManager()
                .createNamedQuery("AdAttributeValue.findAll", AdAttributeValue.class)
                .getResultList();
    }

}
