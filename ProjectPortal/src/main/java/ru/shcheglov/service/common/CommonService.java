package ru.shcheglov.service.common;

import ru.shcheglov.dto.common.AbstractDTO;
import ru.shcheglov.model.common.AbstractEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 20.12.2018
 */

public interface CommonService<T extends AbstractEntity, D extends AbstractDTO<T>> {

    void saveOne(T entity);

    void saveAll(List<T> list);

    void deleteOne(String id);

    void deleteOne(T entity);

    void deleteAll();

    Optional<T> getOne(String id);

    List<T> getAll();

    T updateOne(T entity);

    void saveOne(D dto);

    void deleteOne(D dto);

}
