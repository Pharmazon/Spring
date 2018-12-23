package ru.shcheglov.repository.common;

import org.springframework.data.repository.NoRepositoryBean;
import ru.shcheglov.model.common.AbstractEntity;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

public interface CommonRepository<T extends AbstractEntity> {

    List<T> getEntities(TypedQuery<T> query);

    T getEntity(TypedQuery<T> query);

    void saveOne(T model);

    void saveAll(List<T> list);

    T updateOne(T model);

    void deleteOne(T model);

    void deleteOne(String id);

    void deleteAll();

    Optional<T> findOne(String id);

    List<T> findAll();

}
