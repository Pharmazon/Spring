package ru.shcheglov.geekbrains.lessons.lesson3.dao;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.geekbrains.lessons.lesson3.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 03.12.2018
 */

@Repository
@Transactional
@Qualifier("article")
public class ArticleDAO implements DAO<Article, String> {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(@NotNull final Article article) {
        entityManager.persist(article);
    }

    public Article read(@NotNull String id) {
        return entityManager.find(Article.class, id);
    }

    public void update(Article article) {
        entityManager.refresh(article);
    }

    public void delete(@NotNull final String id) {
        @NotNull final Article article = entityManager.find(Article.class, id);
        entityManager.remove(article);
    }

    public void merge(@NotNull final Article article) {
        entityManager.merge(article);
    }

    public Long getCount() {
        return entityManager
                .createQuery("SELECT COUNT(a) FROM Article a", Long.class)
                .getSingleResult();
    }

    public List<Article> readAll() {
        return entityManager
                .createQuery("SELECT a FROM Article a", Article.class)
                .getResultList();
    }

    public List<Article> readPartlyFrom(final int from, final int quantity) {
        return entityManager
                .createQuery("SELECT a FROM Article a", Article.class)
                .setFirstResult(from)
                .setMaxResults(quantity)
                .getResultList();
    }
}
