package ru.shcheglov.geekbrains.lessons.lesson3.dao;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.geekbrains.lessons.lesson3.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 03.12.2018
 */

@Repository
@Transactional
public class AuthorDAO implements DAO<Author, String> {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(@NotNull final Author author) {
        entityManager.persist(author);
    }

    public Author read(@NotNull String id) {
        return entityManager.find(Author.class, id);
    }

    public void update(Author author) {
        entityManager.refresh(author);
    }

    public void delete(@NotNull final String id) {
        @NotNull final Author author = entityManager.find(Author.class, id);
        entityManager.remove(author);
    }

    public void merge(@NotNull final Author author) {
        entityManager.merge(author);
    }

    public Long getCount() {
        return entityManager
                .createQuery("SELECT COUNT(a) FROM Author a", Long.class)
                .getSingleResult();
    }

    public List<Author> readAll() {
        return entityManager
                .createQuery("SELECT a FROM Author a", Author.class)
                .getResultList();
    }

    public List<Author> readPartlyFrom(final int from, final int quantity) {
        return entityManager
                .createQuery("SELECT a FROM Author a", Author.class)
                .setFirstResult(from)
                .setMaxResults(quantity)
                .getResultList();
    }
}
