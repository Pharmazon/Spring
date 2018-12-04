package ru.shcheglov.geekbrains.lessons.lesson3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.shcheglov.geekbrains.lessons.lesson3.config.ApplicationConfiguration;
import ru.shcheglov.geekbrains.lessons.lesson3.dao.AuthorDAO;
import ru.shcheglov.geekbrains.lessons.lesson3.dao.DAO;
import ru.shcheglov.geekbrains.lessons.lesson3.entity.Article;
import ru.shcheglov.geekbrains.lessons.lesson3.entity.Author;
import ru.shcheglov.geekbrains.lessons.lesson3.entity.Category;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 02.12.2018
 */

public class Main {

    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        final DAO authorDAO = context.getBean("authorDAO", DAO.class);
        final DAO categoryDAO = context.getBean("categoryDAO", DAO.class);
        final DAO articleDAO = context.getBean("articleDAO", DAO.class);

        for (int i = 0; i < 50; i++) {
            Author author = new Author();
            author.setEmail(i + "author@yandex.ru");
            author.setFirstName("Vasya-" + i);
            author.setLastName("Pupkin" + i);
            authorDAO.create(author);

            Category category = new Category();
            category.setName("Cat-" + i);
            categoryDAO.create(category);

            Article article = new Article();
            article.setAuthor(author);
            article.setCategory(category);
            article.setTitle("title");
            article.setContent("content");
            article.setPublishedDate(Date.from(Instant.now()));
            articleDAO.create(article);
        }
    }
}
