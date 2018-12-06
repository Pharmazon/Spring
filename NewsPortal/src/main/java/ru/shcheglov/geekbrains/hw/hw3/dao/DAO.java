package ru.shcheglov.geekbrains.hw.hw3.dao;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 06.12.2018
 */

public interface DAO<Entity, Key> {

    void create(Entity entity);

    Entity findOne(Key key);

    List<Entity> findByName(String name);

    void update(Entity entity);

    void delete(Key key);

    Long getCount();

    List<Entity> readAll();

    List<Entity> readPartlyFrom(int from, int quantity);

}
