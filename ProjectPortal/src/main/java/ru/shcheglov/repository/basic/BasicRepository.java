package ru.shcheglov.repository.basic;

import ru.shcheglov.model.basic.AbstractEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

public interface BasicRepository<Entity extends AbstractEntity> {

    void save(Entity model);

    void delete(String id);

    void delete(Entity model);

    void deleteAll();

    Optional<Entity> findOne(String id);

    List<Entity> findAll();

    Entity update(Entity model);

}
