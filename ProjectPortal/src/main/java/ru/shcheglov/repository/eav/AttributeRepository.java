package ru.shcheglov.repository.eav;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import ru.shcheglov.model.eav.Attribute;
import ru.shcheglov.repository.basic.AbstractRepository;
import ru.shcheglov.repository.basic.BasicRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

@Repository(AttributeRepository.NAME)
public class AttributeRepository extends AbstractRepository<Attribute> implements BasicRepository<Attribute> {

    @NotNull
    public static final String NAME = "attributeRepository";

    @Override
    public void delete(String id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<Attribute> findOne(String id) {
        return Optional.empty();
    }

    @Override
    public List<Attribute> findAll() {
        return null;
    }
}
