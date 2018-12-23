package ru.shcheglov.repository.basic;

import org.springframework.data.repository.NoRepositoryBean;
import ru.shcheglov.model.basic.AbstractEntity;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

@NoRepositoryBean
public interface CommonRepository<T extends AbstractEntity> {

    List<T> getEntities(TypedQuery<T> query);

    T getEntity(TypedQuery<T> query);

    void saveOne(T model);

    T updateOne(T model);

    void deleteOne(T model);

    void deleteOne(String id);

    void deleteAll();

    Optional<T> findOne(String id);

    List<T> findAll();

}
