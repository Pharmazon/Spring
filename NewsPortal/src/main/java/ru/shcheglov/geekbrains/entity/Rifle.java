package ru.shcheglov.geekbrains.entity;

/**
 * @author Alexey Shcheglov
 * @version dated 29.11.2018
 */

public interface Rifle {

    void shoot();

    void setBullet(Bullet bullet);

    Bullet getBullet();
}
