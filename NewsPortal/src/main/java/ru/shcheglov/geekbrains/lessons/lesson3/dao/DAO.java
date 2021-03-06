package ru.shcheglov.geekbrains.lessons.lesson3.dao;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 03.12.2018
 */

public interface DAO<Entity, Key> {

    void create(Entity entity);

    Entity read(Key key);

    void update(Entity entity);

    void delete(Key key);

    void merge(Entity entity);

    Long getCount();

    List<Entity> readAll();

    List<Entity> readPartlyFrom(int from, int quantity);

}
