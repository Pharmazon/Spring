package ru.shcheglov.service;

import ru.shcheglov.dto.AbstractDTO;
import ru.shcheglov.model.basic.AbstractEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

public interface BasicService<Entity extends AbstractEntity, DTO extends AbstractDTO> {

    void save(Entity entity);

    void delete(String id);

    void delete(Entity entity);

    void deleteAll();

    Optional<Entity> get(String id);

    List<Entity> getAll();

    Entity update(Entity entity);

    void save(DTO dto);

    void delete(DTO dto);

}
