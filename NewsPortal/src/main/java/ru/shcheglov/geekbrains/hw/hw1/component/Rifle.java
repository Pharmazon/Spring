package ru.shcheglov.geekbrains.hw.hw1.entity;

/**
 * @author Alexey Shcheglov
 * @version dated 29.11.2018
 */

public interface Rifle {

    void shoot();

    void setBullet(Bullet bullet);

    Bullet getBullet();
}
