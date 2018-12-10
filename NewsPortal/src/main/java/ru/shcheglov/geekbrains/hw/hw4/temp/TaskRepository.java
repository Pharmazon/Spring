package ru.shcheglov.geekbrains.hw.hw4.temp;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import org.springframework.stereotype.Repository;
import ru.volnenko.enterprise.model.Project;
import ru.volnenko.enterprise.model.Task;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author Denis Volnenko
 */

@Repository(TaskRepository.NAME)
public class TaskRepository extends AbstractRepository<Task> {

    @NotNull
    public static final String NAME = "taskRepository";

    @Nullable
    public Task findOne(String id) {
        return entityManager.find(Task.class, id);
    }


    @NotNull
    public List<Project> findAll() {
        return entityManager.createNamedQuery(Task.QUERY_FIND_ALL, Project.class).getResultList();
    }

    public void removeById(final String id) {
        if (id == null || id.isEmpty()) return;
        entityManager.createNamedQuery(Task.QUERY_REMOVE_BY_ID, Project.class)
                .setParameter("id", id).executeUpdate();
    }

    @Nullable
    public Task getTaskById(@Nullable final String id) {
        if (id == null || id.isEmpty()) return null;

        @NotNull final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        @NotNull final CriteriaQuery<Task> criteriaQuery = criteriaBuilder.createQuery(Task.class);
        @NotNull final Root<Task> root = criteriaQuery.from(Task.class);

        @NotNull final Path<String> pathTaskId = root.get("id");
        @NotNull final ParameterExpression<String> parameterId = criteriaBuilder.parameter(String.class, "id");
        @NotNull final Predicate predicateById = criteriaBuilder.equal(pathTaskId, parameterId);
        criteriaQuery.where(predicateById);

        @NotNull final TypedQuery<Task> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setParameter("id", id);
        typedQuery.setMaxResults(1);
        return getEntity(typedQuery);
    }

    @NotNull
    public List<String> getListTaskId() {
        @NotNull final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        @NotNull final CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        @NotNull final Root<Task> root = criteriaQuery.from(Task.class);
        criteriaQuery.multiselect(root.get("id"));
        @NotNull final TypedQuery<String> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @NotNull
    public List<Task> getListTask() {
        @NotNull final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        @NotNull final CriteriaQuery<Task> criteriaQuery = criteriaBuilder.createQuery(Task.class);
        @NotNull final TypedQuery<Task> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @NotNull
    public Long getCountTask() {
        @NotNull final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        @NotNull final CriteriaQuery<Long> query = builder.createQuery(Long.class);
        @NotNull final Root<Task> root = query.from(Task.class);
        query.select(builder.count(root));
        return entityManager.createQuery(query).getSingleResult();
    }

    public void removeAll() {
        entityManager.createQuery("DELETE FROM Task e").executeUpdate();
    }


}
