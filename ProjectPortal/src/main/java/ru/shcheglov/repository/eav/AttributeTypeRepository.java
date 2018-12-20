package ru.shcheglov.repository.eav;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.eav.AttributeType;
import ru.shcheglov.repository.basic.AbstractRepository;
import ru.shcheglov.repository.basic.BasicRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

@Repository(AttributeTypeRepository.NAME)
public class AttributeTypeRepository extends AbstractRepository<AttributeType> implements BasicRepository<AttributeType> {

    @NotNull
    public static final String NAME = "attributeTypeRepository";

    @Override
    public void delete(String id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<AttributeType> findOne(String id) {
        return Optional.empty();
    }

    @Override
    public List<AttributeType> findAll() {
        return null;
    }
}
