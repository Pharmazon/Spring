package ru.shcheglov.geekbrains.lessons.lesson3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.shcheglov.geekbrains.lessons.lesson3.config.ApplicationConfiguration;
import ru.shcheglov.geekbrains.lessons.lesson3.dao.AuthorDAO;
import ru.shcheglov.geekbrains.lessons.lesson3.dao.DAO;
import ru.shcheglov.geekbrains.lessons.lesson3.entity.Author;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 02.12.2018
 */

public class Main {

    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        final AuthorDAO authorDAO = context.getBean(AuthorDAO.class);

        Author author2 = new Author();
        author2.setFirstName("Ivan");
        author2.setLastName("Petrov");
        author2.setEmail("q@mail.ru");
        authorDAO.create(author2);

        Author author1 = new Author();
        author1.setFirstName("Olesya");
        author1.setLastName("Shcheglova");
        author1.setEmail("dffff@mail.ru");
        authorDAO.create(author1);

        List<Author> list = authorDAO.readAll();
        for (Author author : list) {
            System.out.println(author);
        }
    }
}
