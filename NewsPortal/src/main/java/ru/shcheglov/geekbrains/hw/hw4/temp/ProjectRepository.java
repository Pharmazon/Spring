package ru.shcheglov.geekbrains.hw.hw4.temp;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Repository;
import ru.volnenko.enterprise.model.Project;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Denis Volnenko
 */

@Repository(ProjectRepository.NAME)
public class ProjectRepository extends AbstractRepository<Project> {

    @NotNull
    public static final String NAME = "projectRepository";

    @NotNull
    public Project findOne(final String id) {
        return entityManager.find(Project.class, id);
    }

    @Nullable
    public Project getById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return getEntity(entityManager.createQuery("SELECT e FROM Project e WHERE e.id = :id ", Project.class)
                .setParameter("id", id)
                .setMaxResults(1));
    }

    @Nullable
    public Project getProjectById(final String id) {
        if (id == null || id.isEmpty()) return null;
        final TypedQuery<Project> query = entityManager.createNamedQuery(Project.QUERY_GET_BY_ID, Project.class);
        return getEntity(query.setParameter("id", id).setMaxResults(1));
    }


    @NotNull
    public List<Project> findAll() {
        return entityManager.createQuery("SELECT e FROM Project e", Project.class).getResultList();
    }

    @NotNull
    public Project removeById(final String id) {
        final Project project = findOne(id);
        entityManager.remove(project);
        return project;
    }

    public void removeAll() {
        entityManager.createQuery("DELETE FROM Project e").executeUpdate();
    }

}
